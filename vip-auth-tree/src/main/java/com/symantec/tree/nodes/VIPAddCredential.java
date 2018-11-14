package com.symantec.tree.nodes;

import static com.symantec.tree.config.Constants.*;

import com.symantec.tree.request.util.AddCredential;

import javax.inject.Inject;
import org.forgerock.openam.auth.node.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

	@Override
	public Action process(TreeContext context) {
		String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
		String credValue = context.sharedState.get(CRED_ID).asString();
		String otpReceived = context.sharedState.get(SECURE_CODE).asString();
		logger.debug("secure code" + otpReceived);
		String credIdType;

		if (context.sharedState.get(CRED_CHOICE).asString().equalsIgnoreCase("VIP")) {
			credIdType = "STANDARD_OTP";
			boolean isCredAdded = addCred.addCredential(userName, credValue, credIdType);
			return goTo(isCredAdded).build();
		}

		return goTo(false).build();
	}

}
