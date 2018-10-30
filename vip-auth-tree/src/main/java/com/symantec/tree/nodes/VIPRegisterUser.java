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
import com.symantec.tree.request.util.VIPCreateUser;

import org.forgerock.openam.annotations.sm.Attribute;
import org.forgerock.openam.auth.node.api.*;
import org.forgerock.openam.core.CoreWrapper;

import javax.inject.Inject;

/** 
 * A node that checks to see if zero-page login headers have specified username and shared key 
 * for this request. 
 */
@Node.Metadata(outcomeProvider  = AbstractDecisionNode.OutcomeProvider.class,
               configClass      = VIPRegisterUser.Config.class)
public class VIPRegisterUser extends AbstractDecisionNode {

    private final Config config;
    private final CoreWrapper coreWrapper;
    private final static String DEBUG_FILE = "SymantecRegisterUser";
    protected Debug debug = Debug.getInstance(DEBUG_FILE);
    
    private VIPCreateUser  vIPCreateUser;

    /**
     * Configuration for the node.
     */
    public interface Config {
        @Attribute(order = 100,requiredValue = true)
        default String vipuserservice_url() {
            return "";
        }
    }
    /**
     * Create the node.
     * @param config The service config.
     * @throws NodeProcessException If the configuration was not valid.
     */
    @Inject
    public VIPRegisterUser(@Assisted Config config, CoreWrapper coreWrapper) throws NodeProcessException {
        this.config = config;
        this.coreWrapper = coreWrapper;
        vIPCreateUser = new VIPCreateUser();
    }

    @Override
    public Action process(TreeContext context) throws NodeProcessException {
    	String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
    	String credRegistrationStatus = context.transientState.get("NoCredentialRegistered").toString();
    	boolean isVIPProfileRegistered = false;
    	
    	System.out.println("credRegistrationStatus:"+credRegistrationStatus);
    	
    	
    	/*if(credRegistrationStatus != null && credRegistrationStatus.equalsIgnoreCase("true")) {
        	System.out.println("User already registered and hence not making user registration call");
    		isVIPProfileRegistered = true;
    		return goTo(isVIPProfileRegistered).build();
    	}*/
    	if(credRegistrationStatus != null && credRegistrationStatus.equalsIgnoreCase("true")) {
        	System.out.println("User already registered and hence not making user registration call");
    		isVIPProfileRegistered = true;
    		return goTo(isVIPProfileRegistered).build();
    	}
    	else {
        	System.out.println("User not registered and hence making user registration call");  
        	isVIPProfileRegistered = vIPCreateUser.createVIPUser(userName);        
	    	return goTo(isVIPProfileRegistered).build();
    	}
    }
}