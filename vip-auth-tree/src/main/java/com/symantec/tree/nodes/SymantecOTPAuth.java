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
import com.sun.identity.sm.RequiredValueValidator;
import com.symantec.tree.request.util.SmsDeviceRegister;
import com.symantec.tree.request.util.VoiceDeviceRegister;

import static org.forgerock.openam.auth.node.api.Action.send;
import org.forgerock.json.JsonValue;
import org.forgerock.openam.annotations.sm.Attribute;
import org.forgerock.openam.auth.node.api.*;
import org.forgerock.openam.core.CoreWrapper;
import org.forgerock.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.forgerock.util.i18n.PreferredLocales;
import org.restlet.engine.io.InputStreamChannel;
import org.forgerock.guava.common.collect.ImmutableList;
import org.forgerock.openam.auth.node.api.Action.ActionBuilder;

import javax.inject.Inject;
import javax.security.auth.callback.ChoiceCallback;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.TextInputCallback;
import javax.security.auth.callback.TextOutputCallback;
import javax.security.auth.callback.Callback;

import java.util.*;

import static com.symantec.tree.config.Constants.CREDCHOICE;
import static com.symantec.tree.config.Constants.CREDID;
import static com.symantec.tree.config.Constants.MOBNUM;
import static com.symantec.tree.config.Constants.SECURECODE;
import static com.symantec.tree.config.Constants.SECURECODEERROR;

/** 
 * A node that checks to see if zero-page login headers have specified username and shared key 
 * for this request. 
 */
@Node.Metadata(outcomeProvider  = SymantecOTPAuth.OTPAuthOutcomeProvider.class,
               configClass      = SymantecOTPAuth.Config.class)
public class SymantecOTPAuth implements Node {

    private final Config config;
    private final CoreWrapper coreWrapper;
    private static final String BUNDLE = "com/symantec/tree/nodes/SymantecOTPAuth";
    private final Logger logger = LoggerFactory.getLogger("vipAuth");
    private SmsDeviceRegister smsReg;
    private VoiceDeviceRegister voiceReg;

    /**
     * Configuration for the node.
     */
    public interface Config {

        /**
         * A white list of allowed Creds. If a referer is required, the request must have a referer on this list.
         *
         * @return the cred list.
         */

        @Attribute(order = 100,validators={RequiredValueValidator.class})
        default Map<Integer, String> referrerCredList() {
            return Collections.emptyMap();
        }

    }
    /**
     * Create the node.
     * @param config The service config.
     * @throws NodeProcessException If the configuration was not valid.
     */
    @Inject
    public SymantecOTPAuth(@Assisted Config config, CoreWrapper coreWrapper) throws NodeProcessException {
        this.config = config;
        this.coreWrapper = coreWrapper;
    }

    @Override
    public Action process(TreeContext context) {

        /*JsonValue sharedState = context.sharedState;
        return context.getCallback(ChoiceCallback.class)
        		.map(c -> Integer.toString(c.getSelectedIndexes()[0]))
                .map(String::new)
                .filter(choice -> !Strings.isNullOrEmpty(choice))
                .map(choice -> {
                    logger.debug("choice has been collected and put in the shared state");
                    System.out.println("Selected index ... "+choice);
                    System.out.println("Selected value ... "+config.referrerCredList().get(Integer.parseInt(choice)));
                   
                    
                 
                    return goToNext()
                    		.replaceSharedState(sharedState.copy().put(CREDCHOICE, config.referrerCredList().get(Integer.parseInt(choice)))).build();
                })
                .orElseGet(() -> {
                    logger.debug("collecting choice");
                    return collectPassword(context);
                });*/
    	

        JsonValue sharedState = context.sharedState;
        String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
        String credValue = context.sharedState.get(MOBNUM).asString();
        
        Optional<NameCallback> nameCallback = context.getCallback(NameCallback.class);
        
        
        if(nameCallback != null && nameCallback.isPresent()) {
        	String textToken = context.getCallback(NameCallback.class)
                    .get().getName();
            if(textToken != null && !textToken.isEmpty()) {
            	logger.debug("SecureCode has been collected and placed  into the Shared State");
                //context.sharedState.copy().put("TokenText", textToken); 
                return goTo(SymantecOTPAuthOutcome.TOKEN).replaceSharedState(context.sharedState.copy().put(SECURECODE, textToken)).build();
            }
        }
        
        return context.getCallback(ChoiceCallback.class)
                .map(c -> c.getSelectedIndexes()[0])
                .map(Integer::new)
                .filter(choice -> -1 < choice && choice < 2 )
                .map(choice -> {
                	sharedState.put(CREDCHOICE, config.referrerCredList().get(choice));
                	switch(choice) {   
                	
                	case 1:
                		boolean isOTPVoiceAuthenticated=new VoiceDeviceRegister().voiceDeviceRegister(userName,credValue);
                		System.out.println("Voice Call sent .. "+isOTPVoiceAuthenticated);
                		return goTo(SymantecOTPAuthOutcome.VOICE).replaceSharedState(sharedState).build();
                	case 0:
                		boolean isOTPSmsAuthenticated=new SmsDeviceRegister().smsDeviceRegister(userName,credValue);
                    	System.out.println("OTP sent  "+isOTPSmsAuthenticated);
                    	return goTo(SymantecOTPAuthOutcome.SMS).replaceSharedState(sharedState).build();                		
                /*		
                	default:
                		System.out.println("Using Hardware or software token");
                		return goTo(SymantecOTPAuthOutcome.TOKEN).replaceSharedState(sharedState).build();
                */	}
                	return goTo(SymantecOTPAuthOutcome.TOKEN).replaceSharedState(sharedState).build();					
                	
                   // return goToNext()
                   //         .replaceTransientState(sharedState.copy().put(CREDCHOICE, config.referrerCredList().get(Integer.parseInt(choice)))).build();
                })
                .orElseGet(() -> {
                    logger.debug("collecting choice");         
                  /*.
                    .map("" -> {
                    	logger.debug("SecureCode has been collected and placed  into the Shared State");
                        context.sharedState.copy().put("", password);
                    });*/
                    
                    return displayCreds(context);
                });
    }

