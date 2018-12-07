package com.symantec.tree.request.util;

import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.forgerock.openam.auth.node.api.NodeProcessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.symantec.tree.config.Constants.VIPAuthStatusCode;

/**
 * 
 * @author Sacumen (www.sacumen.com) <br> <br>
 * 
 * Authenticate user using AuthenticateUserWithPushRequest
 *
 */
public class AuthenticateUser {

	static Logger logger = LoggerFactory.getLogger(AuthenticateUser.class);

	/**
	 * 
	 * @param userName User Name
	 * @param displayMsgText Display Message Text
	 * @param displayMsgTitle Display Message Title
	 * @param displayMsgProfile Display Message Profile
	 * @param key_store KeyStore file path
	 * @param key_store_pass KeyStore file password
	 * @return Transaction ID
	 * @throws NodeProcessException
	 */
	public String authUser(String userName, String displayMsgText, String displayMsgTitle, String displayMsgProfile,
			String key_store,String key_store_pass) throws NodeProcessException {
		
		//Constructing AuthenticateUserWithPushRequest 
        String transactionID = "";
		HttpClientUtil clientUtil = HttpClientUtil.getInstance();
		HttpPost post = new HttpPost(GetVIPServiceURL.getInstance().getAuthenticationServiceURL());
        post.setHeader("CONTENT-TYPE", "text/xml; charset=ISO-8859-1");
        
        //Getting payload of AuthenticateUserWithPushRequest
		String payLoad = getViewUserPayload(userName, displayMsgText, displayMsgTitle, displayMsgProfile);
		logger.debug("Request Payload: " + payLoad);
		try {
			
			//Calling AuthenticateUserWithPushRequest
			HttpClient httpClient = clientUtil.getHttpClientForgerock(key_store,key_store_pass);
			post.setEntity(new StringEntity(payLoad));
			
			//Getting response of AuthenticateUserWithPushRequest
			HttpResponse response = httpClient.execute(post);
			HttpEntity entity = response.getEntity();
			String body = IOUtils.toString(entity.getContent());
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource src = new InputSource();
			src.setCharacterStream(new StringReader(body));
			Document doc = builder.parse(src);
			
			//Getting status of AuthenticateUserWithPushRequest response
			String status = doc.getElementsByTagName("status").item(0).getTextContent();
			if (VIPAuthStatusCode.SUCCESS_CODE.equals(status)) {
				transactionID = doc.getElementsByTagName("transactionId").item(0).getTextContent();
			}
		} catch (IOException | ParserConfigurationException | SAXException e) {
			throw new NodeProcessException(e);
		}
		return transactionID;
	}

	/**
	 * 
	 * @param userName User Name
	 * @param displayMsgText Display Message Text
	 * @param displayMsgTitle Display Message Title
	 * @param displayMsgProfile Display Message Profile
	 * @return AuthenticateUserWithPushRequest payload
	 */
	private static String getViewUserPayload(String userId, String displayMsgText, String displayMsgTitle,
											 String displayMsgProfile) {
		logger.info("getting payload for AuthenticateUserWithPushRequest");

		return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
				"xmlns:vip=\"https://schemas.symantec.com/vip/2011/04/vipuserservices\">" +
				"<soapenv:Header/>" +
				"<soapenv:Body>" +
				"<vip:AuthenticateUserWithPushRequest>" +
				"<vip:requestId>" + Math.round(Math.random() * 100000) + "</vip:requestId>" +
				"<!--Optional:-->" +
				"" +
				"<vip:userId>" + userId + "</vip:userId>" +
				"<!--Optional:-->" +
				"<vip:pushAuthData>" +
				"<!--0 to 20 repetitions:-->" +
				"<vip:displayParameters>" +
				"<vip:Key>" + "display.message.text" + "</vip:Key>" +
				"<vip:Value>" + displayMsgText + "</vip:Value>" +
				"" +
				"</vip:displayParameters>" +
				"<vip:displayParameters>" +
				"<vip:Key>" + "display.message.title" + "</vip:Key>" +
				"<vip:Value>" + displayMsgTitle + "</vip:Value>" +
				"" +
				"</vip:displayParameters>" +
				"<vip:displayParameters>" +
				"<vip:Key>" + "display.message.profile" + "</vip:Key>" +
				"<vip:Value>" + displayMsgProfile + "</vip:Value>" +
				"" +
				"</vip:displayParameters>" +
				"" +
				"</vip:pushAuthData>" +
				"</vip:AuthenticateUserWithPushRequest>" +
				"</soapenv:Body>" +
				"</soapenv:Envelope>";
	}
}