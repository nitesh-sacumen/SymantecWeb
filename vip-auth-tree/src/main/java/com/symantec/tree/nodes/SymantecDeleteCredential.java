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
 * 
 *
 * Copyright 2018 Sacumen.
 */


package com.symantec.tree.nodes;



import javax.inject.Inject;

import org.forgerock.json.JsonValue;
import org.forgerock.openam.auth.node.api.Action;
import org.forgerock.openam.auth.node.api.Node;
import org.forgerock.openam.auth.node.api.SharedStateConstants;
import org.forgerock.openam.auth.node.api.SingleOutcomeNode;
import org.forgerock.openam.auth.node.api.TreeContext;
import org.forgerock.openam.core.CoreWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.assistedinject.Assisted;

import com.symantec.tree.request.util.DeleteCredential;

import static com.symantec.tree.config.Constants.CREDID;
import static com.symantec.tree.config.Constants.CREDCHOICE;

/**
 * A node which deletes credential if incorrect secureId is provided.
 */
@Node.Metadata(outcomeProvider  = SingleOutcomeNode.OutcomeProvider.class,
               configClass      = SymantecDeleteCredential.Config.class)
public class SymantecDeleteCredential extends SingleOutcomeNode {

   // private static final String BUNDLE = "com/symantec/tree/nodes/SymantecDeleteCredential";
    private final Logger logger = LoggerFactory.getLogger("symantec");
    DeleteCredential delCred;
	private Config config;
	private CoreWrapper coreWrapper;
    /**
     * Configuration for the node.
     */
    public interface Config {}


    /**
     * Create the node.
     */
    @Inject
    public SymantecDeleteCredential(@Assisted Config config, CoreWrapper coreWrapper) {

    	this.config = config;
        this.coreWrapper = coreWrapper;
        delCred = new DeleteCredential();
    }
    /**
     * This Node method deletes Credential of the user.
     */
      @Override
    public Action process(TreeContext context) {
    	logger.debug("Collect SecurityCode started");
        
        String credId = context.sharedState.get(CREDID).asString();
        String credType = context.sharedState.get(CREDCHOICE).asString();
        String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
        delCred.deleteCredential(userName, credId, credType);
       
        return goToNext().build();
            
    }
}