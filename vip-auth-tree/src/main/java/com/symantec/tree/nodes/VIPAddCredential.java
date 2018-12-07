package com.symantec.tree.nodes;


import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import static com.symantec.tree.config.Constants.*;
import com.symantec.tree.request.util.AddCredential;
import com.symantec.tree.request.util.VIPGetUser;

import javax.inject.Inject;

import org.forgerock.guava.common.collect.ImmutableList;
import org.forgerock.json.JsonValue;
import org.forgerock.openam.auth.node.api.*;
import org.forgerock.openam.auth.node.api.Action.ActionBuilder;
import org.forgerock.util.i18n.PreferredLocales;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @author Sacumen (www.sacumen.com)<br> <br>
 * 
 * @category Node
 * 
 * "VIP Add Credential" node with TRUE, ERROR and FALSE outcome, If TRUE, go
 * to "VIP Authenticate Push Credentials", if ERROR go to "Display Error" else FALSE, go to "VIP Display Creds".
 * 
 * It adds credentials as credential ID  the to VIP Database.
 *             
 *
 */
@Node.Metadata(outcomeProvider = VIPAddCredential.SymantecOutcomeProvider.class, configClass = VIPAddCredential.Config.class)
public class VIPAddCredential implements Node {

	static Logger logger = LoggerFactory.getLogger(VIPAddCredential.class);
	private static final String BUNDLE = "com/symantec/tree/nodes/VIPAddCredential";

	private AddCredential addCred;
	private VIPGetUser vipSearchUser;

	
	/**
	 * Configuration for the node.
	 */
	public interface Config {

	}

	/**
	 * 
	 * @param addCred AddCredential class instance
	 * @param vipSearchUser VIPGetUser class instance
	 */
	@Inject
	public VIPAddCredential(AddCredential addCred,VIPGetUser vipSearchUser) {
		this.addCred = addCred;
		this.vipSearchUser = vipSearchUser;
	}

	/**
	 * Main logic of the node
	 */
	@Override
	public Action process(TreeContext context) throws NodeProcessException {
		
		//Getting configured parameters 
		String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
		String credValue = context.sharedState.get(CRED_ID).asString();
		String key_store = context.sharedState.get(KEY_STORE_PATH).asString();
		String key_store_pass = context.sharedState.get(KEY_STORE_PASS).asString();
		String credType = STANDARD_OTP;
		
		//Checking if user has already registered given credential id
		HashMap<String, String> credentialDetail = vipSearchUser.getCredentialBindingDetail(userName, key_store, key_store_pass, context);
		if(credentialDetail!=null && credentialDetail.containsKey("OATH_TIME")&& credentialDetail.get("OATH_TIME").equalsIgnoreCase(credValue)) {
			context.sharedState.put(CREDENTIAL_ID_ERROR, "Entered Credential ID is already registered, Please enter valid Credential ID or choose other option.");
			return goTo(Symantec.FALSE).build();
		}
		
		//Adding credentials to the user
		String statusCode = addCred.addCredential(userName, credValue,credType,key_store,key_store_pass);
		logger.debug("isCredAdded: "+statusCode);
		if(statusCode.equalsIgnoreCase(SUCCESS_CODE)) {
			logger.info("Crdentials is added successfully");
			return goTo(Symantec.TRUE).build();
		}
		else if(statusCode.equalsIgnoreCase(INVALID_CREDENIALS)||statusCode.equalsIgnoreCase(SCHEMA_INVALID)){
			logger.info("Entered Credential ID is Invalid");
			context.sharedState.put(CREDENTIAL_ID_ERROR, "Entered Credential ID is Invalid,Please enter valid Credential ID or choose other option.");
			return goTo(Symantec.FALSE).build();
		}
		else {
			logger.info("There is some error with entered Credential ID");
			context.sharedState.put(DISPLAY_ERROR, "Your Credential ID is disabled, Please contact to administrator");
			return goTo(Symantec.ERROR).build();
		}
		
	}
	
	/**
	 * The possible outcomes for the VIP Add Credential.
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
			ResourceBundle bundle = locales.getBundleInPreferredLocale(VIPAddCredential.BUNDLE,
					SymantecOutcomeProvider.class.getClassLoader());
			return ImmutableList.of(new Outcome(Symantec.TRUE.name(), bundle.getString("trueOutcome")),
					new Outcome(Symantec.FALSE.name(), bundle.getString("falseOutcome")),
					new Outcome(Symantec.ERROR.name(), bundle.getString("errorOutcome")));
		}
	}

}
