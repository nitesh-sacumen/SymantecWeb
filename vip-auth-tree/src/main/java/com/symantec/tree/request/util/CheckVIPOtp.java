package com.symantec.tree.request.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
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
 * Checking OTP with CheckOtpRequest.
 *
 */
public class CheckVIPOtp {

	static Logger logger = LoggerFactory.getLogger(CheckVIPOtp.class);

	/**
	 * 
	 * @param userName
	 * @param otpValue
	 * @return true if OTP is correct else false
	 */
	public Boolean checkOtp(String userName, String otpValue) {

		HttpClientUtil clientUtil = new HttpClientUtil();
		HttpClient httpClient = clientUtil.getHttpClient();

		HttpPost post = new HttpPost(getURL());

		post.setHeader("CONTENT-TYPE", "text/xml; charset=ISO-8859-1");
		String payLoad = getViewUserPayload(userName, otpValue);
		logger.debug("Request Payload: " + payLoad);
		try {
			post.setEntity(new StringEntity(payLoad));

			logger.info("executing CheckOtpRequest");
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
			logger.debug("Status Message is:\t" + statusMessage);
			logger.debug("Status is:\t" + status);

			if ("success".equalsIgnoreCase(statusMessage)) {
				return true;

			}

		} catch (Exception e) {
			//TODO need to handle this with a Node Process Exception. Also should only have try catch where required,
			// not around so much extra code.
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return false;

	}

	/**
	 * 
	 * @param userName
	 * @param otpValue
	 * @return CheckOtpRequest payload
	 */
	private static String getViewUserPayload(String userName, String otpValue) {
		logger.info("getting CheckOtpRequest payload");
		return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
				"xmlns:vip=\"https://schemas.symantec.com/vip/2011/04/vipuserservices\">" +
				"   <soapenv:Header/>" +
				"   <soapenv:Body>" +
				"      <vip:CheckOtpRequest>" +
				"<vip:requestId>" + new Random().nextInt(10) + 11111 + "</vip:requestId>" +
				"<vip:userId>" + userName + "</vip:userId>" +
				"         <vip:otpAuthData>" +
				"            <vip:otp>" + otpValue + "</vip:otp>           " +
				"         </vip:otpAuthData>        " +
				"      </vip:CheckOtpRequest>" +
				"   </soapenv:Body>" +
				"</soapenv:Envelope>";
	}

	/**
	 * 
	 * @return AuthenticationServiceURL
	 */
	private String getURL() {
		return GetVIPServiceURL.getInstance().serviceUrls.get("AuthenticationServiceURL");
	}

}
