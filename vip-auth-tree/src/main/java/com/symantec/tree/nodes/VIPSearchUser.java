package com.symantec.tree.nodes;

import static com.symantec.tree.config.Constants.*;

import com.symantec.tree.request.util.VIPGetUser;
import javax.inject.Inject;
import org.forgerock.openam.auth.node.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Symantec
 * @category Node
 * @Descrition "VIP Search User" node with TRUE,FALSE outcome. If TRUE, it will go to "VIP Push Auth User". If False, go to
 *             "VIP Register User".
 *
 */
@Node.Metadata(outcomeProvider = AbstractDecisionNode.OutcomeProvider.class, configClass = VIPSearchUser.Config.class)
public class VIPSearchUser extends AbstractDecisionNode {
	static Logger logger = LoggerFactory.getLogger(VIPSearchUser.class);

	private VIPGetUser vipSearchUser = null;

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
	public VIPSearchUser() {
			vipSearchUser = new VIPGetUser();
	}

	/**
	 * Main logic of the node.
	 */
	@Override
	public Action process(TreeContext context) {
		String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
		boolean isVIPProfileExisted = vipSearchUser.viewUserInfo(userName);
		String mobNum;

		try {
			if (isVIPProfileExisted) {
				mobNum = vipSearchUser.getMobInfo(userName);
				logger.debug("Phone Number " + mobNum);

				if (mobNum != null && mobNum.equalsIgnoreCase(NO_CRED_REGISTERED)) {
					logger.info("No Credential Registered");
					context.transientState.put(NO_CREDENTIALS_REGISTERED, true);
					return goTo(false).build();
				} else if (mobNum != null && mobNum.equalsIgnoreCase(VIP_CRED_REGISTERED)) {
					logger.info("VIP Credential Registered");
					return goTo(true).build();
				} else {
					context.sharedState.put(MOB_NUM, mobNum);
					return goTo(true).build();
				}
			}
		} catch (NullPointerException ne) {
			logger.error("Phone Number not available for user");
		}

		return goTo(isVIPProfileExisted).build();
	}

}