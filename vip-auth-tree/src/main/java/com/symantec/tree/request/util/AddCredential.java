package com.symantec.tree.request.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;
import java.util.Random;

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
/**
 * 
 * @author Symantec
 * Add credentials using "AddCredentialRequest".
 *
 */
public class AddCredential {
	public static final Logger logger = LoggerFactory.getLogger(AddCredential.class);

	/**
	 * 
	 * @param userName
	 * @param credValue
	 * @param credIdType
	 * @return true if success, else false.
	 */
	public Boolean addCredential(String userName, String credValue, String credIdType) {

		HttpClientUtil clientUtil = new HttpClientUtil();
		HttpClient httpClient = clientUtil.getHttpClient();

		HttpPost post = new HttpPost(getURL());

		post.setHeader("CONTENT-TYPE", "text/xml; charset=ISO-8859-1");
		String payLoad = getViewUserPayload(userName, credValue, credIdType);
		logger.debug("Request Payload: " + payLoad);
		try {
			post.setEntity(new StringEntity(payLoad));

			logger.info("executing HTTP Request");
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

			if ("success".equalsIgnoreCase(statusMessage)) {
				return true;

			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 
	 * @param userName
	 * @param credValue
	 * @param credIdType
	 * @return AddCredentialRequest payload
	 */
	public static String getViewUserPayload(String userName, String credValue, String credIdType) {
		logger.info("getting payload for AddCredentialRequest");
		StringBuilder str = new StringBuilder();
		str.append(
				"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:vip=\"https://schemas.symantec.com/vip/2011/04/vipuserservices\">");
		str.append("<soapenv:Header/>");
		str.append("<soapenv:Body>");
		str.append("<vip:AddCredentialRequest>");
		str.append("<vip:requestId>" + new Random().nextInt(10) + 11111 + "</vip:requestId>");
		str.append("<vip:userId>" + userName + "</vip:userId>");
		str.append("<vip:credentialDetail>");
		str.append("<vip:credentialId>" + credValue + "</vip:credentialId>");
		str.append("<vip:credentialType>" + credIdType + "</vip:credentialType>");
		str.append("</vip:credentialDetail>");
		str.append("</vip:AddCredentialRequest>");
		str.append("</soapenv:Body>");
		str.append("</soapenv:Envelope>");
		return str.toString();

	}

	/**
	 * 
	 * @param userName
	 * @param credValue
	 * @param credIdType
	 * @param otpreceived
	 * @return true if success, else false
	 */
	public Boolean addCredential(String userName, String credValue, String credIdType, String otpreceived) {
		HttpClientUtil clientUtil = new HttpClientUtil();
		HttpClient httpClient = clientUtil.getHttpClient();

		HttpPost post = new HttpPost(getURL());

		post.setHeader("CONTENT-TYPE", "text/xml; charset=ISO-8859-1");
		String payLoad = getViewUserPayload(userName, credValue, credIdType, otpreceived);
		logger.debug("Request Payload: " + payLoad);
		try {
			post.setEntity(new StringEntity(payLoad));

			logger.info("executing http request of add credential with otp");
			HttpResponse response = httpClient.execute(post);
			HttpEntity entity = response.getEntity();

			logger.debug("Response Code : " + response.getStatusLine().getStatusCode());
            logger.info(response.getStatusLine().toString());
			String body = IOUtils.toString(entity.getContent());
			logger.debug("response body is:\t" + body);
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource src = new InputSource();
			src.setCharacterStream(new StringReader(body));
			Document doc = builder.parse(src);
			String status = doc.getElementsByTagName("status").item(0).getTextContent();
			String statusMessage = doc.getElementsByTagName("statusMessage").item(0).getTextContent();
			logger.debug("Status is:\t" + statusMessage);

			if ("success".equalsIgnoreCase(statusMessage)) {
				return true;

			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 
	 * @param userName
	 * @param credValue
	 * @param credIdType
	 * @param otpReceived
	 * @return AddCredentialRequest payload
	 */
	public static String getViewUserPayload(String userName, String credValue, String credIdType, String otpReceived) {

		logger.info("getting payload for AddCredentialRequest with otp");
		StringBuilder str = new StringBuilder();
		str.append(
				"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:vip=\"https://schemas.symantec.com/vip/2011/04/vipuserservices\">");
		str.append("<soapenv:Header/>");
		str.append("<soapenv:Body>");
		str.append("<vip:AddCredentialRequest>");
		str.append("<vip:requestId>" + new Random().nextInt(10) + 11111 + "</vip:requestId>");
		str.append("<vip:userId>" + userName + "</vip:userId>");
		str.append("<vip:credentialDetail>");
		str.append("<vip:credentialId>" + credValue + "</vip:credentialId>");
		str.append("<vip:credentialType>" + credIdType + "</vip:credentialType>");
		str.append("</vip:credentialDetail>");
		str.append("<vip:otpAuthData>");
		str.append("<vip:otp>" + otpReceived + "</vip:otp>");
		str.append("</vip:otpAuthData>");
		str.append("</vip:AddCredentialRequest>");
		str.append("</soapenv:Body>");
		str.append("</soapenv:Envelope>");
		return str.toString();

	}
	
	/**
	 * 
	 * @return ManagementServiceURL
	 */
	private String getURL() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("src/main/resources/vip.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty("ManagementServiceURL");
	}

}
