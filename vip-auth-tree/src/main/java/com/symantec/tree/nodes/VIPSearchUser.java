package com.symantec.tree.nodes;

import static com.symantec.tree.config.Constants.*;

import com.google.inject.assistedinject.Assisted;
import com.symantec.tree.nodes.VIPPushAuth.Config;
import com.symantec.tree.request.util.VIPGetUser;
import javax.inject.Inject;

import org.forgerock.openam.annotations.sm.Attribute;
import org.forgerock.openam.auth.node.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Sacumen(www.sacumen.com)
 * @category Node
 * @Descrition "VIP Search User" node with TRUE,FALSE outcome. If TRUE, it will go to "VIP Push Auth User". If False, go to
 *             "VIP Register User".
 *
 */
@Node.Metadata(outcomeProvider = AbstractDecisionNode.OutcomeProvider.class, configClass = VIPSearchUser.Config.class)
public class VIPSearchUser extends AbstractDecisionNode {
	static Logger logger = LoggerFactory.getLogger(VIPSearchUser.class);

	/**
	 * Configuration for the node.
	 */
	 public interface Config {
		@Attribute(order = 100, requiredValue = true)
		String Key_Store_Path();


		@Attribute(order = 200, requiredValue = true)
		String Key_Store_Password();
		
		@Attribute(order = 300, requiredValue = true)
		String Authentication_Service_URL();
		
		@Attribute(order = 400, requiredValue = true)
		String Query_Service_URL();
		
		@Attribute(order = 500, requiredValue = true)
		String Management_Service_URL();
	}
	 
	private VIPGetUser vipSearchUser;
	private final Config config;

	/**
	 * Create the node.
	 *
	 */
	@Inject
	public VIPSearchUser(@Assisted Config config,VIPGetUser vipSearchUser) {
		this.config = config;
		this.vipSearchUser = vipSearchUser;
	}

	/**
	 * Main logic of the node.
	 * @throws NodeProcessException 
	 */
	@Override
	public Action process(TreeContext context) throws NodeProcessException {
		String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
		context.sharedState.put(KEY_STORE_PATH,config.Key_Store_Path());
		context.sharedState.put(KEY_STORE_PASS,config.Key_Store_Password());
		context.sharedState.put(AUTHENTICATION_SERVICE_URL,config.Authentication_Service_URL());
		context.sharedState.put(QUERY_SERVICE_URL,config.Query_Service_URL());
		context.sharedState.put(MANAGEMENT_SERVICE_URL,config.Management_Service_URL());
		boolean isVIPProfileExisted = vipSearchUser.viewUserInfo(userName,config.Key_Store_Path(),config.Key_Store_Password(),context);

		
		String mobNum;

		try {
			if (isVIPProfileExisted) {
				mobNum = vipSearchUser.getMobInfo(userName,config.Key_Store_Path(),config.Key_Store_Password());
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