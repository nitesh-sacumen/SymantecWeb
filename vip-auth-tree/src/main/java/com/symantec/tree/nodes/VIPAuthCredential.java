package com.symantec.tree.nodes;

import com.google.inject.assistedinject.Assisted;
import com.symantec.tree.config.Constants;
import com.symantec.tree.config.Constants.VIPAuthStatusCode;
import com.symantec.tree.request.util.AuthenticateCredential;
import com.symantec.tree.request.util.DeleteCredential;

import org.forgerock.openam.annotations.sm.Attribute;
import org.forgerock.openam.auth.node.api.*;
import org.forgerock.openam.core.CoreWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import static com.symantec.tree.config.Constants.CREDID;
import static com.symantec.tree.config.Constants.STANDARD_OTP;
import static com.symantec.tree.config.Constants.TXNID;

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

	private final Config config;
	private final CoreWrapper coreWrapper;

	private AuthenticateCredential authPushCred;
	final Map<String, String> vipPushCodeMap = new HashMap<>();

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
	 * @throws NodeProcessException If the configuration was not valid.
	 */
	@Inject
	public VIPAuthCredential(@Assisted Config config, CoreWrapper coreWrapper) throws NodeProcessException {

		this.config = config;
		this.coreWrapper = coreWrapper;

		logger.debug("Display Message Text:", this.config.displayMsgText());
		vipPushCodeMap.put(Constants.PUSHDISPLAYMESSAGETEXT, this.config.displayMsgText());

		logger.debug("Display Message Title", this.config.displayMsgTitle());
		vipPushCodeMap.put(Constants.PUSHDISPLAYMESSAGETITLE, this.config.displayMsgTitle());

		logger.debug("Display Message Profile", this.config.displayMsgProfile());
		vipPushCodeMap.put(Constants.PUSHDISPLAYMESSAGEPROFILE, this.config.displayMsgProfile());

		authPushCred = new AuthenticateCredential();
	}

	/**
	 * Main logic of the node.
	 */
	@Override
	public Action process(TreeContext context) throws NodeProcessException {
		String credId = context.sharedState.get(CREDID).asString();
		String credType = STANDARD_OTP;
		String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
		logger.info("calling VIP Auth credential ");
		String Stat = authPushCred.authCredential(credId, vipPushCodeMap.get(Constants.PUSHDISPLAYMESSAGETEXT),
				vipPushCodeMap.get(Constants.PUSHDISPLAYMESSAGETITLE),
				vipPushCodeMap.get(Constants.PUSHDISPLAYMESSAGEPROFILE));
		String[] trastat = Stat.split(",");
		for (String s : trastat)
			logger.debug("Values:" + s);
		String status = trastat[0];
		String transactionId = trastat[1];
		logger.debug("status of SymantecAuthCred  .. " + status);
		logger.debug("TransactionID of SymantecAuthCred  .. " + transactionId);

		context.sharedState.put(TXNID, transactionId);
		if (status.equalsIgnoreCase(VIPAuthStatusCode.SUCCESS_CODE)) {
			logger.debug("Mobile Push is sent successfully:" + status);
			return goTo(true).build();
		} else {
			deleteCredential(userName, credId, credType);
			return goTo(false).build();
		}

	}

	/**
	 * 
	 * @param userName
	 * @param credId
	 * @param credType
	 * deleting credentials
	 */
	private void deleteCredential(String userName, String credId, String credType) {
		logger.info("deleting credentials");
		DeleteCredential delCred = new DeleteCredential();
		delCred.deleteCredential(userName, credId, credType);
	}
}