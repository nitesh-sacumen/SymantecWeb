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
import com.iplanet.sso.SSOException;
import com.sun.identity.idm.AMIdentity;
import com.sun.identity.idm.IdRepoException;
import com.sun.identity.shared.debug.Debug;
import com.sun.identity.sm.RequiredValueValidator;
import com.symantec.tree.request.util.AuthenticateUser;
import com.symantec.tree.request.util.VIPSearchUser;

import org.forgerock.openam.annotations.sm.Attribute;
import org.forgerock.openam.auth.node.api.*;
import org.forgerock.openam.core.CoreWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import static org.forgerock.openam.auth.node.api.SharedStateConstants.REALM;
import static org.forgerock.openam.auth.node.api.SharedStateConstants.USERNAME;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.symantec.tree.config.Constants;
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
    private final Logger logger = LoggerFactory.getLogger("SymantecPushAuth");
    
    private AuthenticateUser pushAuthUser;
    final Map<String, String> vipPushCodeMap = new HashMap<>();

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
    public SymantecPushAuth(@Assisted Config config, CoreWrapper coreWrapper) throws NodeProcessException {
        this.config = config;
        this.coreWrapper = coreWrapper;
        

        logger.debug("Display Message Text:",this.config.displayMsgText());
        vipPushCodeMap.put(Constants.PUSHDISPLAYMESSAGETEXT, this.config.displayMsgText());

        logger.debug("Display Message Title",this.config.displayMsgTitle());
        vipPushCodeMap.put(Constants.PUSHDISPLAYMESSAGETITLE, this.config.displayMsgTitle());

        logger.debug("Display Message Profile",this.config.displayMsgProfile());
        vipPushCodeMap.put(Constants.PUSHDISPLAYMESSAGEPROFILE, this.config.displayMsgProfile());
        
        pushAuthUser = new AuthenticateUser();
    }

    @Override
    public Action process(TreeContext context) throws NodeProcessException {
    	String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
    	String transactionId  = pushAuthUser.authUser(userName, vipPushCodeMap.get(Constants.PUSHDISPLAYMESSAGETEXT), vipPushCodeMap.get(Constants.PUSHDISPLAYMESSAGETITLE), vipPushCodeMap.get(Constants.PUSHDISPLAYMESSAGEPROFILE));
    	if(transactionId != null && !transactionId.isEmpty()) {
    		context.sharedState.put(TXNID,transactionId);
    		return goTo(true).build();
    	}else {
    		return goTo(false).build();
    	}
        
    }
}