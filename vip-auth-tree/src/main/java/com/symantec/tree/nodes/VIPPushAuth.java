package com.symantec.tree.nodes;

import com.google.inject.assistedinject.Assisted;

import com.symantec.tree.request.util.AuthenticateUser;

import org.forgerock.openam.annotations.sm.Attribute;
import org.forgerock.openam.auth.node.api.*;
import org.forgerock.openam.core.CoreWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import java.util.HashMap;
import java.util.Map;

import com.symantec.tree.config.Constants;
import static com.symantec.tree.config.Constants.TXNID;

/**
 * 
 * @author Symantec
 * @category Node
 * @Descrition "VIP Push Auth User" node with TRUE,FALSE outcome. If TRUE, it will go to "VIP Poll Push Auth". If False, go to
 *             "VIP OTPAuth Creds".
 *
 */
@Node.Metadata(outcomeProvider = AbstractDecisionNode.OutcomeProvider.class, configClass = VIPPushAuth.Config.class)
public class VIPPushAuth extends AbstractDecisionNode {

	private final Config config;
	private final CoreWrapper coreWrapper;
	static final Logger logger = LoggerFactory.getLogger(VIPPushAuth.class);

	private AuthenticateUser pushAuthUser;
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
	public VIPPushAuth(@Assisted Config config, CoreWrapper coreWrapper) throws NodeProcessException {
		this.config = config;
		this.coreWrapper = coreWrapper;

		logger.debug("Display Message Text:", this.config.displayMsgText());
		vipPushCodeMap.put(Constants.PUSHDISPLAYMESSAGETEXT, this.config.displayMsgText());

		logger.debug("Display Message Title", this.config.displayMsgTitle());
		vipPushCodeMap.put(Constants.PUSHDISPLAYMESSAGETITLE, this.config.displayMsgTitle());

		logger.debug("Display Message Profile", this.config.displayMsgProfile());
		vipPushCodeMap.put(Constants.PUSHDISPLAYMESSAGEPROFILE, this.config.displayMsgProfile());

		pushAuthUser = new AuthenticateUser();
	}

	/**
	 * Main logic of the node
	 */
	@Override
	public Action process(TreeContext context) throws NodeProcessException {
		String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
		String transactionId = pushAuthUser.authUser(userName, vipPushCodeMap.get(Constants.PUSHDISPLAYMESSAGETEXT),
				vipPushCodeMap.get(Constants.PUSHDISPLAYMESSAGETITLE),
				vipPushCodeMap.get(Constants.PUSHDISPLAYMESSAGEPROFILE));
		logger.debug("transactionId is " + transactionId);
		if (transactionId != null && !transactionId.isEmpty()) {
			context.sharedState.put(TXNID, transactionId);
			return goTo(true).build();
		} else {
			return goTo(false).build();
		}

	}
}