package com.symantec.tree.request.util;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;

public class GetVIPServiceURL {
	private static GetVIPServiceURL getVIPServiceUrl = null;
	static Hashtable<String,String> serviceUrls = new Hashtable<>();
	
	private GetVIPServiceURL() {
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try {
			prop.load(loader.getResourceAsStream("vip.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		serviceUrls.put("ManagementServiceURL", prop.getProperty("ManagementServiceURL"));
		serviceUrls.put("AuthenticationServiceURL", prop.getProperty("AuthenticationServiceURL"));
		serviceUrls.put("QueryServiceURL", prop.getProperty("QueryServiceURL"));
		serviceUrls.put("SDKURL", prop.getProperty("SDKURL"));
	}
	
	public static GetVIPServiceURL getInstance(){
		if(getVIPServiceUrl==null) {
			getVIPServiceUrl = new GetVIPServiceURL();
		}
		return getVIPServiceUrl;
	}
}
