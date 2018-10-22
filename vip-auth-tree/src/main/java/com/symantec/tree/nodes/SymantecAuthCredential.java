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
import com.symantec.tree.request.util.AuthenticateCredential;
import org.forgerock.openam.auth.node.api.*;
import org.forgerock.openam.core.CoreWrapper;

import javax.inject.Inject;

import static com.symantec.tree.config.Constants.TXNID;
import static com.symantec.tree.config.Constants.CREDID;


/** 
 * A node that checks to see if zero-page login headers
 *  have specified username and shared key 
 * for this request. 
 */
@Node.Metadata(outcomeProvider  = AbstractDecisionNode.OutcomeProvider.class,
               configClass      = SymantecAuthCredential.Config.class)
public class SymantecAuthCredential extends AbstractDecisionNode {

    private final static String DEBUG_FILE = "SymantecSearchUser";
    protected Debug debug = Debug.getInstance(DEBUG_FILE);
    
    private AuthenticateCredential authPushCred;

    /**
     * Configuration for the node.
     */
    public interface Config {
     
    }
    /**
     * Create the node.
     * @param config The service config.
     * @throws NodeProcessException If the configuration was not valid.
     */
    @Inject
    public SymantecAuthCredential(@Assisted Config config, CoreWrapper coreWrapper) throws NodeProcessException {
        authPushCred = new AuthenticateCredential();
    }

    /**
     * This Node method Authenticates Credential.
     */
    @Override
    public Action process(TreeContext context) throws NodeProcessException {
  
    	String credId = context.sharedState.get(CREDID).asString();
  
    	String stat  = authPushCred.authCredential(credId);
    	String[] trastat=stat.split(",");
    	
    	String status=trastat[0];
    	String transactionId=trastat[1];
    	    	
    	context.sharedState.put(TXNID,transactionId);
    	
    		if(status.equalsIgnoreCase("6040")) {
    			
    			return goTo(true).build();
    		}
    		/*else if(status.equalsIgnoreCase("6043")) {
    			
    			return goTo(false).build();
    		}
    		else if(status.equalsIgnoreCase("603E")) {
    			
    			return goTo(false).build();
    		}
    		else if(status.equalsIgnoreCase("6004")) {
    			
    			return goTo(false).build();
    		}*/
    		else {
        		return goTo(false).build();
        	}
           
    }
}