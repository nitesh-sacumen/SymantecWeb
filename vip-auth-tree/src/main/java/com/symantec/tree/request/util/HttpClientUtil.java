package com.symantec.tree.request.util;

import java.io.File;
import java.io.FileInputStream;

import java.io.InputStream;
import java.security.KeyStore;
import java.util.Base64;



import java.util.Properties;

import javax.net.ssl.SSLContext;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;

/**
 * This Http  client utility class would create a 
 * single instance of http client and serve it for all 
 * the methods 
 */
public class HttpClientUtil {

	/*
	 * Set Symantec 
	 */
	public static final String ADMIN_STORE_FILE_LOCATION = System.getenv("SYMANTEC_HOME");
	public static final String ADMIN_STORE_FILE = ADMIN_STORE_FILE_LOCATION+"\\symantecConfig.properties";
    char sEP = File.separatorChar;
	
    private static HttpClient httpClient = null;
    
    private static KeyStore readStore(String kEYSTOREPATH, String kEYSTOREPASS ) throws Exception {
    	InputStream keyStoreStream = new FileInputStream(kEYSTOREPATH);
    	KeyStore keyStore = KeyStore.getInstance("JKS"); // or "PKCS12"
    	keyStore.load(keyStoreStream, kEYSTOREPASS.toCharArray());
    	
    	return keyStore;
        
    }
	
    /**
     * This Http  client utility method would create a 
     * single instance of http client and serve it for all 
     * the methods 
     * @return
     */
	public static  HttpClient  getHttpClient() {
		if(httpClient == null) {
			Properties prop = new Properties();
			FileInputStream input = null;
	    	
			String kEYSTOREPATH="";
	    	String kEYPASS = "";
	    	String kEYSTOREPASS= "";

			try {
				input =  new FileInputStream(ADMIN_STORE_FILE);
	    		
				// load a properties file
	    		prop.load(input);
	    		kEYSTOREPATH= prop.getProperty("KeyStore.location");
	    		
	    		kEYSTOREPASS = new String( Base64.getDecoder().decode(prop.getProperty("keyStore.password")));
	    		//KEYPASS=prop.getProperty("keyStore.password");
	    		kEYPASS=kEYSTOREPASS;
	    		SSLContext sslContext = SSLContexts.custom()
		                .loadKeyMaterial(readStore(kEYSTOREPATH,kEYSTOREPASS), kEYPASS.toCharArray())
		                .build();
	    		httpClient = HttpClients.custom().setSSLContext(sslContext).build();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return httpClient;
	}
}
