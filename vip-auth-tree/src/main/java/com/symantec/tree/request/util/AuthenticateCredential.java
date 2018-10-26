package com.symantec.tree.request.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.security.KeyStore;

import javax.net.ssl.SSLContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class AuthenticateCredential {

	// TODO Auto-generated method stub
	static Logger logger = LoggerFactory.getLogger(AuthenticateCredential.class);
	public String authCredential(String credID, String displayMsgText, String displayMsgTitle,String displayMsgProfile) {
		String credType = "STANDARD_OTP";
		String transactionID = "";
		HttpClientUtil clientUtil = new HttpClientUtil();
		HttpClient httpClient = clientUtil.getHttpClient();

		HttpPost post = new HttpPost(
				"https://userservices-auth.vip.symantec.com/vipuserservices/AuthenticationService_1_8");
		String status = null;
		post.setHeader("CONTENT-TYPE", "text/xml; charset=ISO-8859-1");
		// post.setHeader(new Header(HttpHeaders.CONTENT_TYPE,"text/xml;
		// charset=ISO-8859-1"));
		String payLoad = getViewUserPayload(credID, credType, displayMsgText, displayMsgTitle, displayMsgProfile);
		logger.debug("Request Payload: " + payLoad);
		try {
			post.setEntity(new StringEntity(payLoad));

			logger.info("Executing http request for AuthenticateCredentials");
			HttpResponse response = httpClient.execute(post);
			HttpEntity entity = response.getEntity();

			logger.debug("Response Code : " + response.getStatusLine().getStatusCode());
			// add header

			logger.info(response.getStatusLine().toString());
			String body = IOUtils.toString(entity.getContent());
			logger.debug("response body is:\t" + body);
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource src = new InputSource();
			src.setCharacterStream(new StringReader(body));
			Document doc = builder.parse(src);
			status = doc.getElementsByTagName("status").item(0).getTextContent();
			String statusMessage = doc.getElementsByTagName("statusMessage").item(0).getTextContent();
			logger.debug( "retrieving transactionId \t" + doc.getElementsByTagName("transactionId"));
			if(doc.getElementsByTagName("transactionId").item(0) !=null) {
				transactionID = doc.getElementsByTagName("transactionId").item(0).getTextContent();
			}
			else
				transactionID = " ";
			logger.debug("Status is:\t" + statusMessage);
			/*if ("6040".equals(status)) {
				transactionID = doc.getElementsByTagName("transactionId").item(0).getTextContent();
				return transactionID;
			}*/

		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		String transtat=status+","+transactionID;
		logger.debug( "Status and TransactionId \t"+transtat);
		return transtat;
	}

	public static String getViewUserPayload(String credId, String credType,String displayMsgText, String displayMsgTitle,String displayMsgProfile) {
		logger.info("getting payload for AuthenticateCredentialsRequest");
		StringBuilder str = new StringBuilder();
		str.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:vip=\"https://schemas.symantec.com/vip/2011/04/vipuserservices\">");
		str.append("   <soapenv:Header/>");
		str.append("   <soapenv:Body>");
		str.append("      <vip:AuthenticateCredentialsRequest>");
		str.append("<vip:requestId>"+Math.round(Math.random() * 100000)+"</vip:requestId>");
		str.append("<vip:activate>"+true+"</vip:activate>");
		str.append("           <vip:credentials>");
		str.append("            <vip:credentialId>"+credId+"</vip:credentialId>");
		str.append("            <vip:credentialType>"+credType+"</vip:credentialType>");
		str.append("           </vip:credentials>     ");

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
		
		
		str.append("       </vip:AuthenticateCredentialsRequest>");
		str.append("   </soapenv:Body>");
		str.append("</soapenv:Envelope>");
		return str.toString();

	}

}
