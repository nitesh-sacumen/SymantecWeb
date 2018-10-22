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
import com.symantec.tree.request.util.AuthenticateUser;
import org.forgerock.openam.auth.node.api.*;
import org.forgerock.openam.core.CoreWrapper;
import javax.inject.Inject;



import static com.symantec.tree.config.Constants.TXNID;

/** 
 * A node that checks to see if zero-page login headers have specified username and shared key 
 * for this request. 
 */
@Node.Metadata(outcomeProvider  = AbstractDecisionNode.OutcomeProvider.class,
               configClass      = SymantecPushAuth.Config.class)
public class SymantecPushAuth extends AbstractDecisionNode {

    private final Config config;
    private final CoreWrapper coreWrapper;
    private final static String DEBUG_FILE = "SymantecSearchUser";
    protected Debug debug = Debug.getInstance(DEBUG_FILE);
    
    private AuthenticateUser pushAuthUser;

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
    public SymantecPushAuth(@Assisted Config config, CoreWrapper coreWrapper) throws NodeProcessException {
        this.config = config;
        this.coreWrapper = coreWrapper;
        pushAuthUser = new AuthenticateUser();
    }

	/**
	 * 	This Node method sends Push Notification to User.
	 */
    @Override
    public Action process(TreeContext context) throws NodeProcessException {
    	String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
    	String transactionId  = pushAuthUser.authUser(userName);
    	if(transactionId != null && !transactionId.isEmpty()) {
    		context.sharedState.put(TXNID,transactionId);
    		return goTo(true).build();
    	}else {
    		return goTo(false).build();
    	}
        
    }
}