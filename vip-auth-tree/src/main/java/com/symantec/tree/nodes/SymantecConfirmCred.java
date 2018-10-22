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
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.ConfirmationCallback;
import javax.security.auth.callback.TextOutputCallback;

import org.forgerock.guava.common.collect.ImmutableList;
import org.forgerock.json.JsonValue;
import org.forgerock.openam.auth.node.api.Action;
import org.forgerock.openam.auth.node.api.Node;
import org.forgerock.openam.auth.node.api.NodeProcessException;
import org.forgerock.openam.auth.node.api.OutcomeProvider;
import org.forgerock.openam.auth.node.api.TreeContext;
import org.forgerock.openam.auth.node.api.Action.ActionBuilder;
import org.forgerock.openam.core.CoreWrapper;
import org.forgerock.util.i18n.PreferredLocales;


import com.google.inject.assistedinject.Assisted;


import static org.forgerock.openam.auth.node.api.Action.send;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import static com.symantec.tree.config.Constants.CONFIRMCREDCHOICE;

/** 
 * A node that allows user to add more credentials.
 */
@Node.Metadata(outcomeProvider  = SymantecConfirmCred.CredsOutcomeProvider.class,
configClass      = SymantecConfirmCred.Config.class)
public class SymantecConfirmCred implements Node {

   private final Config config;
    private final CoreWrapper coreWrapper;
    private static final String BUNDLE = "com/symantec/tree/nodes/SymantecConfirmCred";
   

    /**
     * Configuration for the node.
     */
    public interface Config {

        /**
         * A white list of allowed Creds. If a referer is required, the request must have a referer on this list.
         *
         * @return the cred list.
         */

    	 /*      @Attribute(order = 100,validators={RequiredValueValidator.class})
      default Map<Integer, String> referrerCredList() {
            return Collections.emptyMap();
        }*/

    }
    /**
     * Create the node.
     * @param config The service config.
     * @throws NodeProcessException If the configuration was not valid.
     */
    @Inject
    public SymantecConfirmCred(@Assisted Config config, CoreWrapper coreWrapper) throws NodeProcessException {
        this.config = config;
        this.coreWrapper = coreWrapper;
    }

    /**
     * This Node method adds Credential if user wants to add more.
     */
    @Override
    public Action process(TreeContext context) {
  	
        JsonValue sharedState = context.sharedState;
        String inputChoice = "";
        
        List<ConfirmationCallback> confirmationCallback = context.getCallbacks(ConfirmationCallback.class);
        
        Iterator<ConfirmationCallback> it = confirmationCallback.iterator();
        
        while(it.hasNext()) {
        	ConfirmationCallback cc = it.next();
        	
        	inputChoice = SymantecConfirmCredOutcomeChoice.getChoiceByCode(cc.getSelectedIndex());
        	sharedState.put(CONFIRMCREDCHOICE, inputChoice);
        }
        
        switch(inputChoice) {
        case "YES":
    		
    		return goTo(SymantecConfirmCredOutcome.YES).replaceSharedState(sharedState).build();
    	    		       
        case "NO":
        	
        	return goTo(SymantecConfirmCredOutcome.NO).replaceSharedState(sharedState).build();
                	
        }	
        
        	return displayCreds(context);
      	   
        }

    /**
     * This Node method displays Confirmation details .
     */
    private Action displayCreds(TreeContext context) {
    	List<Callback> cbList = new ArrayList<>(2);
        ResourceBundle bundle = context.request.locales.getBundleInPreferredLocale(BUNDLE, getClass().getClassLoader());               
      
        TextOutputCallback tocb = new TextOutputCallback(0, "Add More Credentials  ");
        ConfirmationCallback ccb = new ConfirmationCallback(bundle.getString("callback.creds"),ConfirmationCallback.INFORMATION,new String[]{"YES", "NO"}, 0);
       
        cbList.add(tocb);
        cbList.add(ccb);
        return send(cbList).build();
    }
    
    private ActionBuilder goTo(SymantecConfirmCredOutcome outcome) {
		return Action.goTo(outcome.name());
	}

	/**
	 * The possible outcomes for the ConfirmCred.
	 */
	public enum SymantecConfirmCredOutcome {
		/**
		 * selection of VIP.
		 */
		YES,
		/**
		 * selection for  SMS.
		 */
		NO,
		/**
		 * selection for VOICE.
		 
		CANCEL*/

	}
	/**
     * This ENum is for  Selecting Choice
     */
	public enum SymantecConfirmCredOutcomeChoice {
		
		YES(0,"YES"),
		NO(1,"NO");
		
		private int code;
		private String choice;
		SymantecConfirmCredOutcomeChoice(int code, String choice){
			this.code = code;
			this.choice = choice;
		}
		
		public static String getChoiceByCode(int code) {
			for(SymantecConfirmCredOutcomeChoice syc : SymantecConfirmCredOutcomeChoice.values()) {
				if(syc.code == code) {
					return syc.choice;
				}
			}
			return "";
		}
		
		
	}

	
	/**
	 * Defines the possible outcomes from this ConfirmCRED  node.
	 */
	public static class CredsOutcomeProvider implements OutcomeProvider {
		@Override
		public List<Outcome> getOutcomes(PreferredLocales locales, JsonValue nodeAttributes) {
			ResourceBundle bundle = locales.getBundleInPreferredLocale(SymantecConfirmCred.BUNDLE,
					CredsOutcomeProvider.class.getClassLoader());
			return ImmutableList.of(
					new Outcome(SymantecConfirmCredOutcome.YES.name(), bundle.getString("YesOutcome")),
					new Outcome(SymantecConfirmCredOutcome.NO.name(), bundle.getString("NoOutcome")));
				//	new Outcome(SymantecDisplayCredsOutcome.CANCEL.name(), bundle.getString("CancelOutcome")));
		}
	}
}