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
 * @author Sacumen (www.sacumen.com) <br> <br> 
 * 
 * Add credentials using "AddCredentialRequest".
 *
 */
public class AddCredential {
	static Logger logger = LoggerFactory.getLogger(AddCredential.class);

	/**
	 * 
	 * @param userName User Name
	 * @param credValue Credential ID
	 * @param credIdType Credential Type
	 * @return status of AddCredentialRequest.
	 * @throws NodeProcessException
	 */
	public String addCredential(String userName, String credValue, String credIdType,String key_store,String key_store_pass) throws NodeProcessException {

		//Getting HttpClientUtil instance and preparing request
		HttpClientUtil clientUtil = HttpClientUtil.getInstance();
		HttpPost post = new HttpPost(GetVIPServiceURL.getInstance().getManagementServiceURL());
		post.setHeader("CONTENT-TYPE", "text/xml; charset=ISO-8859-1");
		
		// Getting request payload
		String payLoad = getViewUserPayload(userName, credValue, credIdType);
		logger.debug("Request Payload: " + payLoad);
		String status;
		try {
			
			//Calling AddCredentialRequest
			HttpClient httpClient = clientUtil.getHttpClientForgerock(key_store,key_store_pass);
			post.setEntity(new StringEntity(payLoad));
			
			// Getting response of AddCredentialRequest
			HttpResponse response = httpClient.execute(post);
			HttpEntity entity = response.getEntity();
			String body = IOUtils.toString(entity.getContent());
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource src = new InputSource();
			src.setCharacterStream(new StringReader(body));
			Document doc = builder.parse(src);
			
			//Getting status code of AddCredentialRequest response
			status = doc.getElementsByTagName("status").item(0).getTextContent();
		} 
		catch (IOException | ParserConfigurationException | SAXException e) {
			logger.error("failed to during AddCredentialRequest");
			throw new NodeProcessException(e);
		}

		return status;
	}
	

	/**
	 * 
	 * @param userName User Name
	 * @param credValue Credential ID
	 * @param credIdType Credential Type
	 * @return AddCredentialRequest payload
	 */
	private static String getViewUserPayload(String userName, String credValue, String credIdType) {
		logger.info("getting payload for AddCredentialRequest");
		return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" "
				+ "xmlns:vip=\"https://schemas.symantec.com/vip/2011/04/vipuserservices\">" + "<soapenv:Header/>"
				+ "<soapenv:Body>" + "<vip:AddCredentialRequest>" + "<vip:requestId>" + new Random().nextInt(10) + 11111
				+ "</vip:requestId>" + "<vip:userId>" + userName + "</vip:userId>" + "<vip:credentialDetail>"
				+ "<vip:credentialId>" + credValue + "</vip:credentialId>" + "<vip:credentialType>" + credIdType
				+ "</vip:credentialType>" + "</vip:credentialDetail>" + "</vip:AddCredentialRequest>"
				+ "</soapenv:Body>" + "</soapenv:Envelope>";

	}

	/**
	 * 
	 * @param userName User Name
	 * @param credValue Credential ID
	 * @param credIdType Credential Type
	 * @param otpreceived OTP
	 * @return status code of AddCredentialRequest
	 * @throws NodeProcessException
	 */
	public String addCredential(String userName, String credValue, String credIdType, String otpreceived,String key_store,String key_store_pass)
			throws NodeProcessException {
		
		//Preparing AddCredentialRequest 
		HttpClientUtil clientUtil = HttpClientUtil.getInstance();
		HttpPost post = new HttpPost(GetVIPServiceURL.getInstance().getManagementServiceURL());
        post.setHeader("CONTENT-TYPE", "text/xml; charset=ISO-8859-1");
        
        //Getting AddCredentialRequest payload
		String payLoad = getViewUserPayload(userName, credValue, credIdType, otpreceived);
		logger.debug("Request Payload: " + payLoad);
		String status;
		try {
			
			//Calling AddCredentialRequest
			HttpClient httpClient = clientUtil.getHttpClientForgerock(key_store,key_store_pass);
			post.setEntity(new StringEntity(payLoad));
			
			// Getting response of AddCredentialRequest
			HttpResponse response = httpClient.execute(post);
			HttpEntity entity = response.getEntity();
			String body = IOUtils.toString(entity.getContent());
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource src = new InputSource();
			src.setCharacterStream(new StringReader(body));
			Document doc = builder.parse(src);
			
			// Getting response status code of AddCredentialRequest
			status = doc.getElementsByTagName("status").item(0).getTextContent();
		} catch (IOException | ParserConfigurationException | SAXException e) {
			logger.error("failed to execute AddCredentialRequest");
			throw new NodeProcessException(e);
		}
		return status;
	}

	/**
	 * 
	 * @param userName User Name
	 * @param credValue Credential ID
	 * @param credIdType Credential Type
	 * @param otpReceived OTP
	 * @return AddCredentialRequest payload
	 */
	private static String getViewUserPayload(String userName, String credValue, String credIdType, String otpReceived) {

		logger.info("getting payload for AddCredentialRequest with otp");
		return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" "
				+ "xmlns:vip=\"https://schemas.symantec.com/vip/2011/04/vipuserservices\">" + "<soapenv:Header/>"
				+ "<soapenv:Body>" + "<vip:AddCredentialRequest>" + "<vip:requestId>" + new Random().nextInt(10) + 11111
				+ "</vip:requestId>" + "<vip:userId>" + userName + "</vip:userId>" + "<vip:credentialDetail>"
				+ "<vip:credentialId>" + credValue + "</vip:credentialId>" + "<vip:credentialType>" + credIdType
				+ "</vip:credentialType>" + "</vip:credentialDetail>" + "<vip:otpAuthData>" + "<vip:otp>" + otpReceived
				+ "</vip:otp>" + "</vip:otpAuthData>" + "</vip:AddCredentialRequest>" + "</soapenv:Body>"
				+ "</soapenv:Envelope>";

	}


}