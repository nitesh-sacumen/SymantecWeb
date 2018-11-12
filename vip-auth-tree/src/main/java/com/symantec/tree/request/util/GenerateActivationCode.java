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

/**
 * 
 * @author Symantec
 * Getting activation code using GetActivationCode request
 *
 */
public class GenerateActivationCode {
	private final static Logger logger = LoggerFactory.getLogger(GenerateActivationCode.class);

	/**
	 * 
	 * @return activation code with status
	 */
	public String generateCode() {
		String activationCode = "";
		HttpClientUtil clientUtil = new HttpClientUtil();
		HttpClient httpClient = clientUtil.getHttpClient();

		HttpPost post = new HttpPost(getURL());
		String status = null;
		post.setHeader("CONTENT-TYPE", "text/xml; charset=ISO-8859-1");
		String payLoad = createPayload();
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
			status = doc.getElementsByTagName("ReasonCode").item(0).getTextContent();
			String statusMessage = doc.getElementsByTagName("StatusMessage").item(0).getTextContent();
			logger.debug("retrieving activationCode \t" + doc.getElementsByTagName("ActivationCode"));
			if (doc.getElementsByTagName("ActivationCode").item(0) != null) {
				activationCode = doc.getElementsByTagName("ActivationCode").item(0).getTextContent();
			} else
				activationCode = " ";
			logger.debug("Status is:\t" + statusMessage);
		} catch (Exception e) {
			//TODO need to handle this with a Node Process Exception. Also should only have try catch where required,
			// not around so much extra code.
			e.printStackTrace();
		}
		String code = status + "," + activationCode;
		logger.debug("Status and TransactionId \t" + code);
		return code;
	}

	/**
	 * 
	 * @return GetActivationCode payload
	 */
	public static String createPayload() {
		logger.info("gtting GetActivationCode payload");
		StringBuilder str = new StringBuilder();
		str.append(
				"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:vip=\"http://www.verisign.com/2006/08/vipservice\">");
		str.append("   <soapenv:Header/>");
		str.append("   <soapenv:Body>");
		str.append(
				"      <vip:GetActivationCode Version=\"1.0\" Id=" + "\"" + Math.round(Math.random() * 100000) + "\">");
		str.append("        <vip:ACProfile>" + "MOBILEPHONE" + "</vip:ACProfile>");
		str.append("      </vip:GetActivationCode>");
		str.append("   </soapenv:Body>");
		str.append("</soapenv:Envelope>");
		return str.toString();

	}

	/**
	 * 
	 * @return SDK_URL
	 */
	private String getURL() {
		Properties prop = new Properties();
		try {
			//TODO Need to load this into memory so we don't do File I/O on every time
			prop.load(new FileInputStream("src/main/resources/vip.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty("SDKURL");
	}
}