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

import static org.forgerock.openam.auth.node.api.Action.send;
import static org.forgerock.openam.auth.node.api.SharedStateConstants.ONE_TIME_PASSWORD;

import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.TextOutputCallback;

import org.forgerock.guava.common.base.Strings;
import org.forgerock.json.JsonValue;
import org.forgerock.openam.auth.node.api.Action;
import org.forgerock.openam.auth.node.api.Node;
import org.forgerock.openam.auth.node.api.SingleOutcomeNode;
import org.forgerock.openam.auth.node.api.TreeContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.symantec.tree.request.util.SMSVoiceRegister;

import static com.symantec.tree.config.Constants.CREDID;
import static com.symantec.tree.config.Constants.SECURECODEERROR;
import static com.symantec.tree.config.Constants.FINALCODEERROR;
import static com.symantec.tree.config.Constants.CREDCHOICE;
/**
 * A node which collects a OTP from the user via a password callback.
 *
 * <p>Places the result in the transient state as 'ONE TIME PASSWORD'.</p>
 */
@Node.Metadata(outcomeProvider  = SingleOutcomeNode.OutcomeProvider.class,
               configClass      = SymantecAuthError.Config.class)
public class SymantecAuthError extends SingleOutcomeNode {

    private static final String BUNDLE = "com/symantec/tree/nodes/SymantecAuthError";
    private final Logger logger = LoggerFactory.getLogger("vipAuth");
    private SMSVoiceRegister svRegister;
    /**
     * Configuration for the node.
     */
    public interface Config {}


    /**
     * Create the node.
     */
    @Inject
    public SymantecAuthError() {
    	svRegister= new SMSVoiceRegister();

    }
    
	private Action displayError(TreeContext context) {
		String outputError=context.sharedState.get(FINALCODEERROR).asString();
		TextOutputCallback pcb = new TextOutputCallback(0, outputError);
		return send(pcb).build();
	}

    @Override
    public Action process(TreeContext context) {
    	
    	return displayError(context);
    }
}