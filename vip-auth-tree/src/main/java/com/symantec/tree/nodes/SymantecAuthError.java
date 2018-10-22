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

import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Inject;


import javax.security.auth.callback.TextOutputCallback;

import org.forgerock.guava.common.base.Strings;
import org.forgerock.guava.common.collect.ImmutableList;
import org.forgerock.json.JsonValue;
import org.forgerock.openam.auth.node.api.Action;
import org.forgerock.openam.auth.node.api.Node;
import org.forgerock.openam.auth.node.api.OutcomeProvider;
import org.forgerock.openam.auth.node.api.SingleOutcomeNode;
import org.forgerock.openam.auth.node.api.TreeContext;
import org.forgerock.openam.auth.node.api.Action.ActionBuilder;
import org.forgerock.openam.auth.node.api.OutcomeProvider.Outcome;
import org.forgerock.util.i18n.PreferredLocales;

import com.symantec.tree.nodes.SymantecDisplayCreds.CredsOutcomeProvider;
import com.symantec.tree.nodes.SymantecDisplayCreds.SymantecDisplayCredsOutcome;

import static com.symantec.tree.config.Constants.FINALCODEERROR;
import static com.symantec.tree.config.Constants.SECURECODEERROR;


/**
 * A node which displays Error for Invalid SecureId entered.
 *
 * 
 */
@Node.Metadata(outcomeProvider  = SymantecAuthError.AuthErrorProvider.class,
               configClass      = SymantecAuthError.Config.class)
public class SymantecAuthError implements Node {

    private static final String BUNDLE = "com/symantec/tree/nodes/SymantecAuthError";
    
    /**
     * Configuration for the node.
     */
    public interface Config {}

    /**
     * Create the node.
     */
    @Inject
    public SymantecAuthError() {
    	super();
        }
    
	private Action displayError(TreeContext context) {
		String outputError=context.sharedState.get(FINALCODEERROR).asString();
		TextOutputCallback pcb = new TextOutputCallback(0, outputError);
		return send(pcb).build();
	}

	/**
     * This Node method displays Error for Invalid SecureId Entered.
     */
    @Override
    public Action process(TreeContext context) {
    	
    	return context.getCallback(TextOutputCallback.class)
                .map(TextOutputCallback::getMessage)
                .map(String::new)
                .filter(name -> !Strings.isNullOrEmpty(name))
                .map(name -> {
                	
                	
                	if(context.sharedState.get(FINALCODEERROR).asString().equalsIgnoreCase("USER REACHED MAXIMUM NUMBER OF INVALID ATTEMPTS")) {
                		context.sharedState.put(FINALCODEERROR, "");
                		return goTo(SymantecAuthOutcome.SECUREIDERROR).replaceSharedState(context.sharedState).build();
                	}else
                		context.sharedState.put(FINALCODEERROR, "");
                		return goTo(SymantecAuthOutcome.FINALERROR).replaceSharedState(context.sharedState).build();
                })
                
                .orElseGet(() -> {
                	
                    return displayError(context);
                });
  
    }
    
    private ActionBuilder goTo(SymantecAuthOutcome outcome) {
		return Action.goTo(outcome.name());
	}

	/**
	 * The possible outcomes for the DisplayCredentail.
	 */
	public enum SymantecAuthOutcome {
		/**
		 * selection of VIP.
		 */
		SECUREIDERROR,
		/**
		 * selection for  SMS.
		 */
		FINALERROR
		

	}
	
	/**
	 * Defines the possible outcomes from this EntersektOutcomeProvider node.
	 */
	public static class AuthErrorProvider implements OutcomeProvider {
		@Override
		public List<Outcome> getOutcomes(PreferredLocales locales, JsonValue nodeAttributes) {
			ResourceBundle bundle = locales.getBundleInPreferredLocale(SymantecAuthError.BUNDLE,
					AuthErrorProvider.class.getClassLoader());
			return ImmutableList.of(
					new Outcome(SymantecAuthOutcome.SECUREIDERROR.name(), bundle.getString("secureiderror")),
					new Outcome(SymantecAuthOutcome.FINALERROR.name(), bundle.getString("finalerror")));
					
		}
	}
}