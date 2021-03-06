package com.symantec.tree.request.util;

import java.io.IOException;
import java.io.StringReader;
import java.util.Random;

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

/**
 * 
 * @author Sacumen (www.sacumen.com)<br> <br>
 * 
 * getting status of poll push request using PollPushStatusRequest
 *
 */
public class AuthPollPush {

	static final Logger logger = LoggerFactory.getLogger(AuthPollPush.class);

	/**
	 * 
	 * @param authId Transaction ID
	 * @param key_store Keystore file path
	 * @param key_store_pass Keystore file password
	 * @return PollPushStatusRequest status code
	 * @throws NodeProcessException
	 */
	public String authPollPush(String authId,String key_store,String key_store_pass) throws NodeProcessException {

		//Constructing PollPushStatusRequest
		HttpClientUtil clientUtil = HttpClientUtil.getInstance();
		HttpPost post = new HttpPost(GetVIPServiceURL.getInstance().getQueryServiceURL());
		post.setHeader("CONTENT-TYPE", "text/xml; charset=ISO-8859-1");
		
		//Getting payload of PollPushStatusRequest
		String payLoad = getViewUserPayload(authId);
		logger.debug("Request Payload in authPollPush: " + payLoad);
		try {
			
			//Calling PollPushStatusRequest
			HttpClient httpClient = clientUtil.getHttpClientForgerock(key_store,key_store_pass);
			post.setEntity(new StringEntity(payLoad));
			
			//Getting response of PollPushStatusRequest
			HttpResponse response = httpClient.execute(post);
			HttpEntity entity = response.getEntity();
			String body = IOUtils.toString(entity.getContent());
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource src = new InputSource();
			src.setCharacterStream(new StringReader(body));
			Document doc = builder.parse(src);
			
			//Getting status code of PollPushStatusRequest response
			String status = doc.getElementsByTagName("status").item(1).getTextContent();
			return status;

		} catch (IOException | ParserConfigurationException | SAXException e) {
			throw new NodeProcessException(e);
		}
	}

	/**
	 * 
	 * @param authId Transaction ID
	 * @return PollPushStatusRequest payload
	 */
	private static String getViewUserPayload(String authId) {
		logger.info("getting payload for PollPushStatusRequest");
		return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
				"xmlns:vip=\"https://schemas.symantec.com/vip/2011/04/vipuserservices\">" +
				"<soapenv:Header/>" +
				"<soapenv:Body>" +
				"<vip:PollPushStatusRequest>" +
				"<vip:requestId>" + new Random().nextInt(10) + 11111 + "</vip:requestId>" +
				"<vip:transactionId>" + authId + "</vip:transactionId>" +
				"</vip:PollPushStatusRequest>" +
				"</soapenv:Body>" +
				"</soapenv:Envelope>";

	}

}