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
 * A class that authenticates credential that has been entered by the user. 
 */
public class AuthenticateCredential {

	// TODO Auto-generated method stub

	/** 
	 * A method that authenticates credential that has been entered by the user. 
	 */
	public String authCredential(String credID) {
		String credType = "STANDARD_OTP";
		String transactionID = "";
		HttpClient httpClient = HttpClientUtil.getHttpClient();

		HttpPost post = new HttpPost("https://userservices-auth.vip.symantec.com/vipuserservices/AuthenticationService_1_8");
		String status = null;
		post.setHeader("CONTENT-TYPE", "text/xml; charset=ISO-8859-1");
		// post.setHeader(new Header(HttpHeaders.CONTENT_TYPE,"text/xml;
		// charset=ISO-8859-1"));
		String payLoad = getViewUserPayload(credID, credType);
		
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
			status = doc.getElementsByTagName("status").item(0).getTextContent();
			//String statusMessage = doc.getElementsByTagName("statusMessage").item(0).getTextContent();
		
			if(doc.getElementsByTagName("transactionId").item(0) !=null) {
				transactionID = doc.getElementsByTagName("transactionId").item(0).getTextContent();
			}
			else
				transactionID = " ";
		
			/*if ("6040".equals(status)) {
				transactionID = doc.getElementsByTagName("transactionId").item(0).getTextContent();
				return transactionID;
			}*/

		} catch (Exception e) {
			e.printStackTrace();
		}
		String transtat=status+","+transactionID;
		
		return transtat;
	}

	/** 
	 * Payload for Authentication. 
	 */
	public static String getViewUserPayload(String credId, String credType) {
		StringBuilder str = new StringBuilder();
		str.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:vip=\"https://schemas.symantec.com/vip/2011/04/vipuserservices\">");
		str.append("   <soapenv:Header/>");
		str.append("   <soapenv:Body>");
		str.append("      <vip:AuthenticateCredentialsRequest>");
		str.append("<vip:requestId>"+Math.round(Math.random() * 100000)+"</vip:requestId>");
		str.append("           <vip:credentials>");
		str.append("            <vip:credentialId>"+credId+"</vip:credentialId>");
		str.append("            <vip:credentialType>"+credType+"</vip:credentialType>");
		str.append("           </vip:credentials>     ");
		str.append("         <vip:pushAuthData>");
		str.append("         </vip:pushAuthData>   ");
		str.append("       </vip:AuthenticateCredentialsRequest>");
		str.append("   </soapenv:Body>");
		str.append("</soapenv:Envelope>");
		return str.toString();

	}

}
