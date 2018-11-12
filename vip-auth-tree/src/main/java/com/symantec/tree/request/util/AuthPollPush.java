package com.symantec.tree.request.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;
import java.util.Random;

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

/**
 * 
 * @author Symantec
 * getting status of poll push request using PollPushStatusRequest
 *
 */
public class AuthPollPush {

	static final Logger logger = LoggerFactory.getLogger(AuthPollPush.class);

	/**
	 * 
	 * @param authId
	 * @return response status code
	 */
	public String authPollPush(String authId) {

		HttpClientUtil clientUtil = new HttpClientUtil();
		HttpClient httpClient = clientUtil.getHttpClient();

		HttpPost post = new HttpPost(getURL());
		post.setHeader("CONTENT-TYPE", "text/xml; charset=ISO-8859-1");
		String payLoad = getViewUserPayload(authId);
		logger.debug("Request Payload in authPollPush: " + payLoad);
		try {
			post.setEntity(new StringEntity(payLoad));

			logger.info("executing PollPushStatusRequest");
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
			String status = doc.getElementsByTagName("status").item(1).getTextContent();
			String statusMessage = doc.getElementsByTagName("statusMessage").item(1).getTextContent();
			logger.debug("Status is:\t" + statusMessage);

			return status;

		} catch (Exception e) {
			//TODO need to handle this with a Node Process Exception. Also should only have try catch where required,
			// not around so much extra code.
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 
	 * @param authId
	 * @return PollPushStatusRequest payload
	 */
	private static String getViewUserPayload(String authId) {
		logger.info("getting payload for PollPushStatusRequest");
		return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
				"xmlns:vip=\"https://schemas.symantec.com/vip/2011/04/vipuserservices\">" +
				"<soapenv:Header/>" +
				"<soapenv:Body>" +
				"<vip:PollPushStatusRequest>" +
				"<vip:requestId>" + new Random().nextInt(10) + 11111 + "</vip:requestId>" +
				"<vip:transactionId>" + authId + "</vip:transactionId>" +
				"</vip:PollPushStatusRequest>" +
				"</soapenv:Body>" +
				"</soapenv:Envelope>";

	}

	/**
	 * 
	 * @return QueryServiceURL
	 */
	private String getURL() {
		Properties prop = new Properties();
		try {
			//TODO Need to load this into memory so we don't do File I/O on every time
			prop.load(new FileInputStream("src/main/resources/vip.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty("QueryServiceURL");
	}

}
