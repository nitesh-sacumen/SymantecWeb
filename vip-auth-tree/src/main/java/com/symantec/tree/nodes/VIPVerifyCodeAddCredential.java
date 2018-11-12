package com.symantec.tree.nodes;

import static com.symantec.tree.config.Constants.*;

import com.symantec.tree.request.util.AddCredential;
import javax.inject.Inject;
import org.forgerock.openam.auth.node.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Symantec
 * @category Node
 * @Descrition "VIP AddCred with VerifyCode" node with TRUE,FALSE outcome. If TRUE, it will go to "VIP Add More Creds". If False, go to
 *             "VIP Enter SecurityCode/OTP".
 *
 */
@Node.Metadata(outcomeProvider = AbstractDecisionNode.OutcomeProvider.class, configClass = VIPVerifyCodeAddCredential.Config.class)
public class VIPVerifyCodeAddCredential extends AbstractDecisionNode {

	static Logger logger = LoggerFactory.getLogger(VIPVerifyCodeAddCredential.class);

	private AddCredential addCred;

	/**
	 * Configuration for the node.
	 */
	public interface Config {

	}

	/**
	 * Create the node.
	 *
	 */
	@Inject
	public VIPVerifyCodeAddCredential() {
		addCred = new AddCredential();
	}

	/**
	 * Main logic of the node.
	 */
	@Override
	public Action process(TreeContext context) {
		String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
		String credValue = context.sharedState.get(CRED_ID).asString();
		String credPhoneNumber = context.sharedState.get(MOB_NUM).asString();
		String otpReceived = context.sharedState.get(SECURE_CODE).asString();
		logger.debug("Secure code" + otpReceived);
		String credIdType;
		if (context.sharedState.get(CRED_CHOICE).asString().equalsIgnoreCase(SMS)) {
			credIdType = SMS_OTP;
			boolean isCredAdded = addCred.addCredential(userName, credPhoneNumber, credIdType, otpReceived);
			return goTo(isCredAdded).build();
		} else if (context.sharedState.get(CRED_CHOICE).asString().equalsIgnoreCase(VOICE)) {
			credIdType = VOICE_OTP;
			boolean isCredAdded = addCred.addCredential(userName, credPhoneNumber, credIdType, otpReceived);
			return goTo(isCredAdded).build();

		} else if (context.sharedState.get(CRED_CHOICE).asString().equalsIgnoreCase(VIP)) {
			credIdType = STANDARD_OTP;
			boolean isCredAdded = addCred.addCredential(userName, credValue, credIdType, otpReceived);
			return goTo(isCredAdded).build();
		}
		return goTo(false).build();
	}

}
