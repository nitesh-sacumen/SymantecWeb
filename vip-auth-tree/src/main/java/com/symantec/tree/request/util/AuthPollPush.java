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
 * A class that send PollPush Request to user for Authentication of User. 
 */
public class AuthPollPush {
	/** 
	 * A method that send PollPush Request to user for Authentication of User. 
	 */
	public String authPollPush(String authId) {
		
		HttpClient httpClient = HttpClientUtil.getHttpClient();

		HttpPost post = new HttpPost(
				"https://userservices-auth.vip.symantec.com/vipuserservices/QueryService_1_8");

		post.setHeader("CONTENT-TYPE", "text/xml; charset=ISO-8859-1");
		// post.setHeader(new Header(HttpHeaders.CONTENT_TYPE,"text/xml;
		// charset=ISO-8859-1"));
		String payLoad = getViewUserPayload(authId);
		
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
			String status = doc.getElementsByTagName("status").item(1).getTextContent();
		//	String statusMessage = doc.getElementsByTagName("statusMessage").item(1).getTextContent();
		
			
			return status;


		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/** 
	 * Payload for Poll push. 
	 */
	public static String getViewUserPayload(String authId) {
		StringBuilder str = new StringBuilder();
		str.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:vip=\"https://schemas.symantec.com/vip/2011/04/vipuserservices\">");
		str.append("<soapenv:Header/>");
		str.append("<soapenv:Body>");
		str.append("<vip:PollPushStatusRequest>");
		str.append("<vip:requestId>"+new Random().nextInt(10)+11111+"</vip:requestId>");
		str.append("<vip:transactionId>"+authId+"</vip:transactionId>");
		str.append("</vip:PollPushStatusRequest>");
		str.append("</soapenv:Body>");
		str.append("</soapenv:Envelope>");
		return str.toString();

	}

}
