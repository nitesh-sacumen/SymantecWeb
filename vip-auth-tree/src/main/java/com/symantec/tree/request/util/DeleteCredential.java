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
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class DeleteCredential {

	// TODO Auto-generated method stub

	public void deleteCredential(String userName, String credId, String credType) {

		//String transactionID = "";
		HttpClientUtil clientUtil = new HttpClientUtil();
		HttpClient httpClient = clientUtil.getHttpClient();

		HttpPost post = new HttpPost(
				"https://userservices-auth.vip.symantec.com/vipuserservices/ManagementService_1_8");

		post.setHeader("CONTENT-TYPE", "text/xml; charset=ISO-8859-1");
		
//		if(credType.equalsIgnoreCase("SMS"))
//			credType="SMS_OTP";
//		else if (credType.equalsIgnoreCase("Voice"))
//			credType="VOICE_OTP";
//		else if (credType.equalsIgnoreCase("VIP"))
//			credType="STANDARD_OTP";
			
		System.out.println("CredType to be Removed ..."+credType);
		// post.setHeader(new Header(HttpHeaders.CONTENT_TYPE,"text/xml;
		// charset=ISO-8859-1"));
		String payLoad = getRemoveCredPayload(userName,credId,credType);
		System.out.println("Request Payload: " + payLoad);
		try {
			post.setEntity(new StringEntity(payLoad));

			HttpResponse response = httpClient.execute(post);
			HttpEntity entity = response.getEntity();

			System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
			// add header

			System.out.println(response.getStatusLine());
			String body = IOUtils.toString(entity.getContent());
			System.out.println("response body is:\t" + body);
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource src = new InputSource();
			src.setCharacterStream(new StringReader(body));
			Document doc = builder.parse(src);
			String status = doc.getElementsByTagName("status").item(0).getTextContent();
			String statusMessage = doc.getElementsByTagName("statusMessage").item(0).getTextContent();
			System.out.println("\nStatus is:\t" + status);
			System.out.println("Status Message is:\t" + statusMessage);
			if ("0000".equals(status)) {
				System.out.println("Credential "+credType+" removed successfully for "+userName);
				//transactionID = doc.getElementsByTagName("transactionId").item(0).getTextContent();
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		//return transactionID;
	}

	public static String getRemoveCredPayload(String userId,String credId,String credType) {
		StringBuilder str = new StringBuilder();
		str.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:vip=\"https://schemas.symantec.com/vip/2011/04/vipuserservices\">");
		str.append("   <soapenv:Header/>");
		str.append("   <soapenv:Body>");
		str.append("      <vip:RemoveCredentialRequest>");
		str.append("<vip:requestId>"+Math.round(Math.random() * 100000)+"</vip:requestId>");
		str.append("         <vip:userId>"+userId+"</vip:userId>");
		str.append("         <vip:credentialId>"+credId+"</vip:credentialId>");
		str.append("          <vip:credentialType>"+credType+"</vip:credentialType>      ");
		str.append("      </vip:RemoveCredentialRequest>");
		str.append("   </soapenv:Body>");
		str.append("</soapenv:Envelope>");
		return str.toString();

	}

}
