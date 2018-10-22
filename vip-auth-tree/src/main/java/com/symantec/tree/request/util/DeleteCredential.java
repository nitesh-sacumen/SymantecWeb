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
 * A class to delete invalid credential from VIP 
 */
public class DeleteCredential {

	// TODO Auto-generated method stub

	/** 
	 * A method to delete invalid credential from VIP 
	 */
	public void deleteCredential(String userName, String credId, String credType) {

		//String transactionID = "";
		HttpClient httpClient = HttpClientUtil.getHttpClient();

		HttpPost post = new HttpPost("https://userservices-auth.vip.symantec.com/vipuserservices/ManagementService_1_8");

		post.setHeader("CONTENT-TYPE", "text/xml; charset=ISO-8859-1");
		
		if(credType.equalsIgnoreCase("SMS"))
			credType="SMS_OTP";
		else if (credType.equalsIgnoreCase("Voice"))
			credType="VOICE_OTP";
		else if (credType.equalsIgnoreCase("VIP"))
			credType="STANDARD_OTP";
			
		
		// post.setHeader(new Header(HttpHeaders.CONTENT_TYPE,"text/xml;
		// charset=ISO-8859-1"));
		String payLoad = getRemoveCredPayload(userName,credId,credType);
		
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
			
			if ("0000".equals(status)) {
				
				//transactionID = doc.getElementsByTagName("transactionId").item(0).getTextContent();
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		//return transactionID;
	}

	/** 
	 * Payload for Delete credential 
	 */
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
