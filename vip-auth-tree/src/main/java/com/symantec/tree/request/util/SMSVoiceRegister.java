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
 * Executing RegisterRequest for SMS and Voice
 */
public class SMSVoiceRegister {
	static Logger logger = LoggerFactory.getLogger(SMSVoiceRegister.class);

	/**
	 * 
	 * @param credValue Phone Number
	 * @param key_store Keystore file path
	 * @param key_store_pass Keystore file password
	 * @return status code of RegisterRequest 
	 * @throws NodeProcessException
	 */
	public String smsRegister(String credValue,String key_store,String key_store_pass) throws NodeProcessException {
		
		//Constructing RegisterRequest
		HttpPost post = new HttpPost(GetVIPServiceURL.getInstance().getManagementServiceURL());
        post.setHeader("CONTENT-TYPE", "text/xml; charset=ISO-8859-1");
        
        //Getting RegisterRequest payload
		String payLoad = getSmsPayload(credValue);
		String status;
		logger.debug("Request Payload: " + payLoad);

		try {
			
			//Executing RegisterRequest
			HttpClient httpClient = HttpClientUtil.getInstance().getHttpClientForgerock(key_store,key_store_pass);
			post.setEntity(new StringEntity(payLoad));
			
			//Getting response of RegisterRequest
			HttpResponse response = httpClient.execute(post);
			HttpEntity entity = response.getEntity();
			String body = IOUtils.toString(entity.getContent());
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource src = new InputSource();
			src.setCharacterStream(new StringReader(body));
			Document doc = builder.parse(src);
			
			//Getting status code of RegisterRequest
			status = doc.getElementsByTagName("status").item(0).getTextContent();			
		} catch (IOException | ParserConfigurationException | SAXException e) {
			logger.error("Failed to execute RegisterRequest");
			throw new NodeProcessException(e);
		}
		
		return status;

	}

	/**
	 * 
	 * @param credValue Phone Number
	 * @param key_store Keystore file path
	 * @param key_store_pass Keystore file password
	 * @return status code of RegisterRequest
	 * @throws NodeProcessException
	 */
	public String voiceRegister(String credValue,String key_store,String key_store_pass) throws NodeProcessException {
		
		//Constructing RegisterRequest
		HttpPost post = new HttpPost(GetVIPServiceURL.getInstance().getManagementServiceURL());
		post.setHeader("CONTENT-TYPE", "text/xml; charset=ISO-8859-1");
		
		//Getting payload for RegisterRequest
		String payLoad = getVoicePayload(credValue);
		String status;
		logger.debug("Request Payload: " + payLoad);
		try {
			
			//Executing RegisterRequest 
			HttpClient httpClient = HttpClientUtil.getInstance().getHttpClientForgerock(key_store,key_store_pass);
			post.setEntity(new StringEntity(payLoad));
			
			//Getting response of RegisterRequest
			HttpResponse response = httpClient.execute(post);
			HttpEntity entity = response.getEntity();
			String body = IOUtils.toString(entity.getContent());
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource src = new InputSource();
			src.setCharacterStream(new StringReader(body));
			Document doc = builder.parse(src);
			
			//Getting status code of RegisterRequest
			status = doc.getElementsByTagName("status").item(0).getTextContent();

		} catch (IOException | ParserConfigurationException | SAXException e) {
			logger.error("Failed to execute RegisterRequest");
			throw new NodeProcessException(e);
		}
		
		return status;

	}

	/**
	 * 
	 * @param credValue Phone Number
	 * @return RegisterRequest payload
	 */
	private static String getSmsPayload(String credValue) {
		logger.info("getting RegisterRequest payload for SMS");
		return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
				"xmlns:vip=\"https://schemas.symantec.com/vip/2011/04/vipuserservices\">" +
				"<soapenv:Header/>" +
				"<soapenv:Body>" +
				"<vip:RegisterRequest>" +
				"<vip:requestId>" + new Random().nextInt(10) + 11111 + "</vip:requestId>" +
				"" +
				"<vip:smsDeliveryInfo>" +
				"<vip:phoneNumber>" + credValue + "</vip:phoneNumber> " +
				"</vip:smsDeliveryInfo> " +
				"</vip:RegisterRequest>" +
				"</soapenv:Body>" +
				"</soapenv:Envelope>";

	}

	/**
	 * 
	 * @param credValue Phone Number
	 * @return RegisterRequest payload for voice
	 */
	private static String getVoicePayload(String credValue) {
		logger.info("getting RegisterRequest payload for voice");
		return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
				"xmlns:vip=\"https://schemas.symantec.com/vip/2011/04/vipuserservices\">" +
				"<soapenv:Header/>" +
				"<soapenv:Body>" +
				"<vip:RegisterRequest>" +
				"<vip:requestId>" + new Random().nextInt(10) + 11111 + "</vip:requestId>" +
				"" +
				"<vip:voiceDeliveryInfo>" +
				"<vip:phoneNumber>" + credValue + "</vip:phoneNumber> " +
				"</vip:voiceDeliveryInfo> " +
				"</vip:RegisterRequest>" +
				"</soapenv:Body>" +
				"</soapenv:Envelope>";

	}

	
}