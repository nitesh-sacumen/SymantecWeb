package com.symantec.tree.nodes;

import static com.symantec.tree.config.Constants.TXN_ID;

import com.google.inject.assistedinject.Assisted;
import com.symantec.tree.config.Constants;
import com.symantec.tree.request.util.AuthenticateUser;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import org.forgerock.openam.annotations.sm.Attribute;
import org.forgerock.openam.auth.node.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

	static final Logger logger = LoggerFactory.getLogger(VIPPushAuth.class);

	private AuthenticateUser pushAuthUser;
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
	public VIPPushAuth(@Assisted Config config) {

		logger.debug("Display Message Text:", config.displayMsgText());
		vipPushCodeMap.put(Constants.PUSH_DISPLAY_MESSAGE_TEXT, config.displayMsgText());

		logger.debug("Display Message Title", config.displayMsgTitle());
		vipPushCodeMap.put(Constants.PUSH_DISPLAY_MESSAGE_TITLE, config.displayMsgTitle());

		logger.debug("Display Message Profile", config.displayMsgProfile());
		vipPushCodeMap.put(Constants.PUSH_DISPLAY_MESSAGE_PROFILE, config.displayMsgProfile());

		pushAuthUser = new AuthenticateUser();
	}

	/**
	 * Main logic of the node
	 */
	@Override
	public Action process(TreeContext context) {
		String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
		String transactionId = pushAuthUser.authUser(userName, vipPushCodeMap.get(Constants.PUSH_DISPLAY_MESSAGE_TEXT),
				vipPushCodeMap.get(Constants.PUSH_DISPLAY_MESSAGE_TITLE),
				vipPushCodeMap.get(Constants.PUSH_DISPLAY_MESSAGE_PROFILE));
		logger.debug("TransactionId is " + transactionId);
		if (transactionId != null && !transactionId.isEmpty()) {
			context.sharedState.put(TXN_ID, transactionId);
			return goTo(true).build();
		} else {
			return goTo(false).build();
		}

	}
}