package com.symantec.tree.nodes;

import com.google.inject.assistedinject.Assisted;
import com.symantec.tree.config.Constants;
import com.symantec.tree.config.Constants.VIPAuthStatusCode;
import com.symantec.tree.request.util.AuthenticateCredential;
import com.symantec.tree.request.util.DeleteCredential;

import org.forgerock.openam.annotations.sm.Attribute;
import org.forgerock.openam.auth.node.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import static com.symantec.tree.config.Constants.CRED_ID;
import static com.symantec.tree.config.Constants.TXN_ID;

/**
 * 
 * @author Symantec
 * @category Node
 * @Descrition "VIP Authenticate Push Credential" node with true and false outcome, If true, go
 *             to "VIP Poll Push Reg" else false, go to "VIP Enter SecurityCode/OTP".
 *
 */
@Node.Metadata(outcomeProvider = AbstractDecisionNode.OutcomeProvider.class, configClass = VIPAuthCredential.Config.class)
public class VIPAuthCredential extends AbstractDecisionNode {
	static Logger logger = LoggerFactory.getLogger(VIPAuthCredential.class);

    private AuthenticateCredential authPushCred;
	private final Map<String, String> vipPushCodeMap = new HashMap<>();

	/**
	 * Configuration for the node.
	 */
	public interface Config {

		@Attribute(order = 100, requiredValue = true)
		default String displayMsgText() {
			return "";
		}

		@Attribute(order = 200, requiredValue = true)
		default String displayMsgTitle() {
			return "";
		}

		@Attribute(order = 300, requiredValue = true)
		default String displayMsgProfile() {
			return "";
		}

	}

	/**
	 * Create the node.
	 * 
	 * @param config The service config.
     */
	@Inject
	public VIPAuthCredential(@Assisted Config config) {

        logger.debug("Display Message Text:", config.displayMsgText());
		vipPushCodeMap.put(Constants.PUSH_DISPLAY_MESSAGE_TEXT, config.displayMsgText());

		logger.debug("Display Message Title", config.displayMsgTitle());
		vipPushCodeMap.put(Constants.PUSH_DISPLAY_MESSAGE_TITLE, config.displayMsgTitle());

		logger.debug("Display Message Profile", config.displayMsgProfile());
		vipPushCodeMap.put(Constants.PUSH_DISPLAY_MESSAGE_PROFILE, config.displayMsgProfile());

		authPushCred = new AuthenticateCredential();
	}

	/**
	 * Main logic of the node.
	 */
	@Override
	public Action process(TreeContext context) {
		String credId = context.sharedState.get(CRED_ID).asString();
        String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
		logger.info("Calling VIP Auth credential");
		String Stat = authPushCred.authCredential(credId, vipPushCodeMap.get(Constants.PUSH_DISPLAY_MESSAGE_TEXT),
				vipPushCodeMap.get(Constants.PUSH_DISPLAY_MESSAGE_TITLE),
				vipPushCodeMap.get(Constants.PUSH_DISPLAY_MESSAGE_PROFILE));
		String[] trastat = Stat.split(",");
		for (String s : trastat)
			logger.debug("Values:" + s);
		String status = trastat[0];
		String transactionId = trastat[1];
		logger.debug("Status of SymantecAuthCred  .. " + status);
		logger.debug("TransactionID of SymantecAuthCred  .. " + transactionId);

		context.sharedState.put(TXN_ID, transactionId);
		if (status.equalsIgnoreCase(VIPAuthStatusCode.SUCCESS_CODE)) {
			logger.debug("Mobile Push is sent successfully:" + status);
			return goTo(true).build();
		} else {
			deleteCredential(userName, credId);
			return goTo(false).build();
		}

	}

	/**
	 *  @param userName
	 * @param credId
     */
	private void deleteCredential(String userName, String credId) {
		logger.info("Deleting credentials");
		DeleteCredential delCred = new DeleteCredential();
		delCred.deleteCredential(userName, credId, Constants.STANDARD_OTP);
	}
}