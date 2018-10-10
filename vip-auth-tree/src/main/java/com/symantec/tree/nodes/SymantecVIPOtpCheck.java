package com.symantec.tree.nodes;

import javax.inject.Inject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.TextOutputCallback;

import org.forgerock.guava.common.collect.ImmutableList;
import org.forgerock.json.JsonValue;
import org.forgerock.openam.annotations.sm.Attribute;
import org.forgerock.openam.auth.node.api.AbstractDecisionNode;
import org.forgerock.openam.auth.node.api.Action;
import org.forgerock.openam.auth.node.api.Node;
import org.forgerock.openam.auth.node.api.NodeProcessException;
import org.forgerock.openam.auth.node.api.OutcomeProvider;
import org.forgerock.openam.auth.node.api.SharedStateConstants;
import org.forgerock.openam.auth.node.api.SingleOutcomeNode;
import org.forgerock.openam.auth.node.api.TreeContext;
import org.forgerock.openam.auth.node.api.Action.ActionBuilder;
import org.forgerock.openam.auth.node.api.OutcomeProvider.Outcome;
import org.forgerock.openam.core.CoreWrapper;
import org.forgerock.util.i18n.PreferredLocales;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.assistedinject.Assisted;
import com.sun.identity.shared.debug.Debug;
import com.symantec.tree.nodes.SymantecPollPushAuth.Symantec;
import com.symantec.tree.nodes.SymantecPollPushAuth.SymantecOutcomeProvider;
import com.symantec.tree.request.util.CheckVIPOtp;
import com.symantec.tree.request.util.SmsDeviceRegister;
import static com.symantec.tree.config.Constants.SECURECODE;

import static com.symantec.tree.config.Constants.SECURECODEERROR;
import static com.symantec.tree.config.Constants.FINALCODEERROR;
import static org.forgerock.openam.auth.node.api.Action.send;

import java.util.List;
import java.util.ResourceBundle;


@Node.Metadata(outcomeProvider  = SymantecVIPOtpCheck.SymantecOutcomeProvider.class,
configClass= SymantecVIPOtpCheck.Config.class)
public class SymantecVIPOtpCheck implements Node  {

	private final Config config;
    private final CoreWrapper coreWrapper;
    private final static String DEBUG_FILE = "SymantecRegisterUser";
    protected Debug debug = Debug.getInstance(DEBUG_FILE);
    
    private static final String BUNDLE = "com/symantec/tree/nodes/SymantecVIPOtpCheck";
    private final Logger logger = LoggerFactory.getLogger("entersektAuth");
    
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

    @Override
    public Action process(TreeContext context) throws NodeProcessException {
    	JsonValue sharedState = context.sharedState.copy();
    	
    	String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
    	//String otpValue = context.sharedState.get(config.OTP()).asString();
    	String otpValue = context.sharedState.get(SECURECODE).asString();
    	boolean isDeviceAdded = checkOtp.checkOtp(userName, otpValue);  
    	System.out.println("Check OTP is"+ isDeviceAdded);
    	if(isDeviceAdded) {
    	return goTo(Symantec.TRUE).build();
    	}
    	else {
    		/*TextOutputCallback top= new TextOutputCallback(0,"Entered secureId is Invalid");
    		Callback[] callbacks = new Callback[]{top};*/
    		counter=counter+1;
    		System.out.println("Check OTP failed"+counter);
    		 if(counter>3) {
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
	 * The possible outcomes for the EntersektVerifyAuth.
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
	 * Defines the possible outcomes from this EntersektOutcomeProvider node.
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
	

   /* private Action sendErrorMessage(TreeContext context) throws NodeProcessException {
        ResourceBundle bundle = context.request.locales.getBundleInPreferredLocale(BUNDLE, getClass().getClassLoader());
        logger.debug("OTP verification failed !!!!");
        System.out.println("OTP verification failed");
        
        return send(new TextOutputCallback(TextOutputCallback.ERROR,bundle.getString("vipotp.error"))).build();
    }*/
    
}
