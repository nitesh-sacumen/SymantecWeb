package com.symantec.tree.nodes;

import static com.symantec.tree.config.Constants.NO_CREDENTIALS_REGISTERED;

import com.symantec.tree.request.util.VIPCreateUser;
import javax.inject.Inject;
import org.forgerock.openam.auth.node.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Symantec
 * @category Node
 * @Descrition "VIP Register User" node with TRUE,FALSE outcome. If TRUE, it will go to "VIP Display Creds". If False, go to
 *             "Failure".
 *
 */
@Node.Metadata(outcomeProvider = AbstractDecisionNode.OutcomeProvider.class, configClass = VIPRegisterUser.Config.class)
public class VIPRegisterUser extends AbstractDecisionNode {

	public static final Logger logger = LoggerFactory.getLogger(VIPRegisterUser.class);

	private VIPCreateUser vIPCreateUser;

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
	public VIPRegisterUser() {
		vIPCreateUser = new VIPCreateUser();
	}

	/**
	 * Main logic of the node.
	 */
	@Override
	public Action process(TreeContext context) {
		String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
		String credRegistrationStatus = context.transientState.get(NO_CREDENTIALS_REGISTERED).toString();
		boolean isVIPProfileRegistered;

		logger.info("credRegistrationStatus:" + credRegistrationStatus);

		if (credRegistrationStatus != null && credRegistrationStatus.equalsIgnoreCase("true")) {
			logger.info("User already registered and hence not making user registration call");
			return goTo(true).build();
		} else {
			logger.info("User not registered and hence making user registration call");
			isVIPProfileRegistered = vIPCreateUser.createVIPUser(userName);
			return goTo(isVIPProfileRegistered).build();
		}
	}
}