    private Action displayCreds(TreeContext context) {
    	List<Callback> cbList = new ArrayList<>(2);
    	Collection<String> values = config.referrerCredList().values();
    	if(values.contains("Token")) {
    		values.remove("Token");
    	}
        String[] targetArray = values.toArray(new String[values.size()]);
        String outputError=context.sharedState.get(SECURECODEERROR).asString();
        System.out.println("text block error"+outputError);
        if(outputError==null) {
        	
        	ResourceBundle bundle = context.request.locales.getBundleInPreferredLocale(BUNDLE, getClass().getClassLoader());
            ChoiceCallback ccb=new ChoiceCallback(bundle.getString("callback.creds"),targetArray,0,false);
            //TextInputCallback tinc= new TextInputCallback("Enter OTP");
            NameCallback ncb = new NameCallback("Enter OTP");
            cbList.add(ccb);
            cbList.add(ncb);
        }else {
        TextOutputCallback tcb= new TextOutputCallback(0, outputError);
    	ResourceBundle bundle = context.request.locales.getBundleInPreferredLocale(BUNDLE, getClass().getClassLoader());
        ChoiceCallback ccb=new ChoiceCallback(bundle.getString("callback.creds"),targetArray,0,false);
        //TextInputCallback tinc= new TextInputCallback("Enter OTP");
        NameCallback ncb = new NameCallback("Enter OTP");
        //TextOutputCallback topcb= new TextOutputCallback(0,"Enter Token");
       
        	cbList.add(tcb);
        	cbList.add(ccb);
        cbList.add(ncb);
        }
    //    cbList.add(topcb);
        
       // ChoiceCallback ccb=new ChoiceCallback(bundle.getString("callback.creds"),targetArray,0,false);
        
       /* Optional<TextInputCallback> textInputCallback = context.getCallback(TextInputCallback.class);
       
        if(textInputCallback != null && textInputCallback.isPresent()) {
        	String textToken = context.getCallback(TextInputCallback.class)
                    .get().getText();
            if(textToken != null && !textToken.isEmpty()) {
            	logger.debug("SecureCode has been collected and placed  into the Shared State");
                //context.sharedState.copy().put("TokenText", textToken); 
                return goTo(SymantecOTPAuthOutcome.TOKEN).replaceSharedState(context.sharedState.copy().put(SECURECODE, textToken)).build();
            }
        }
       */ 
                
        
        /*context.getCallback(TextInputCallback.class)
        .map(TextInputCallback::getText)
        .map(String::new)
        .filter(textCode -> !Strings.isNullOrEmpty(textCode))
        .map(textCode -> {
        	logger.debug("SecureCode has been collected and placed  into the Shared State");
            sharedState.copy().put(SECURECODE, textCode);
            return goTo(SymantecOTPAuthOutcome.VOICE).replaceSharedState(sharedState).build();
        });*/
        
        return send(ImmutableList.copyOf(cbList)).build(); 
    	/*ResourceBundle bundle = context.request.locales.getBundleInPreferredLocale(BUNDLE, getClass().getClassLoader());
    	Collection<String> values = config.referrerCredList().values();
    	String[] targetArray = values.toArray(new String[values.size()]); 	
        return send(new ChoiceCallback(bundle.getString("callback.creds"),targetArray,0,false)).build();*/
        
    }
    
    private ActionBuilder goTo(SymantecOTPAuthOutcome outcome) {
		return Action.goTo(outcome.name());
	}

	/**
	 * The possible outcomes for the SymantecVerifyAuth.
	 */
	public enum SymantecOTPAuthOutcome {
		/**
		 * selection for  SMS.
		 */
		SMS,
		/**
		 * selection for VOICE.
		 */
		VOICE,
		/**
		 * selection for TOKEN.
		 */
		TOKEN

	}
	
	/**
	 * Defines the possible outcomes from this SymantecOutcomeProvider node.
	 */
	public static class OTPAuthOutcomeProvider implements OutcomeProvider {
		@Override
		public List<Outcome> getOutcomes(PreferredLocales locales, JsonValue nodeAttributes) {
			ResourceBundle bundle = locales.getBundleInPreferredLocale(SymantecOTPAuth.BUNDLE,
					OTPAuthOutcomeProvider.class.getClassLoader());
			System.out.println("OUT come..."+new Outcome(SymantecOTPAuthOutcome.SMS.name(), bundle.getString("smsOutcome")));
			return ImmutableList.of(
					new Outcome(SymantecOTPAuthOutcome.SMS.name(), bundle.getString("smsOutcome")),
					new Outcome(SymantecOTPAuthOutcome.VOICE.name(), bundle.getString("voiceOutcome")),
					new Outcome(SymantecOTPAuthOutcome.TOKEN.name(), bundle.getString("tokenOutcome")));
		}
	}
}