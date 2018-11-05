package com.symantec.tree.nodes;

import com.google.inject.assistedinject.Assisted;
import com.symantec.tree.config.Constants.VIPSDKStatusCode;
import com.symantec.tree.request.util.GenerateActivationCode;

import org.forgerock.openam.annotations.sm.Attribute;
import org.forgerock.openam.auth.node.api.*;
import org.forgerock.openam.core.CoreWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.symantec.tree.config.Constants.ACTIVATIONCODE;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * 
 * @author Symantec SDK
 * @category Node
 * @Descrition "VIP Activation Code" node with true and false outcome.
 *
 */
@Node.Metadata(outcomeProvider = AbstractDecisionNode.OutcomeProvider.class, configClass = VIPGenerateActivationCode.Config.class)
public class VIPGenerateActivationCode extends AbstractDecisionNode {
	private final Config config;
	private final CoreWrapper coreWrapper;

	private GenerateActivationCode generateActivationCode;
	final Map<String, String> vipPushCodeMap = new HashMap<>();
	private final Logger logger = LoggerFactory.getLogger(VIPGenerateActivationCode.class);

	/**
	 * Configuration for the node.
	 */
	public interface Config {

		@Attribute(order = 100, requiredValue = true)
		default String vipuserservice_url() {
			return "";
		}
	}

	/**
	 * 
	 * @param config
	 * @param coreWrapper
	 * @throws NodeProcessException
	 */
	@Inject
	public VIPGenerateActivationCode(@Assisted Config config, CoreWrapper coreWrapper) throws NodeProcessException {

		this.config = config;
		this.coreWrapper = coreWrapper;
		generateActivationCode = new GenerateActivationCode();
	}

	/**
	 * Main logic of the node.
	 */
	@Override
	public Action process(TreeContext context) throws NodeProcessException {
		String Stat = generateActivationCode.generateCode();
		String[] array = Stat.split(",");
		for (String s : array)
			logger.debug("Values:" + s);
		String status = array[0];
		String activationCode = array[1];
		logger.debug("status of get Activation_code api call  .. " + status);
		logger.debug("activationCode is .. " + activationCode);

		context.sharedState.put(ACTIVATIONCODE, activationCode);
		if (status.equalsIgnoreCase(VIPSDKStatusCode.SUCCESS_CODE)) {
			logger.debug("Activation code generated successfuly:" + status);
			return goTo(true).build();
		} else {
			return goTo(false).build();
		}

	}
}