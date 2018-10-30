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

public class GenerateActivationCode {
	public String generateCode() {
		String activationCode = "";
		HttpClientUtil clientUtil = new HttpClientUtil();
		HttpClient httpClient = clientUtil.getHttpClient();

		HttpPost post = new HttpPost("https://services-auth.vip.symantec.com/prov/soap");
		String status = null;
		post.setHeader("CONTENT-TYPE", "text/xml; charset=ISO-8859-1");
		String payLoad = createPayload();
		System.out.println("Request Payload: " + payLoad);
		try {
			post.setEntity(new StringEntity(payLoad));

			HttpResponse response = httpClient.execute(post);
			HttpEntity entity = response.getEntity();

			System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

			System.out.println(response.getStatusLine());
			String body = IOUtils.toString(entity.getContent());
			System.out.println("response body is:\t" + body);
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource src = new InputSource();
			src.setCharacterStream(new StringReader(body));
			Document doc = builder.parse(src);
			status = doc.getElementsByTagName("ReasonCode").item(0).getTextContent();
			String statusMessage = doc.getElementsByTagName("statusMessage").item(0).getTextContent();
			System.out.println("retrieving activationCode \t" + doc.getElementsByTagName("ActivationCode"));
			if (doc.getElementsByTagName("ActivationCode").item(0) != null) {
				activationCode = doc.getElementsByTagName("ActivationCode").item(0).getTextContent();
			} else
				activationCode = " ";
                System.out.println("Status is:\t" + statusMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String code = status + "," + activationCode;
		System.out.println("Status and TransactionId \t" + code);
		return code;
	}

	public static String createPayload() {
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
}