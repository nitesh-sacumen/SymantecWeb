/*
 * The contents of this file are subject to the terms of the Common Development and
 * Distribution License (the License). You may not use this file except in compliance with the
 * License.
 *
 * You can obtain a copy of the License at legal/CDDLv1.0.txt. See the License for the
 * specific language governing permission and limitations under the License.
 *
 * When distributing Covered Software, include this CDDL Header Notice in each file and include
 * the License file at legal/CDDLv1.0.txt. If applicable, add the following below the CDDL
 * Header, with the fields enclosed by brackets [] replaced by your own identifying
 * information: "Portions copyright [year] [name of copyright owner]".
 *
 * Copyright 2018 ForgeRock AS.
 */


package com.symantec.tree.nodes;


import com.google.inject.assistedinject.Assisted;
import com.sun.identity.shared.debug.Debug;
import com.symantec.tree.config.Constants;
import com.symantec.tree.request.util.AuthenticateCredential;
import com.symantec.tree.request.util.DeleteCredential;

import org.forgerock.openam.annotations.sm.Attribute;
import org.forgerock.openam.auth.node.api.*;
import org.forgerock.openam.core.CoreWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import static com.symantec.tree.config.Constants.TXNID;

import java.util.HashMap;
import java.util.Map;

import static com.symantec.tree.config.Constants.CREDID;
import static com.symantec.tree.config.Constants.STANDARD_OTP;
import static com.symantec.tree.config.Constants.CREDCHOICE;;

/** 
 * A node that checks to see if zero-page login headers have specified username and shared key 
 * for this request. 
 */
@Node.Metadata(outcomeProvider  = AbstractDecisionNode.OutcomeProvider.class,
               configClass      = VIPAuthCredential.Config.class)
public class VIPAuthCredential extends AbstractDecisionNode {

    private final static String DEBUG_FILE = "VIPSearchUser";
    protected Debug debug = Debug.getInstance(DEBUG_FILE);
    
    private final Config config;
    private final CoreWrapper coreWrapper;
    
    private AuthenticateCredential authPushCred;
    final Map<String, String> vipPushCodeMap = new HashMap<>();
    private final Logger logger = LoggerFactory.getLogger("VIPAuthCredential");

    /**
     * Configuration for the node.
     */
    public interface Config {
    	
        @Attribute(order = 100,requiredValue = true)
        default String displayMsgText() {
            return "";
        }
        
        @Attribute(order = 200,requiredValue = true)
        default String displayMsgTitle() {
            return "";
        }
        
        @Attribute(order = 300,requiredValue = true)
        default String displayMsgProfile() {
            return "";
        }

    }
    /**
     * Create the node.
     * @param config The service config.
     * @throws NodeProcessException If the configuration was not valid.
     */
    @Inject
    public VIPAuthCredential(@Assisted Config config, CoreWrapper coreWrapper) throws NodeProcessException {
    	
        this.config = config;
        this.coreWrapper = coreWrapper;
        

        logger.debug("Display Message Text:",this.config.displayMsgText());
        vipPushCodeMap.put(Constants.PUSHDISPLAYMESSAGETEXT, this.config.displayMsgText());

        logger.debug("Display Message Title",this.config.displayMsgTitle());
        vipPushCodeMap.put(Constants.PUSHDISPLAYMESSAGETITLE, this.config.displayMsgTitle());

        logger.debug("Display Message Profile",this.config.displayMsgProfile());
        vipPushCodeMap.put(Constants.PUSHDISPLAYMESSAGEPROFILE, this.config.displayMsgProfile());
        
        authPushCred = new AuthenticateCredential();
    }

    @Override
    public Action process(TreeContext context) throws NodeProcessException {
    //	String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
   //	String credType = context.sharedState.get(CREDCHOICE).asString();
    	String credId = context.sharedState.get(CREDID).asString();
        String credType = STANDARD_OTP;
        String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
  //	String transactionId  = authPushCred.authCredential(credId);
    	String Stat  = authPushCred.authCredential(credId,  vipPushCodeMap.get(Constants.PUSHDISPLAYMESSAGETEXT), vipPushCodeMap.get(Constants.PUSHDISPLAYMESSAGETITLE), vipPushCodeMap.get(Constants.PUSHDISPLAYMESSAGEPROFILE));
    	String[] trastat=Stat.split(",");
    	for(String s:trastat)
    		System.out.println("Values:"+s);
    	String status=trastat[0];
    	String transactionId=trastat[1];
    	System.out.println("status of SymantecAuthCred  .. "+ status);
    	System.out.println("TransactionID of SymantecAuthCred  .. "+ transactionId);
    	
    	context.sharedState.put(TXNID,transactionId);
    	//if(status != null && !status.isEmpty()) {
    		if(status.equalsIgnoreCase("6040")) {
    			System.out.println("Mobile Push is sent successfully:"+status);
    			return goTo(true).build();
    		}
    		else {
    			logger.info("deleting creential id");
    			deleteCredential(userName,credId,credType);
        		return goTo(false).build();
        	}
    	
    	/*	return goTo(true).build();
    	}else {
    		return goTo(false).build();
    	}*/
        
    }
    private void deleteCredential(String userName, String credId, String credType) {
    	DeleteCredential delCred = new DeleteCredential();
    	delCred.deleteCredential(userName, credId, credType);
    }
}