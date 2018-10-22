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

import javax.inject.Inject;

import org.forgerock.openam.annotations.sm.Attribute;
import org.forgerock.openam.auth.node.api.AbstractDecisionNode;
import org.forgerock.openam.auth.node.api.Action;
import org.forgerock.openam.auth.node.api.Node;
import org.forgerock.openam.auth.node.api.NodeProcessException;
import org.forgerock.openam.auth.node.api.SharedStateConstants;
import org.forgerock.openam.auth.node.api.TreeContext;
import org.forgerock.openam.core.CoreWrapper;
import com.google.inject.assistedinject.Assisted;

import com.symantec.tree.request.util.AddCredential;

import static com.symantec.tree.config.Constants.CREDCHOICE;
import static com.symantec.tree.config.Constants.CREDID;
import static com.symantec.tree.config.Constants.MOBNUM;
import static com.symantec.tree.config.Constants.SECURECODE;


/** 
 * A node that checks to see if user entered secureId against credentialId is valid or not. 
 */
@Node.Metadata(outcomeProvider  = AbstractDecisionNode.OutcomeProvider.class,
configClass      = SymantecVerifyCodeAddCred.Config.class)
public class SymantecVerifyCodeAddCred extends AbstractDecisionNode {
	
	
	  private final Config config;
	    private final CoreWrapper coreWrapper;
	    /*private final static String DEBUG_FILE = "SymantecRegisterUser";
	    protected Debug debug = Debug.getInstance(DEBUG_FILE);*/
	    
	    private AddCredential  addCred;
	   

	    /**
	     * Configuration for the node.
	     */
	    public interface Config {
	        @Attribute(order = 100,requiredValue = true)
	        default String credential() {
	            return "";
	        }
	    }
	    /**
	     * Create the node.
	     * @param config The service config.
	     * @throws NodeProcessException If the configuration was not valid.
	     */
	    @Inject
	    public SymantecVerifyCodeAddCred(@Assisted Config config, CoreWrapper coreWrapper) throws NodeProcessException {
	        this.config = config;
	        this.coreWrapper = coreWrapper;
	        addCred = new AddCredential();
	        
	    }

	    /** 
	     * A method that checks to see if user entered secureId against credentialId is valid or not. 
	     */
	    @Override
	    public Action process(TreeContext context) throws NodeProcessException {
	    	String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
	    	String credValue = context.sharedState.get(CREDID).asString();
	    	String credPhoneNumber = context.sharedState.get(MOBNUM).asString();
	    	
	    	String otpRecieved=context.sharedState.get(SECURECODE).asString();
	    	
	    	String credIdType="";
	    	if(context.sharedState.get(CREDCHOICE).asString().equalsIgnoreCase("SMS")) {
	    	
	    	credIdType="SMS_OTP";

	    	boolean isCredAdded = addCred.addCredential(userName,credPhoneNumber,credIdType,otpRecieved);
	    	//boolean isOTPSmsAuthenticated=smsReg.smsDeviceRegister(userName,credValue);
	    	return goTo(isCredAdded).build();
	    	}else if(context.sharedState.get(CREDCHOICE).asString().equalsIgnoreCase("VOICE")) {
	    	credIdType="VOICE_OTP";
	    	boolean isCredAdded = addCred.addCredential(userName,credPhoneNumber,credIdType,otpRecieved);
	    	// boolean isOTPVoiceAuthenticated=voiceReg.voiceDeviceRegister(userName,credValue);
	    	return goTo(isCredAdded).build();

	    	}
	    	else if(context.sharedState.get(CREDCHOICE).asString().equalsIgnoreCase("VIP")) {
	    		 credIdType="STANDARD_OTP";
	    		 boolean isCredAdded = addCred.addCredential(userName,credValue,credIdType,otpRecieved);
	    		 return goTo(isCredAdded).build();
	    	}
	    	    
	    	
   		 return goTo(false).build();
	    }

}
