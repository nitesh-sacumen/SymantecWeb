package com.symantec.tree.request.util;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import java.io.ByteArrayInputStream;

import java.io.InputStream;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * This class is used to Search whether user is present in Symantec or not.
 */
public class VIPSearchUser {
	
	final String SymUrl = "https://userservices-auth.vip.symantec.com/vipuserservices/QueryService_1_8";
	/**
	 * This method is used to Search whether user is present in Symantec or not.
	 */
	public boolean viewUserInfo(String userId) {
		boolean isUserExisted = false;
		
        try {
        	HttpClient httpClient = HttpClientUtil.getHttpClient();
           
        	HttpPost httpPost = new HttpPost(SymUrl);
            httpPost.addHeader("Accept-Encoding", "gzip,deflate");
     		httpPost.addHeader("Content-Type", "text/xml;charset=utf-8");
     		httpPost.addHeader("SOAPAction", "");	/* \"\" */
     		httpPost.addHeader("User-Agent","Apache-HttpClient/4.1.1");
        	
        	String userPayload = getViewUserPayload(userId);
    		InputStream is = new ByteArrayInputStream(userPayload.getBytes());
    		
    		InputStreamEntity  reqEntity = new InputStreamEntity(is,-1);
    		reqEntity.setContentType("text/xml");
    		reqEntity.setContentEncoding("charset=utf-8");
            reqEntity.setChunked(true);
    		
            
    		httpPost.setEntity(reqEntity);
            
            HttpResponse response = httpClient.execute(httpPost);
           
            HttpEntity entity = response.getEntity();
         
            String body = IOUtils.toString(entity.getContent());
            
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource src = new InputSource();
            src.setCharacterStream(new StringReader(body));
            Document doc = builder.parse(src);
            
            String statusMessage = doc.getElementsByTagName("statusMessage").item(0).getTextContent();
            System.out.println("Status is:\t"+statusMessage);
            if("Success".equalsIgnoreCase(statusMessage)) {
            	isUserExisted = true;
            }
            
        }catch (Exception e) {
        	e.printStackTrace();
		}
		return isUserExisted;        
    }
	
	/**
	 *Payload request for Searching User.
	 */
	public String getViewUserPayload(String userId) {
		StringBuilder str = new StringBuilder();
		str.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:vip=\"https://schemas.symantec.com/vip/2011/04/vipuserservices\">");
		str.append("<soapenv:Header/>");
		str.append("<soapenv:Body>");
		str.append("<vip:GetUserInfoRequest>");
		str.append("<vip:requestId>"+Math.round(Math.random() * 100000)+"</vip:requestId>");
		str.append("");
		str.append("<vip:userId>"+userId+"</vip:userId>");
		str.append("");
		str.append("<vip:iaInfo>true</vip:iaInfo>");
		str.append("<vip:includePushAttributes>true</vip:includePushAttributes>");
		str.append("<vip:includeTokenInfo>true</vip:includeTokenInfo>");
		str.append("</vip:GetUserInfoRequest>");
		str.append("</soapenv:Body>");
		str.append("</soapenv:Envelope>");
		return str.toString();
	}

	public String getMobInfo(String userId) throws NullPointerException {
		String phoneNumber=null;

		try {
			HttpClient httpClient = HttpClientUtil.getHttpClient();

		HttpPost httpPost = new HttpPost(SymUrl);
		httpPost.addHeader("Accept-Encoding", "gzip,deflate");
		httpPost.addHeader("Content-Type", "text/xml;charset=utf-8");
		httpPost.addHeader("SOAPAction", "");
		httpPost.addHeader("User-Agent","Apache-HttpClient/4.1.1");

		String userPayload = getViewUserPayload(userId);
		InputStream is = new ByteArrayInputStream(userPayload.getBytes());

		InputStreamEntity reqEntity = new InputStreamEntity(is,-1);
		reqEntity.setContentType("text/xml");
		reqEntity.setContentEncoding("charset=utf-8");
		reqEntity.setChunked(true);

		
		httpPost.setEntity(reqEntity);

		HttpResponse response = httpClient.execute(httpPost);
		
		HttpEntity entity = response.getEntity();


		
		
		String body = IOUtils.toString(entity.getContent());
		
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		InputSource src = new InputSource();
		src.setCharacterStream(new StringReader(body));
		Document doc = builder.parse(src);
		
		
		
		if(doc.getElementsByTagName("credentialBindingDetail") != null) 
		{
			
			
			if(doc.getElementsByTagName("credentialBindingDetail").item(0) != null) 
			{
				String credBindingDetail=doc.getElementsByTagName("credentialBindingDetail").item(0).getTextContent();
				
				String credType=doc.getElementsByTagName("credentialType").item(0).getTextContent();
				if(credBindingDetail==null || credType.equalsIgnoreCase("SMS_OTP") || credType.equalsIgnoreCase("VOICE_OTP") ) 
				{
				phoneNumber=doc.getElementsByTagName("credentialId").item(0).getTextContent();
				
				}
				else 
				{
					String statusMessage = doc.getElementsByTagName("statusMessage").item(0).getTextContent();
					
					if (statusMessage != null && statusMessage.equalsIgnoreCase("Success")) 
						{
						return "VIPCREDREGISTERED";
						
						}
				}
			}

			else {
					
					String statusMessage = doc.getElementsByTagName("statusMessage").item(0).getTextContent();
					
					if (statusMessage != null && statusMessage.equalsIgnoreCase("Success")) {
						return "NOCREDREGISTERED";
						
					}
			}
		}
		else {
				
				String statusMessage = doc.getElementsByTagName("statusMessage").item(0).getTextContent();
				
				if (statusMessage != null && statusMessage.equalsIgnoreCase("Success")) {
					return "NOCREDREGISTERED";
					
				}
			
		}

		



		}catch (Exception e) {
		e.printStackTrace();
		}
		
		return phoneNumber; 
		}
	


}
