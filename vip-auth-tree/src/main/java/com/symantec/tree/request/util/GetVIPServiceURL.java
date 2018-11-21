package com.symantec.tree.request.util;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;

import org.forgerock.openam.auth.node.api.NodeProcessException;

/**
 * 
 * @author Sacumen (www.sacumen.com)
 * @Description  Getting Service URL for Authentications
 *
 */
public class GetVIPServiceURL {
	private static GetVIPServiceURL getVIPServiceUrl = null;
	static Hashtable<String,String> serviceUrls = new Hashtable<>();
	
	private GetVIPServiceURL() throws NodeProcessException {
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try {
			prop.load(loader.getResourceAsStream("vip.properties"));
		} catch (IOException e) {
			throw new NodeProcessException(e);
		}
		serviceUrls.put("ManagementServiceURL", prop.getProperty("ManagementServiceURL"));
		serviceUrls.put("AuthenticationServiceURL", prop.getProperty("AuthenticationServiceURL"));
		serviceUrls.put("QueryServiceURL", prop.getProperty("QueryServiceURL"));
		serviceUrls.put("SDKURL", prop.getProperty("SDKURL"));
	}
	
	public static GetVIPServiceURL getInstance() throws NodeProcessException{
		if(getVIPServiceUrl==null) {
			getVIPServiceUrl = new GetVIPServiceURL();
		}
		return getVIPServiceUrl;
	}
}
