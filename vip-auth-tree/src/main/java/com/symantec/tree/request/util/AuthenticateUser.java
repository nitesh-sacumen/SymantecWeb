package com.symantec.tree.request.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.symantec.tree.config.Constants.VIPAuthStatusCode;

/**
 * 
 * @author Symantec 
 * Authenticate user using AuthenticateUserWithPushRequest
 *
 */
public class AuthenticateUser {

	static Logger logger = LoggerFactory.getLogger(AuthenticateUser.class);

	/**
	 * 
	 * @param userName
	 * @param displayMsgText
	 * @param displayMsgTitle
	 * @param displayMsgProfile
	 * @return transaction id if success alse, null
	 */
	public String authUser(String userName, String displayMsgText, String displayMsgTitle, String displayMsgProfile) {

		String transactionID = "";
		HttpClientUtil clientUtil = new HttpClientUtil();
		HttpClient httpClient = clientUtil.getHttpClient();

		HttpPost post = new HttpPost(getURL());

		post.setHeader("CONTENT-TYPE", "text/xml; charset=ISO-8859-1");
		String payLoad = getViewUserPayload(userName, displayMsgText, displayMsgTitle, displayMsgProfile);
		logger.debug("Request Payload: " + payLoad);
		try {
			post.setEntity(new StringEntity(payLoad));

			logger.info("executing http AuthenticateUserWithPushRequest");
			HttpResponse response = httpClient.execute(post);
			HttpEntity entity = response.getEntity();

			logger.debug("Response Code : " + response.getStatusLine().getStatusCode());
			logger.debug(response.getStatusLine().toString());
			String body = IOUtils.toString(entity.getContent());
			logger.debug("response body is:\t" + body);
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource src = new InputSource();
			src.setCharacterStream(new StringReader(body));
			Document doc = builder.parse(src);
			String status = doc.getElementsByTagName("status").item(0).getTextContent();
			String statusMessage = doc.getElementsByTagName("statusMessage").item(0).getTextContent();
			logger.debug("Status is:\t" + statusMessage);
			if (VIPAuthStatusCode.SUCCESS_CODE.equals(status)) {
				transactionID = doc.getElementsByTagName("transactionId").item(0).getTextContent();

			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return transactionID;
	}

	/**
	 * 
	 * @param userId
	 * @param displayMsgText
	 * @param displayMsgTitle
	 * @param displayMsgProfile
	 * @return AuthenticateUserWithPushRequest payload
	 */
	public static String getViewUserPayload(String userId, String displayMsgText, String displayMsgTitle,
			String displayMsgProfile) {
		logger.info("getting payload for AuthenticateUserWithPushRequest");
		StringBuilder str = new StringBuilder();
		str.append(
				"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:vip=\"https://schemas.symantec.com/vip/2011/04/vipuserservices\">");
		str.append("<soapenv:Header/>");
		str.append("<soapenv:Body>");
		str.append("<vip:AuthenticateUserWithPushRequest>");
		str.append("<vip:requestId>" + Math.round(Math.random() * 100000) + "</vip:requestId>");
		str.append("<!--Optional:-->");
		str.append("");
		str.append("<vip:userId>" + userId + "</vip:userId>");
		str.append("<!--Optional:-->");
		str.append("<vip:pushAuthData>");

		str.append("<!--0 to 20 repetitions:-->");
		str.append("<vip:displayParameters>");
		str.append("<vip:Key>" + "display.message.text" + "</vip:Key>");
		str.append("<vip:Value>" + displayMsgText + "</vip:Value>");
		str.append("");
		str.append("</vip:displayParameters>");

		str.append("<vip:displayParameters>");
		str.append("<vip:Key>" + "display.message.title" + "</vip:Key>");
		str.append("<vip:Value>" + displayMsgTitle + "</vip:Value>");
		str.append("");
		str.append("</vip:displayParameters>");

		str.append("<vip:displayParameters>");
		str.append("<vip:Key>" + "display.message.profile" + "</vip:Key>");
		str.append("<vip:Value>" + displayMsgProfile + "</vip:Value>");
		str.append("");
		str.append("</vip:displayParameters>");

		str.append("");
		str.append("</vip:pushAuthData>");
		str.append("</vip:AuthenticateUserWithPushRequest>");
		str.append("</soapenv:Body>");
		str.append("</soapenv:Envelope>");
		return str.toString();

	}

	/**
	 * 
	 * @return AuthenticationServiceURL
	 */
	private String getURL() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("src/main/resources/vip.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty("AuthenticationServiceURL");
	}

}
