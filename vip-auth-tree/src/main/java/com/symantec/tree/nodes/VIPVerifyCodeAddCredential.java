package com.symantec.tree.nodes;

import static com.symantec.tree.config.Constants.AUTHENTICATION_FAILED;
import static com.symantec.tree.config.Constants.CRED_CHOICE;
import static com.symantec.tree.config.Constants.CRED_ID;
import static com.symantec.tree.config.Constants.DISPLAY_ERROR;
import static com.symantec.tree.config.Constants.INVALID_CREDENIALS;
import static com.symantec.tree.config.Constants.KEY_STORE_PASS;
import static com.symantec.tree.config.Constants.KEY_STORE_PATH;
import static com.symantec.tree.config.Constants.MOB_NUM;
import static com.symantec.tree.config.Constants.OTP_ERROR;
import static com.symantec.tree.config.Constants.SECURE_CODE;
import static com.symantec.tree.config.Constants.SMS;
import static com.symantec.tree.config.Constants.SMS_OTP;
import static com.symantec.tree.config.Constants.STANDARD_OTP;
import static com.symantec.tree.config.Constants.SUCCESS_CODE;
import static com.symantec.tree.config.Constants.VOICE;
import static com.symantec.tree.config.Constants.VOICE_OTP;

import com.google.common.collect.ImmutableList;
import com.symantec.tree.request.util.AddCredential;
import java.util.List;
import java.util.ResourceBundle;
import javax.inject.Inject;
import org.forgerock.json.JsonValue;
import org.forgerock.openam.auth.node.api.Action;
import org.forgerock.openam.auth.node.api.Action.ActionBuilder;
import org.forgerock.openam.auth.node.api.Node;
import org.forgerock.openam.auth.node.api.NodeProcessException;
import org.forgerock.openam.auth.node.api.OutcomeProvider;
import org.forgerock.openam.auth.node.api.SharedStateConstants;
import org.forgerock.openam.auth.node.api.TreeContext;
import org.forgerock.util.i18n.PreferredLocales;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Sacumen(www.sacumen.com)<br> <br>
 * 
 * @category Node
 * 
 * "VIP AddCred with VerifyCode" node with TRUE,FALSE and ERROR outcome. If
 * TRUE, it will go to "VIP Add More Creds". If False, go to "VIP
 * Enter SecurityCode/OTP" and if ERROR, go to "VIP Display Error".
 *
 * It verifies OTP and add credential.
 */
@Node.Metadata(outcomeProvider = VIPVerifyCodeAddCredential.SymantecOutcomeProvider.class, configClass = VIPVerifyCodeAddCredential.Config.class)
public class VIPVerifyCodeAddCredential implements Node {

	Logger logger = LoggerFactory.getLogger(VIPVerifyCodeAddCredential.class);
	private static final String BUNDLE = "com/symantec/tree/nodes/VIPVerifyCodeAddCredential";

	private AddCredential addCred;

	/**
	 * Configuration for the node.
	 */
	public interface Config {

	}

	/**
	 * 
	 * @param addCred AddCredential instance
	 */
	@Inject
	public VIPVerifyCodeAddCredential(AddCredential addCred) {
		this.addCred = addCred;
	}

	/**
	 * Main logic of the node.
	 * @throws NodeProcessException 
	 */
	@Override
	public Action process(TreeContext context) throws NodeProcessException {
		
		//Getting configured parameters
		context.sharedState.remove(OTP_ERROR);
		String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
		String credValue = context.sharedState.get(CRED_ID).asString();
		String credPhoneNumber = context.sharedState.get(MOB_NUM).asString();
		String otpReceived = context.sharedState.get(SECURE_CODE).asString();
		String key_store = context.sharedState.get(KEY_STORE_PATH).asString();
		String key_store_pass = context.sharedState.get(KEY_STORE_PASS).asString();
		logger.debug("Secure code" + otpReceived);
		String credIdType;
		
		// Calling AddCredentialRequest for SMS Cred Type 
		if (context.sharedState.get(CRED_CHOICE).asString().equalsIgnoreCase(SMS)) {
			credIdType = SMS_OTP;
			String statusCode = addCred.addCredential(userName, credPhoneNumber, credIdType, otpReceived,
					key_store,key_store_pass);
			return sendOutput(statusCode, context);
		} 
		
		//Calling AddCredentialRequest for VOICE Cred Type 
		else if (context.sharedState.get(CRED_CHOICE).asString().equalsIgnoreCase(VOICE)) {
			credIdType = VOICE_OTP;
			String statusCode = addCred.addCredential(userName, credPhoneNumber, credIdType, otpReceived,
					key_store,key_store_pass);
			return sendOutput(statusCode, context);
		}
		
		// Calling AddCredentialRequest For STANDARD_OTP Cred Type 
		else {
			credIdType = STANDARD_OTP;
			String statusCode = addCred.addCredential(userName, credValue, credIdType, otpReceived,key_store,key_store_pass);
			return sendOutput(statusCode, context);
		}
	}
	
	/**
	 * The possible outcomes for the VIP AddCred with VerifyCode.
	 */
	private enum Symantec {
		/**
		 * Successful.
		 */
		TRUE,
		/**
		 * failed.
		 */
		FALSE,
		/**
		 * Disabled.
		 */
		ERROR

	}
	
	private ActionBuilder goTo(Symantec outcome) {
		return Action.goTo(outcome.name());
	}
	
	/**
	 * Defines the possible outcomes from this SymantecOutcomeProvider node.
	 */
	public static class SymantecOutcomeProvider implements OutcomeProvider {
		@Override
		public List<Outcome> getOutcomes(PreferredLocales locales, JsonValue nodeAttributes) {
			ResourceBundle bundle = locales.getBundleInPreferredLocale(VIPVerifyCodeAddCredential.BUNDLE,
					SymantecOutcomeProvider.class.getClassLoader());
			return ImmutableList.of(new Outcome(Symantec.TRUE.name(), bundle.getString("trueOutcome")),
									new Outcome(Symantec.FALSE.name(), bundle.getString("falseOutcome")),
									new Outcome(Symantec.ERROR.name(), bundle.getString("errorOutcome")));
		}
	}

	/**
	 * 
	 * @param statusCode response status code of AddCredentialRequest
	 * @param context TreeContext instance
	 * @return Action instance
	 * 
	 * It makes decision for outcome according to response status code of AddCredentialRequest.
	 */
	private Action sendOutput(String statusCode, TreeContext context) {
		if (statusCode.equalsIgnoreCase(SUCCESS_CODE)) {
			return goTo(Symantec.TRUE).build();
		} else if(statusCode.equalsIgnoreCase(INVALID_CREDENIALS) || statusCode.equalsIgnoreCase(AUTHENTICATION_FAILED)) {
				context.sharedState.put(OTP_ERROR, "Entered otp Code is Invalid,Please enter valid OTP");
				return goTo(Symantec.FALSE).build();
		}
		else {
			context.sharedState.put(DISPLAY_ERROR, "Your Credentials is disabled, Please contact your administrator.");
			return goTo(Symantec.ERROR).build();
		}
	}

}
