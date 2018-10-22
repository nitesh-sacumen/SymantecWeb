package com.symantec.tree.config;

import java.util.HashMap;
import java.util.Map;


/**
 * Contstants class is used for mapping data from end to back end. 
 *  
 */
public class UiMapping {

  public static Map   mapping(){
	 Map<String, String> uiElements = new HashMap<String,String>();
	  
	  uiElements.put("VIP","STANDARD_OTP");
	  uiElements.put("SMS","SMS_OTP");
	  uiElements.put("VOICE", "VOICE_OTP");
	  

	  return uiElements;
	      
     }
    
}
