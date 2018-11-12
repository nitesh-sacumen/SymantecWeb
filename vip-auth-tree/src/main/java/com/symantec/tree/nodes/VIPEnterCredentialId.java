package com.symantec.tree.nodes;

import static org.forgerock.openam.auth.node.api.Action.send;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.security.auth.callback.PasswordCallback;

import org.forgerock.guava.common.base.Strings;
import org.forgerock.json.JsonValue;
import org.forgerock.openam.auth.node.api.Action;
import org.forgerock.openam.auth.node.api.Node;
import org.forgerock.openam.auth.node.api.SingleOutcomeNode;
import org.forgerock.openam.auth.node.api.TreeContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.symantec.tree.request.util.SMSVoiceRegister;

import static com.symantec.tree.config.Constants.CRED_ID;
import static com.symantec.tree.config.Constants.CRED_CHOICE;
import static com.symantec.tree.config.Constants.SMS;
import static com.symantec.tree.config.Constants.VOICE;

/**
 * 
 * @author Symantec
 * @category Node
 * @Descrition "VIP Enter CredentialID" node with single outcome. This node will redirect to "VIP Add Credential".
 *
 */
@Node.Metadata(outcomeProvider = SingleOutcomeNode.OutcomeProvider.class, configClass =
		 VIPEnterCredentialId.Config.class)
public class VIPEnterCredentialId extends SingleOutcomeNode {

	private static final String BUNDLE = "com/symantec/tree/nodes/VIPEnterCredentialId";
	private final Logger logger = LoggerFactory.getLogger(VIPEnterCredentialId.class);
	private SMSVoiceRegister svRegister;

	/**
	 * Configuration for the node.
	 */
	public interface Config {
	}

	/**
	 * Create the node.
	 */
	@Inject
	public VIPEnterCredentialId() {
		svRegister = new SMSVoiceRegister();

	}

	/**
	 * 
	 * @param context
	 * @return sending password call back.
	 */
	private Action collectOTP(TreeContext context) {
		ResourceBundle bundle = context.request.locales.getBundleInPreferredLocale(BUNDLE, getClass().getClassLoader());
		PasswordCallback pcb = new PasswordCallback(bundle.getString("callback.credId"), true);
		return send(pcb).build();
	}

	/**
	 * Main logic of the node
	 */
	@Override
	public Action process(TreeContext context) {
		logger.debug("Collect CredID started");
		JsonValue sharedState = context.sharedState;

		return context.getCallback(PasswordCallback.class).map(PasswordCallback::getPassword).map(String::new)
				.filter(password -> !Strings.isNullOrEmpty(password)).map(password -> {
					logger.debug("Credential ID has been collected and placed into the Shared State");
					String credType = context.sharedState.get(CRED_CHOICE).asString();
					//TODO Duplicated Code in VIPEnterPhoneNumber, remove out to common location
					if (credType.equalsIgnoreCase(SMS)) {
						logger.info("calling sms register method");
						svRegister.smsRegister(password);
						return goToNext().replaceSharedState(sharedState.copy().put(CRED_ID, password)).build();

					} else if (credType.equalsIgnoreCase(VOICE)) {
						logger.info("calling voice register method");
						svRegister.voiceRegister(password);
						return goToNext().replaceSharedState(sharedState.copy().put(CRED_ID, password)).build();

					} else
						return goToNext().replaceSharedState(sharedState.copy().put(CRED_ID, password)).build();
				}).orElseGet(() -> {
					logger.debug("Enter Credential ID");
					return collectOTP(context);
				});
	}
}