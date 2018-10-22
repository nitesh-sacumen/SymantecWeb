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
 * This class is used to Create user in Symantec.
 */
public class VIPCreateUser {
	
	final String SymUrl = "https://userservices-auth.vip.symantec.com/vipuserservices/ManagementService_1_8";
	
	/*public static void main(String[] args) {
		System.out.println(new VIPCreateUser().createVIPUser("Narsi"));
	}*/

	/**
	 * Payload to create user.
	 */
    private String createUserPayload(String userId) {
	
    	StringBuilder str = new StringBuilder();
	   	str.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:vip=\"https://schemas.symantec.com/vip/2011/04/vipuserservices\">");
	   	str.append("   <soapenv:Header/>");		
	   	str.append("   <soapenv:Body>");
	   	str.append("      <vip:CreateUserRequest>");	
	   	str.append("               <vip:requestId>"+Math.round(Math.random() * 100000)+"</vip:requestId>");
	   	str.append("             <vip:userId>"+userId+"</vip:userId>");		
	   	str.append("      </vip:CreateUserRequest>");
	   	str.append("   </soapenv:Body>");
	   	str.append("</soapenv:Envelope>");		

	   	return str.toString();

    }

    /**
	 * This method is used to Create user in Symantec.
	 */
	public boolean createVIPUser(String userId) {
		boolean isUserExisted = false;
		
        try {
        	HttpClient httpClient = HttpClientUtil.getHttpClient();
           
        	HttpPost httpPost = new HttpPost(SymUrl);
            httpPost.addHeader("Accept-Encoding", "gzip,deflate");
     		httpPost.addHeader("Content-Type", "text/xml;charset=utf-8");
     		httpPost.addHeader("SOAPAction", "");	/* \"\" */
     		httpPost.addHeader("User-Agent","Apache-HttpClient/4.1.1");
        	
        	String userPayload = createUserPayload(userId);
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
          //  String status = doc.getElementsByTagName("status").item(0).getTextContent();
            String statusMessage = doc.getElementsByTagName("statusMessage").item(0).getTextContent();
           
            if("Success".equalsIgnoreCase(statusMessage)) {
            	isUserExisted = true;
            }
            
        }catch (Exception e) {
        	e.printStackTrace();
		}
        
		return isUserExisted;        
    }
}
