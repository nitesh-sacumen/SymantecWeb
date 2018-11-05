package com.symantec.tree.request.util;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * 
 * @author Syamntec
 * Create user if not exist.
 *
 */
public class VIPCreateUser {

	static Logger logger = LoggerFactory.getLogger(VIPCreateUser.class);

	/**
	 * 
	 * @param userId
	 * @return CreateUserRequest payload
	 */
	private String createUserPayload(String userId) {
		logger.info("getting CreateUserRequest payload");
		StringBuilder str = new StringBuilder();
		str.append(
				"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:vip=\"https://schemas.symantec.com/vip/2011/04/vipuserservices\">");
		str.append("   <soapenv:Header/>");
		str.append("   <soapenv:Body>");
		str.append("      <vip:CreateUserRequest>");
		str.append("               <vip:requestId>" + Math.round(Math.random() * 100000) + "</vip:requestId>");
		str.append("             <vip:userId>" + userId + "</vip:userId>");
		str.append("      </vip:CreateUserRequest>");
		str.append("   </soapenv:Body>");
		str.append("</soapenv:Envelope>");
		return str.toString();
	}

	/**
	 * 
	 * @param userId
	 * @return true id user is create, else false
	 * 
	 */
	public boolean createVIPUser(String userId) {
		boolean isUserExisted = false;

		try {
			HttpClient httpClient = new HttpClientUtil().getHttpClient();

			HttpPost httpPost = new HttpPost(getURL());
			httpPost.addHeader("Accept-Encoding", "gzip,deflate");
			httpPost.addHeader("Content-Type", "text/xml;charset=utf-8");
			httpPost.addHeader("SOAPAction", ""); /* \"\" */
			httpPost.addHeader("User-Agent", "Apache-HttpClient/4.1.1");

			String userPayload = createUserPayload(userId);
			InputStream is = new ByteArrayInputStream(userPayload.getBytes());

			InputStreamEntity reqEntity = new InputStreamEntity(is, -1);
			reqEntity.setContentType("text/xml");
			reqEntity.setContentEncoding("charset=utf-8");
			reqEntity.setChunked(true);

			logger.debug("req content length:\t" + reqEntity.getContentLength());
			httpPost.setEntity(reqEntity);

			logger.info("executing CreateUserRequest");
			HttpResponse response = httpClient.execute(httpPost);
			logger.debug("status code is " + response.getStatusLine().getStatusCode());
			HttpEntity entity = response.getEntity();
			logger.debug(response.getStatusLine().toString());
			String body = IOUtils.toString(entity.getContent());
			logger.debug("response body is:\t" + body);
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource src = new InputSource();
			src.setCharacterStream(new StringReader(body));
			Document doc = builder.parse(src);
			String status = doc.getElementsByTagName("status").item(0).getTextContent();
			String statusMessage = doc.getElementsByTagName("statusMessage").item(0).getTextContent();
			logger.debug("Status is:\t" + statusMessage);
			if ("Success".equals(statusMessage)) {
				isUserExisted = true;
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return isUserExisted;
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
