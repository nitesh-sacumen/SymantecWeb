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
import org.forgerock.guava.common.collect.ImmutableList;
import org.forgerock.json.JsonValue;
import org.forgerock.openam.auth.node.api.Action;
import org.forgerock.openam.auth.node.api.Node;
import org.forgerock.openam.auth.node.api.NodeProcessException;
import org.forgerock.openam.auth.node.api.OutcomeProvider;
import org.forgerock.openam.auth.node.api.SharedStateConstants;
import org.forgerock.openam.auth.node.api.TreeContext;
import org.forgerock.openam.auth.node.api.Action.ActionBuilder;
import org.forgerock.openam.core.CoreWrapper;
import org.forgerock.util.i18n.PreferredLocales;
import com.google.inject.assistedinject.Assisted;
import com.sun.identity.shared.debug.Debug;
import com.symantec.tree.request.util.CheckVIPOtp;
import static com.symantec.tree.config.Constants.SECURECODE;
import static com.symantec.tree.config.Constants.SECURECODEERROR;
import static com.symantec.tree.config.Constants.FINALCODEERROR;
import java.util.List;
import java.util.ResourceBundle;


/** 
 * A node that checks to see if user enter OTP recieved is valid or not. 
 */
@Node.Metadata(outcomeProvider  = SymantecVIPOtpCheck.SymantecOutcomeProvider.class,
configClass= SymantecVIPOtpCheck.Config.class)
public class SymantecVIPOtpCheck implements Node  {

	private final Config config;
    private final CoreWrapper coreWrapper;
    private final static String DEBUG_FILE = "SymantecRegisterUser";
    protected Debug debug = Debug.getInstance(DEBUG_FILE);
    
    private static final String BUNDLE = "com/symantec/tree/nodes/SymantecVIPOtpCheck";
    
    
    private CheckVIPOtp  checkOtp;
    static int counter=0;

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
    public SymantecVIPOtpCheck(@Assisted Config config, CoreWrapper coreWrapper) throws NodeProcessException {
        this.config = config;
        this.coreWrapper = coreWrapper;
        checkOtp = new CheckVIPOtp();
    }

    /** 
     * A Method that checks to see if user enter OTP recieved is valid or not. 
     */
    @Override
    public Action process(TreeContext context) throws NodeProcessException {
    	
    	
    	String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
    	//String otpValue = context.sharedState.get(config.OTP()).asString();
    	String otpValue = context.sharedState.get(SECURECODE).asString();
    	boolean isDeviceAdded = checkOtp.checkOtp(userName, otpValue);  
    	
    	if(isDeviceAdded) {
    	return goTo(Symantec.TRUE).build();
    	}
    	else {
    		/*TextOutputCallback top= new TextOutputCallback(0,"Entered secureId is Invalid");
    		Callback[] callbacks = new Callback[]{top};*/
    		counter=counter+1;
    		
    		 if(counter>3) {
    			 counter=0;
      			context.sharedState.put(FINALCODEERROR,"USER REACHED MAXIMUM NUMBER OF INVALID ATTEMPTS");
              	return goTo(Symantec.ERROR).build();
              }
    		 else
    		context.sharedState.put(SECURECODEERROR,"Entered secureId is Invalid");
            return goTo(Symantec.FALSE).build();
            
             }
             
    }

    private ActionBuilder goTo(Symantec outcome) {
		return Action.goTo(outcome.name());
	}

	/**
	 * The possible outcomes for the VIPOTPCHECK.
	 */
	public enum Symantec {
		/**
		 * Successful authentication.
		 */
		TRUE,
		/**
		 * Authentication failed.
		 */
		FALSE,
		/**
		 * The user has not been answered.
		 */
		ERROR

	}


	/**
	 * Defines the possible outcomes from this VIPOTPCHECK node.
	 */
	public static class SymantecOutcomeProvider implements OutcomeProvider {
		@Override
		public List<Outcome> getOutcomes(PreferredLocales locales, JsonValue nodeAttributes) {
			ResourceBundle bundle = locales.getBundleInPreferredLocale(SymantecVIPOtpCheck.BUNDLE,
					SymantecOutcomeProvider.class.getClassLoader());
			return ImmutableList.of(
					new Outcome(Symantec.TRUE.name(), bundle.getString("trueOutcome")),
					new Outcome(Symantec.FALSE.name(), bundle.getString("falseOutcome")),
					new Outcome(Symantec.ERROR.name(), bundle.getString("errorOutcome")));
		}
	}
    
}
