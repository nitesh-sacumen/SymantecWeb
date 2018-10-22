package com.symantec.tree.request.util;

import java.io.StringReader;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;


/**
 * This class is used to register mobile through Voice.
 */
public class SMSVoiceRegister {


	/**
	 * This method is used to register mobile through SMS.
	 */
	public void smsRegister(String credValue) {


	
		HttpClient httpClient = HttpClientUtil.getHttpClient();
 		HttpPost post = new HttpPost("https://userservices-auth.vip.symantec.com/vipuserservices/ManagementService_1_8");
 		post.setHeader("CONTENT-TYPE", "text/xml; charset=ISO-8859-1");
// post.setHeader(new Header(HttpHeaders.CONTENT_TYPE,"text/xml;
// charset=ISO-8859-1"));

 		String payLoad = getSmsPayload(credValue);


 		try {

 			post.setEntity(new StringEntity(payLoad));
 			HttpResponse response = httpClient.execute(post);
 			HttpEntity entity = response.getEntity();

 			// add header
 			String body = IOUtils.toString(entity.getContent());
 			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
 			InputSource src = new InputSource();
 			src.setCharacterStream(new StringReader(body));
 			Document doc = builder.parse(src);
 			String status = doc.getElementsByTagName("status").item(0).getTextContent();
 			String statusMessage = doc.getElementsByTagName("statusMessage").item(0).getTextContent();

 		} catch (Exception e) {

 			e.printStackTrace();

 		}

}


	/**
	 * This class is used to register mobile through Voice.
	 */
	public void voiceRegister(String credValue) {

		HttpClient httpClient = HttpClientUtil.getHttpClient();
		HttpPost post = new HttpPost("https://userservices-auth.vip.symantec.com/vipuserservices/ManagementService_1_8");
		post.setHeader("CONTENT-TYPE", "text/xml; charset=ISO-8859-1");
// post.setHeader(new Header(HttpHeaders.CONTENT_TYPE,"text/xml;
// charset=ISO-8859-1"));
		String payLoad = getVoicePayload(credValue);

		try {

			post.setEntity(new StringEntity(payLoad));

			HttpResponse response = httpClient.execute(post);

			HttpEntity entity = response.getEntity();

			// add header

			String body = IOUtils.toString(entity.getContent());
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource src = new InputSource();
			src.setCharacterStream(new StringReader(body));
			Document doc = builder.parse(src);
			String status = doc.getElementsByTagName("status").item(0).getTextContent();
			String statusMessage = doc.getElementsByTagName("statusMessage").item(0).getTextContent();

		} catch (Exception e) {

			e.printStackTrace();

		}

}

 
	/**
	 * Payload for SMS Registration.
	 */
	public static String getSmsPayload(String credValue) {

		StringBuilder str = new StringBuilder();

		str.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:vip=\"https://schemas.symantec.com/vip/2011/04/vipuserservices\">");
		str.append("<soapenv:Header/>");
		str.append("<soapenv:Body>");
		str.append("<vip:RegisterRequest>");
		str.append("<vip:requestId>"+new Random().nextInt(10)+11111+"</vip:requestId>");
		str.append("");
		str.append("<vip:smsDeliveryInfo>");
		str.append("<vip:phoneNumber>"+credValue+"</vip:phoneNumber> ");
		str.append("</vip:smsDeliveryInfo> ");
		str.append("</vip:RegisterRequest>");
		str.append("</soapenv:Body>");
		str.append("</soapenv:Envelope>");

		return str.toString();

	
	}


	/**
	 * Payload for Voice Registration.
	 */
	public static String getVoicePayload(String credValue) {

		StringBuilder str = new StringBuilder();
		str.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:vip=\"https://schemas.symantec.com/vip/2011/04/vipuserservices\">");
		str.append("<soapenv:Header/>");
		str.append("<soapenv:Body>");
		str.append("<vip:RegisterRequest>");
		str.append("<vip:requestId>"+new Random().nextInt(10)+11111+"</vip:requestId>");
		str.append("");
		str.append("<vip:voiceDeliveryInfo>");
		str.append("<vip:phoneNumber>"+credValue+"</vip:phoneNumber> ");
		str.append("</vip:voiceDeliveryInfo> ");
		str.append("</vip:RegisterRequest>");
		str.append("</soapenv:Body>");
		str.append("</soapenv:Envelope>");

		return str.toString();


	}


}