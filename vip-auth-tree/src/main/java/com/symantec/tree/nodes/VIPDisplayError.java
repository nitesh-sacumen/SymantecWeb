package com.symantec.tree.nodes;

import static com.symantec.tree.config.Constants.OTP_ERROR;
import static org.forgerock.openam.auth.node.api.Action.send;

import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.security.auth.callback.TextOutputCallback;

import org.forgerock.guava.common.base.Strings;
import org.forgerock.json.JsonValue;
import org.forgerock.openam.auth.node.api.Action;
import org.forgerock.openam.auth.node.api.Action.ActionBuilder;
import org.forgerock.openam.auth.node.api.Node;
import org.forgerock.openam.auth.node.api.OutcomeProvider;
import org.forgerock.openam.auth.node.api.TreeContext;
import org.forgerock.util.i18n.PreferredLocales;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableList;

/**
 * 
 * @author Sacumen(www.sacumen.com)
 * @category Node
 * @Descrition "VIP DISPLAY ERROR" node with YES and NO outcome, If yes, go
 *             to "login failure".If no go to "VIP Enter Security Code/OTP ".
 *
 */
@Node.Metadata(outcomeProvider  = VIPDisplayError.AuthErrorProvider.class,
               configClass      = VIPDisplayError.Config.class)
public class VIPDisplayError implements Node{
	 private static final String BUNDLE = "com/symantec/tree/nodes/VIPDisplayError";
	 private final Logger logger = LoggerFactory.getLogger(VIPDisplayError.class);

	    
	    /**
	     * Configuration for the node.
	     */
	    public interface Config {}

	    /**
	     * Create the node.
	     */
	    @Inject
	    public VIPDisplayError() {
	    	super();
	        }
	    
		private Action displayError(TreeContext context) {
			String outputError=context.sharedState.get(OTP_ERROR).asString();
			TextOutputCallback pcb = new TextOutputCallback(0, outputError);
			return send(pcb).build();
		}

		/**
	     * This Node method displays Error for maximum attempts of Invalid otp Entered.
	     */
	    @Override
	    public Action process(TreeContext context) {
	    	logger.info("Inside VIP DISPLAY ERROR Page");
	    	return context.getCallback(TextOutputCallback.class)
	                .map(TextOutputCallback::getMessage)
	                .map(String::new)
	                .filter(name -> !Strings.isNullOrEmpty(name))
	                .map(name -> {
	                	
	                	
	                	if(context.sharedState.get(OTP_ERROR).asString().equalsIgnoreCase("USER REACHED MAXIMUM NUMBER OF INVALID ATTEMPTS")) {
	                		return goTo(SymantecAuthOutcome.YES).replaceSharedState(context.sharedState).build();
	                	}else
	                		return goTo(SymantecAuthOutcome.NO).replaceSharedState(context.sharedState).build();
	                }).orElseGet(() -> {
	                	
	                    return displayError(context);
	                });
	  
	    }
	    
	    private ActionBuilder goTo(SymantecAuthOutcome outcome) {
			return Action.goTo(outcome.name());
		}

		/**
		 * The possible outcomes for the DISPLAY ERROR.
		 */
		public enum SymantecAuthOutcome {
			/**
			 * If error occurs.
			 */
			YES,
			/**
			 * If error doesn't occur.
			 */
			NO
			

		}
		
		/**
		 * Defines the possible outcomes from this VIPDisplayError node.
		 */
		public static class AuthErrorProvider implements OutcomeProvider {
			@Override
			public List<Outcome> getOutcomes(PreferredLocales locales, JsonValue nodeAttributes) {
				ResourceBundle bundle = locales.getBundleInPreferredLocale(VIPDisplayError.BUNDLE,
						AuthErrorProvider.class.getClassLoader());
				return ImmutableList.of(
						new Outcome(SymantecAuthOutcome.YES.name(), bundle.getString("yes")),
						new Outcome(SymantecAuthOutcome.NO.name(), bundle.getString("no")));
						
			}
		}

}
