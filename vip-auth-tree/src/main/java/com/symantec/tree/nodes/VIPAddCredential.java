package com.symantec.tree.nodes;

import static com.symantec.tree.config.Constants.*;
import com.symantec.tree.request.util.AddCredential;

import javax.inject.Inject;
import org.forgerock.openam.auth.node.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @author Sacumen (www.sacumen.com)
 * @category Node
 * @Descrition "VIP Add Credential" node with true and false outcome, If true, go
 *             to "VIP Authenticate Push Credentials" else false, go to "VIP Display Creds".
 *
 */
@Node.Metadata(outcomeProvider = AbstractDecisionNode.OutcomeProvider.class, configClass = VIPAddCredential.Config.class)
public class VIPAddCredential extends AbstractDecisionNode {

	static Logger logger = LoggerFactory.getLogger(VIPAddCredential.class);

	private AddCredential addCred;

	/**
	 * Configuration for the node.
	 */
	public interface Config {

	}

	/**
	 * Create the node.
	 */
	@Inject
	public VIPAddCredential() {
		addCred = new AddCredential();
	}

	/**
	 * Main logic of the node
	 */
	@Override
	public Action process(TreeContext context) throws NodeProcessException {
		String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
		String credValue = context.sharedState.get(CRED_ID).asString();
		String key_store = context.sharedState.get(KEY_STORE_PATH).asString();
		String key_store_pass = context.sharedState.get(KEY_STORE_PASS).asString();
		boolean isCredAdded = addCred.addCredential(userName, credValue,STANDARD_OTP,key_store,key_store_pass);
		logger.debug("isCredAdded: "+isCredAdded);
		if(isCredAdded) {
			logger.info("Crdentials is added successfully");
			return goTo(isCredAdded).build();
		}
		else {
			logger.info("Entered Credential ID is Invalid");
			context.sharedState.put(CREDENTIAL_ID_ERROR, "Entered Credential ID is Invalid,Please enter valid Credential ID");
			return goTo(false).build();
		}
		
	}

}
