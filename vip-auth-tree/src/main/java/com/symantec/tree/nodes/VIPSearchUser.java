package com.symantec.tree.nodes;

import com.google.inject.assistedinject.Assisted;
import com.symantec.tree.request.util.VIPGetUser;
import org.forgerock.openam.auth.node.api.*;
import org.forgerock.openam.core.CoreWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import static com.symantec.tree.config.Constants.MOBNUM;
import static com.symantec.tree.config.Constants.NOCREDREGISTERED;
import static com.symantec.tree.config.Constants.VIPCREDREGISTERED;
import static com.symantec.tree.config.Constants.NO_CREDENTIALS_REGISTERED;

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
	private final Config config;
	private final CoreWrapper coreWrapper;

	private VIPGetUser vipSearchUser = null;

	/**
	 * Configuration for the node.
	 */
	public interface Config {

	}

	/**
	 * Create the node.
	 * 
	 * @param config The service config.
	 * @throws NodeProcessException If the configuration was not valid.
	 */
	@Inject
	public VIPSearchUser(@Assisted Config config, CoreWrapper coreWrapper) throws NodeProcessException {
		this.config = config;
		this.coreWrapper = coreWrapper;
		try {
			vipSearchUser = new VIPGetUser();
		} catch (Exception e) {
			logger.error("error when instansiating searchuser......." + e.getMessage());
		}
	}

	/**
	 * Main logic of the node.
	 */
	@Override
	public Action process(TreeContext context) throws NodeProcessException {
		String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
		boolean isVIPProfileExisted = vipSearchUser.viewUserInfo(userName);
		String mobNum = null;

		try {

			if (isVIPProfileExisted) {
				mobNum = vipSearchUser.getMobInfo(userName);
				logger.debug("Phone Number " + mobNum);

				if (mobNum != null && mobNum.equalsIgnoreCase(NOCREDREGISTERED)) {
					logger.info("NOCREDREGISTERED");
					context.transientState.put(NO_CREDENTIALS_REGISTERED, true);
					return goTo(false).build();
				} else if (mobNum != null && mobNum.equalsIgnoreCase(VIPCREDREGISTERED)) {
					logger.info("VIPCREDREGISTERED");
					return goTo(isVIPProfileExisted).build();
				} else {

					context.sharedState.put(MOBNUM, mobNum);
					return goTo(isVIPProfileExisted).build();
				}
			}

		} catch (NullPointerException ne) {
			logger.error("Phone Number not available for user");
		}

		return goTo(isVIPProfileExisted).build();
	}

}