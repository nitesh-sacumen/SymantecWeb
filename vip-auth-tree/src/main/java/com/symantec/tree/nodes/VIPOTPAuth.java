package com.symantec.tree.nodes;

import com.google.inject.assistedinject.Assisted;
import com.sun.identity.sm.RequiredValueValidator;
import com.symantec.tree.request.util.SmsDeviceRegister;
import com.symantec.tree.request.util.VoiceDeviceRegister;

import static org.forgerock.openam.auth.node.api.Action.send;
import org.forgerock.json.JsonValue;
import org.forgerock.openam.annotations.sm.Attribute;
import org.forgerock.openam.auth.node.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.forgerock.util.i18n.PreferredLocales;
import org.forgerock.guava.common.collect.ImmutableList;
import org.forgerock.openam.auth.node.api.Action.ActionBuilder;

import javax.inject.Inject;
import javax.security.auth.callback.ChoiceCallback;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.TextOutputCallback;
import javax.security.auth.callback.Callback;

import java.util.*;

import static com.symantec.tree.config.Constants.CRED_CHOICE;
import static com.symantec.tree.config.Constants.MOB_NUM;
import static com.symantec.tree.config.Constants.SECURE_CODE;
import static com.symantec.tree.config.Constants.SECURE_CODE_ERROR;

/**
 * 
 * @author Symantec
 * @category Node
 * @Descrition "VIP OTPAuth Creds" node with SMS, VOICE and TOKEN outcome.
 * If SMS and VOICE, it will go to "VIP Enter SecurityCode/OTP".
 * If TOKEN, go to "VIP Check Symantec OTP".
 *
 */
@Node.Metadata(outcomeProvider = VIPOTPAuth.OTPAuthOutcomeProvider.class, configClass = VIPOTPAuth.Config.class)
public class VIPOTPAuth implements Node {
	static Logger logger = LoggerFactory.getLogger(VIPOTPAuth.class);

	private final Config config;
	private static final String BUNDLE = "com/symantec/tree/nodes/VIPOTPAuth";

	/**
	 * Configuration for the node.
	 */
	public interface Config {
		@Attribute(order = 100, validators = { RequiredValueValidator.class })
		default Map<Integer, String> referrerCredList() {
			return Collections.emptyMap();
		}

	}

	/**
	 * Create the node.
	 * 
	 * @param config The service config.
	 */
	@Inject
	public VIPOTPAuth(@Assisted Config config) {
		this.config = config;
	}

	/**
	 * Main logic of the node.
	 */
	@Override
	public Action process(TreeContext context) {
		JsonValue sharedState = context.sharedState;
		String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
		String credValue = context.sharedState.get(MOB_NUM).asString();

		Optional<NameCallback> nameCallback = context.getCallback(NameCallback.class);

		if (nameCallback != null && nameCallback.isPresent()) {
			String textToken = context.getCallback(NameCallback.class).get().getName();
			if (textToken != null && !textToken.isEmpty()) {
				logger.info("SecureCode has been collected and placed into the Shared State");
				return goTo(SymantecOTPAuthOutcome.TOKEN)
						.replaceSharedState(context.sharedState.copy().put(SECURE_CODE, textToken)).build();
			}
		}

		return context.getCallback(ChoiceCallback.class).map(c -> c.getSelectedIndexes()[0]).map(Integer::new)
				.filter(choice -> -1 < choice && choice < 2).map(choice -> {
					sharedState.put(CRED_CHOICE, config.referrerCredList().get(choice));
					switch (choice) {

					case 1:
						boolean isOTPVoiceAuthenticated = new VoiceDeviceRegister().voiceDeviceRegister(userName,
								credValue);
						logger.debug("Voice Call sent .. " + isOTPVoiceAuthenticated);
						return goTo(SymantecOTPAuthOutcome.VOICE).replaceSharedState(sharedState).build();
					case 0:
						boolean isOTPSmsAuthenticated = new SmsDeviceRegister().smsDeviceRegister(userName, credValue);
						logger.debug("OTP sent  " + isOTPSmsAuthenticated);
						return goTo(SymantecOTPAuthOutcome.SMS).replaceSharedState(sharedState).build();
					}
					return goTo(SymantecOTPAuthOutcome.TOKEN).replaceSharedState(sharedState).build();

				}).orElseGet(() -> {
					logger.debug("collecting choice");
					return displayCredentials(context);
				});
	}

	/**
	 * 
	 * @param context
	 * @return list of callbacks.
	 */
	private Action displayCredentials(TreeContext context) {
		List<Callback> cbList = new ArrayList<>(2);
		Collection<String> values = config.referrerCredList().values();
		values.remove("Token");
		String[] targetArray = values.toArray(new String[0]);
		String outputError = context.sharedState.get(SECURE_CODE_ERROR).asString();
		logger.debug("text block error" + outputError);
		if (outputError == null) {

			ResourceBundle bundle = context.request.locales.getBundleInPreferredLocale(BUNDLE,
					getClass().getClassLoader());
			ChoiceCallback ccb = new ChoiceCallback(bundle.getString("callback.creds"), targetArray, 0, false);
			NameCallback ncb = new NameCallback("Enter OTP");
			cbList.add(ccb);
			cbList.add(ncb);
		} else {
			TextOutputCallback tcb = new TextOutputCallback(0, outputError);
			ResourceBundle bundle = context.request.locales.getBundleInPreferredLocale(BUNDLE,
					getClass().getClassLoader());
			ChoiceCallback ccb = new ChoiceCallback(bundle.getString("callback.creds"), targetArray, 0, false);
			NameCallback ncb = new NameCallback("Enter OTP");

			cbList.add(tcb);
			cbList.add(ccb);
			cbList.add(ncb);
		}

		return send(ImmutableList.copyOf(cbList)).build();

	}

	private ActionBuilder goTo(SymantecOTPAuthOutcome outcome) {
		return Action.goTo(outcome.name());
	}

	/**
	 * The possible outcomes for the SymantecVerifyAuth.
	 */
	public enum SymantecOTPAuthOutcome {
		/**
		 * selection for SMS.
		 */
		SMS,
		/**
		 * selection for VOICE.
		 */
		VOICE,
		/**
		 * selection for TOKEN.
		 */
		TOKEN

	}

	/**
	 * Defines the possible outcomes from this SymantecOutcomeProvider node.
	 */
	public static class OTPAuthOutcomeProvider implements OutcomeProvider {
		@Override
		public List<Outcome> getOutcomes(PreferredLocales locales, JsonValue nodeAttributes) {
			ResourceBundle bundle = locales.getBundleInPreferredLocale(VIPOTPAuth.BUNDLE,
					OTPAuthOutcomeProvider.class.getClassLoader());
			return ImmutableList.of(new Outcome(SymantecOTPAuthOutcome.SMS.name(), bundle.getString("smsOutcome")),
					new Outcome(SymantecOTPAuthOutcome.VOICE.name(), bundle.getString("voiceOutcome")),
					new Outcome(SymantecOTPAuthOutcome.TOKEN.name(), bundle.getString("tokenOutcome")));
		}
	}
}