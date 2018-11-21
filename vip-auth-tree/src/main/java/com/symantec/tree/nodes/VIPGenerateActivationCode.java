package com.symantec.tree.nodes;

import com.symantec.tree.config.Constants.VIPSDKStatusCode;
import com.symantec.tree.request.util.GenerateActivationCode;

import org.forgerock.openam.annotations.sm.Attribute;
import org.forgerock.openam.auth.node.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.symantec.tree.config.Constants.*;
import javax.inject.Inject;

/**
 * 
 * @author Sacumen (www.sacumen.com)
 * @category Node
 * @Descrition "VIP Activation Code" node with true and false outcome.
 *
 */
@Node.Metadata(outcomeProvider = AbstractDecisionNode.OutcomeProvider.class, configClass = VIPGenerateActivationCode.Config.class)
public class VIPGenerateActivationCode extends AbstractDecisionNode {

	private GenerateActivationCode generateActivationCode;
	private final Logger logger = LoggerFactory.getLogger(VIPGenerateActivationCode.class);

	/**
	 * Configuration for the node.
	 */
	public interface Config {
		@Attribute(order = 100, requiredValue = true)
		default String vipUserServiceUrl() {
			return "";
		}
	}

	/**
	 *
	 */
	@Inject
	public VIPGenerateActivationCode() {
		generateActivationCode = new GenerateActivationCode();
	}

	/**
	 * Main logic of the node.
	 * @throws NodeProcessException 
	 */
	@Override
	public Action process(TreeContext context) throws NodeProcessException {
		String key_store = context.sharedState.get(KEY_STORE_PATH).asString();
		String key_store_pass = context.sharedState.get(KEY_STORE_PASS).asString();
		String Stat = generateActivationCode.generateCode(key_store,key_store_pass);
		String[] array = Stat.split(",");
		for (String s : array)
			logger.debug("Values:" + s);
		String status = array[0];
		String activationCode = array[1];
		logger.debug("Status of get Activation_code API call: " + status);
		logger.debug("Activation code is: " + activationCode);

		context.sharedState.put(ACTIVATION_CODE, activationCode);
		if (status.equalsIgnoreCase(VIPSDKStatusCode.SUCCESS_CODE)) {
			logger.debug("Activation code generated successfully:" + status);
			return goTo(true).build();
		} else {
			return goTo(false).build();
		}

	}
}