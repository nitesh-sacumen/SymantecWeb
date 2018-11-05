package com.symantec.tree.nodes;

import javax.inject.Inject;

import org.forgerock.openam.auth.node.api.AbstractDecisionNode;
import org.forgerock.openam.auth.node.api.Action;
import org.forgerock.openam.auth.node.api.Node;
import org.forgerock.openam.auth.node.api.NodeProcessException;
import org.forgerock.openam.auth.node.api.SharedStateConstants;
import org.forgerock.openam.auth.node.api.TreeContext;
import org.forgerock.openam.core.CoreWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.assistedinject.Assisted;
import com.symantec.tree.request.util.AddCredential;
import com.symantec.tree.request.util.SmsDeviceRegister;
import com.symantec.tree.request.util.VoiceDeviceRegister;

import static com.symantec.tree.config.Constants.CREDCHOICE;
import static com.symantec.tree.config.Constants.CREDID;
import static com.symantec.tree.config.Constants.MOBNUM;
import static com.symantec.tree.config.Constants.SECURECODE;
import static com.symantec.tree.config.Constants.SMS;
import static com.symantec.tree.config.Constants.SMS_OTP;
import static com.symantec.tree.config.Constants.VIP;
import static com.symantec.tree.config.Constants.VOICE;
import static com.symantec.tree.config.Constants.VOICE_OTP;
import static com.symantec.tree.config.Constants.STANDARD_OTP;

/**
 * 
 * @author Symantec
 * @category Node
 * @Descrition "VIP AddCred with VerifyCode" node with TRUE,FALSE outcome. If TRUE, it will go to "VIP Add More Creds". If False, go to
 *             "VIP Enter SecurityCode/OTP".
 *
 */
@Node.Metadata(outcomeProvider = AbstractDecisionNode.OutcomeProvider.class, configClass = VIPVerifyCodeAddCred.Config.class)
public class VIPVerifyCodeAddCred extends AbstractDecisionNode {

	static Logger logger = LoggerFactory.getLogger(VIPVerifyCodeAddCred.class);

	private final Config config;
	private final CoreWrapper coreWrapper;
	private AddCredential addCred;
	private SmsDeviceRegister smsReg;
	private VoiceDeviceRegister voiceReg;

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
	public VIPVerifyCodeAddCred(@Assisted Config config, CoreWrapper coreWrapper) throws NodeProcessException {
		this.config = config;
		this.coreWrapper = coreWrapper;
		addCred = new AddCredential();
		smsReg = new SmsDeviceRegister();
		voiceReg = new VoiceDeviceRegister();
	}

	/**
	 * Main logic of the node.
	 */
	@Override
	public Action process(TreeContext context) throws NodeProcessException {
		String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
		String credValue = context.sharedState.get(CREDID).asString();
		String credPhoneNumber = context.sharedState.get(MOBNUM).asString();
		String otpRecieved = context.sharedState.get(SECURECODE).asString();
		logger.debug("secure code" + otpRecieved);
		String credIdType = "";
		if (context.sharedState.get(CREDCHOICE).asString().equalsIgnoreCase(SMS)) {
			credIdType = SMS_OTP;
			boolean isCredAdded = addCred.addCredential(userName, credPhoneNumber, credIdType, otpRecieved);
			return goTo(isCredAdded).build();
		} else if (context.sharedState.get(CREDCHOICE).asString().equalsIgnoreCase(VOICE)) {
			credIdType = VOICE_OTP;
			boolean isCredAdded = addCred.addCredential(userName, credPhoneNumber, credIdType, otpRecieved);
			return goTo(isCredAdded).build();

		} else if (context.sharedState.get(CREDCHOICE).asString().equalsIgnoreCase(VIP)) {
			credIdType = STANDARD_OTP;
			boolean isCredAdded = addCred.addCredential(userName, credValue, credIdType, otpRecieved);
			return goTo(isCredAdded).build();
		}
		return goTo(false).build();
	}

}
