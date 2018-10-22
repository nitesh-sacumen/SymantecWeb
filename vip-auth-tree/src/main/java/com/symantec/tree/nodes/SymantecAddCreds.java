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
import com.sun.identity.shared.debug.Debug;
import com.symantec.tree.config.UiMapping;
import com.symantec.tree.request.util.AddCredential;


import static com.symantec.tree.config.Constants.CREDCHOICE;
import static com.symantec.tree.config.Constants.CREDID;


/**
 * This Node class is used to add credential i.e VIP/SMS/VOICE to Symantec
 */
@Node.Metadata(outcomeProvider  = AbstractDecisionNode.OutcomeProvider.class,
configClass      = SymantecAddCreds.Config.class)
public class SymantecAddCreds extends AbstractDecisionNode {
	
	
	  private final Config config;
	    private final CoreWrapper coreWrapper;
	    
	    /**
	     * Node Properties
	     */
	    private final static String DEBUG_FILE = "SymantecRegisterUser";  
	  
	    /**
	     * Node Properties
	     */
	    protected Debug debug = Debug.getInstance(DEBUG_FILE); //Node Properties 
	    
	    /**
	     * Reference variable for AddCredential class
	     */
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
	    public SymantecAddCreds(@Assisted Config config, CoreWrapper coreWrapper) throws NodeProcessException {
	        this.config = config;
	        this.coreWrapper = coreWrapper;
	        addCred = new AddCredential();
	       
	    }

	    /**
	     * This Node method adds Credential to the user.
	     */
	    @Override
	    public Action process(TreeContext context) throws NodeProcessException {
	    	
	     	        	
	    	String credIdType = "";
	    	    		if(context.sharedState.get(CREDCHOICE).asString().equalsIgnoreCase("VIP")) {
	    		 credIdType=UiMapping.mapping().get(context.sharedState.get(CREDCHOICE).asString()).toString();
	    		 String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
	 	    	String credValue = context.sharedState.get(CREDID).asString();
	    		 boolean isCredAdded = addCred.addCredential(userName,credValue,credIdType);
	    		 return goTo(isCredAdded).build();
	    	}	    	    
	    	
   		 return goTo(false).build();
	    }

}
