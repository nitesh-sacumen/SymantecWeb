package com.symantec.tree.request.util;


import java.io.StringReader;
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
 * A class that authenticates user and returns transaction id and status
 */
public class AuthenticateUser {

	// TODO Auto-generated method stub

	/** 
	 * A method that authenticates user and returns transaction id and status
	 */
	public String authUser(String userName) {

		String transactionID = "";
		HttpClient httpClient = HttpClientUtil.getHttpClient();

		HttpPost post = new HttpPost(
				"https://userservices-auth.vip.symantec.com/vipuserservices/AuthenticationService_1_8");

		post.setHeader("CONTENT-TYPE", "text/xml; charset=ISO-8859-1");
		// post.setHeader(new Header(HttpHeaders.CONTENT_TYPE,"text/xml;
		// charset=ISO-8859-1"));
		String payLoad = getViewUserPayload(userName);
		
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
		
		
			if ("6040".equals(status)) {
				transactionID = doc.getElementsByTagName("transactionId").item(0).getTextContent();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return transactionID;
	}

	/** 
	 * Payload for user Authentication
	 */
	public static String getViewUserPayload(String userId) {
		StringBuilder str = new StringBuilder();
		str.append(
				"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:vip=\"https://schemas.symantec.com/vip/2011/04/vipuserservices\">");
		str.append("<soapenv:Header/>");
		str.append("<soapenv:Body>");
		str.append("<vip:AuthenticateUserWithPushRequest>");
		str.append("<vip:requestId>"+Math.round(Math.random() * 100000)+"</vip:requestId>");
		str.append("<!--Optional:-->");
		str.append("");
		str.append("<vip:userId>" + userId + "</vip:userId>");
		str.append("<!--Optional:-->");
		// str.append("<vip:pin>"+pin+"</vip:pin>");
		str.append("<vip:pushAuthData>");
		str.append("<!--0 to 20 repetitions:-->");
		str.append("");
		str.append("</vip:pushAuthData>");
		str.append("</vip:AuthenticateUserWithPushRequest>");
		str.append("</soapenv:Body>");
		str.append("</soapenv:Envelope>");
		return str.toString();

	}

}
