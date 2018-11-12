package com.symantec.tree.nodes;

import static com.symantec.tree.config.Constants.CRED_CHOICE;
import static org.forgerock.openam.auth.node.api.Action.send;

import com.google.inject.assistedinject.Assisted;
import com.sun.identity.sm.RequiredValueValidator;
import java.util.*;
import javax.inject.Inject;
import javax.security.auth.callback.ChoiceCallback;
import org.forgerock.guava.common.collect.ImmutableList;
import org.forgerock.json.JsonValue;
import org.forgerock.openam.annotations.sm.Attribute;
import org.forgerock.openam.auth.node.api.Action;
import org.forgerock.openam.auth.node.api.Action.ActionBuilder;
import org.forgerock.openam.auth.node.api.Node;
import org.forgerock.openam.auth.node.api.OutcomeProvider;
import org.forgerock.openam.auth.node.api.TreeContext;
import org.forgerock.util.i18n.PreferredLocales;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Symantec
 * @category Node
 * @Descrition "VIP Display Credential" node with VIP, SMS and VOICE outcome, If VIP, go
 *             to "VIP Enter CredentialID".If SMS and VOIC go to "VIP Enter Phone Number".
 *
 */
@Node.Metadata(outcomeProvider = VIPDisplayCredential.CredsOutcomeProvider.class, configClass =
		 VIPDisplayCredential.Config.class)
public class VIPDisplayCredential implements Node {

	private final Config config;
	private static final String BUNDLE = "com/symantec/tree/nodes/VIPDisplayCredential";
	private final Logger logger = LoggerFactory.getLogger(VIPDisplayCredential.class);

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
	public VIPDisplayCredential(@Assisted Config config) {
		this.config = config;
	}

	/**
	 * Main logic of the node.
	 */
	@Override
	public Action process(TreeContext context) {

		JsonValue sharedState = context.sharedState;

		return context.getCallback(ChoiceCallback.class).map(c -> c.getSelectedIndexes()[0]).map(Integer::new)
				.filter(choice -> -1 < choice && choice < 3).map(choice -> {
					sharedState.put(CRED_CHOICE, config.referrerCredList().get(choice));
					switch (choice) {

					case 0:

						return goTo(SymantecDisplayCredsOutcome.VIP).replaceSharedState(sharedState).build();
					case 2:

						return goTo(SymantecDisplayCredsOutcome.VOICE).replaceSharedState(sharedState).build();
					default:

						return goTo(SymantecDisplayCredsOutcome.SMS).replaceSharedState(sharedState).build();
					}

				}).orElseGet(() -> {
					logger.debug("collecting choice");
					return displayCreds(context);
				});
	}

	/**
	 * 
	 * @param context
	 * @return Action
	 * sending list of callbacks.
	 */
	private Action displayCreds(TreeContext context) {
		ResourceBundle bundle = context.request.locales.getBundleInPreferredLocale(BUNDLE, getClass().getClassLoader());
		Collection<String> values = config.referrerCredList().values();
		String[] targetArray = values.toArray(new String[0]);
		return send(new ChoiceCallback(bundle.getString("callback.creds"), targetArray, 0, false)).build();
	}

	private ActionBuilder goTo(SymantecDisplayCredsOutcome outcome) {
		return Action.goTo(outcome.name());
	}

	/**
	 * The possible outcomes for the SymantecVerifyAuth.
	 */
	public enum SymantecDisplayCredsOutcome {
		/**
		 * selection of VIP.
		 */
		VIP,
		/**
		 * selection for SMS.
		 */
		SMS,
		/**
		 * selection for VOICE.
		 */
		VOICE

	}

	/**
	 * Defines the possible outcomes from this SymantecOutcomeProvider node.
	 */
	public static class CredsOutcomeProvider implements OutcomeProvider {
		@Override
		public List<Outcome> getOutcomes(PreferredLocales locales, JsonValue nodeAttributes) {
			ResourceBundle bundle = locales.getBundleInPreferredLocale(VIPDisplayCredential.BUNDLE,
					CredsOutcomeProvider.class.getClassLoader());
			return ImmutableList.of(new Outcome(SymantecDisplayCredsOutcome.VIP.name(), bundle.getString("vipOutcome")),
					new Outcome(SymantecDisplayCredsOutcome.SMS.name(), bundle.getString("smsOutcome")),
					new Outcome(SymantecDisplayCredsOutcome.VOICE.name(), bundle.getString("voiceOutcome")));
		}
	}
}