package com.symantec.tree.request.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.symantec.tree.config.Constants.DeleteCredentialsStatusCode;

/**
 * 
 * @author Symantec
 * Deleting credential id , which is associated with user using RemoveCredentialRequest
 *
 */
public class DeleteCredential {
	static Logger logger = LoggerFactory.getLogger(DeleteCredential.class);

	/**
	 * 
	 * @param userName
	 * @param credId
	 * @param credType
	 */
	public void deleteCredential(String userName, String credId, String credType) {
		HttpClientUtil clientUtil = new HttpClientUtil();
		HttpClient httpClient = clientUtil.getHttpClient();

		HttpPost post = new HttpPost(getURL());
		post.setHeader("CONTENT-TYPE", "text/xml; charset=ISO-8859-1");
		String payLoad = getRemoveCredPayload(userName, credId, credType);
		logger.debug("Request Payload: " + payLoad);
		try {
			post.setEntity(new StringEntity(payLoad));

			HttpResponse response = httpClient.execute(post);
			HttpEntity entity = response.getEntity();

			logger.debug("Response Code : " + response.getStatusLine().getStatusCode());
			logger.debug(response.getStatusLine().toString());
			String body = IOUtils.toString(entity.getContent());
			logger.debug("response body is:\t" + body);
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource src = new InputSource();
			src.setCharacterStream(new StringReader(body));
			Document doc = builder.parse(src);
			String status = doc.getElementsByTagName("status").item(0).getTextContent();
			String statusMessage = doc.getElementsByTagName("statusMessage").item(0).getTextContent();
			logger.debug("\nStatus is:\t" + status);
			logger.debug("Status Message is:\t" + statusMessage);
			if (DeleteCredentialsStatusCode.SUCCESS_CODE.equals(status)) {
				logger.debug("Credential " + credType + " removed successfully for " + userName);
			}

		} catch (Exception e) {
			logger.error("Not able to delete credentials");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param userId
	 * @param credId
	 * @param credType
	 * @return RemoveCredentialRequest payload
	 */
	public static String getRemoveCredPayload(String userId, String credId, String credType) {
		StringBuilder str = new StringBuilder();
		str.append(
				"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:vip=\"https://schemas.symantec.com/vip/2011/04/vipuserservices\">");
		str.append("   <soapenv:Header/>");
		str.append("   <soapenv:Body>");
		str.append("      <vip:RemoveCredentialRequest>");
		str.append("<vip:requestId>" + Math.round(Math.random() * 100000) + "</vip:requestId>");
		str.append("         <vip:userId>" + userId + "</vip:userId>");
		str.append("         <vip:credentialId>" + credId + "</vip:credentialId>");
		str.append("          <vip:credentialType>" + credType + "</vip:credentialType>      ");
		str.append("      </vip:RemoveCredentialRequest>");
		str.append("   </soapenv:Body>");
		str.append("</soapenv:Envelope>");
		return str.toString();

	}

	/**
	 * 
	 * @return ManagementServiceURL
	 */
	private String getURL() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("src/main/resources/vip.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty("ManagementServiceURL");
	}

}
