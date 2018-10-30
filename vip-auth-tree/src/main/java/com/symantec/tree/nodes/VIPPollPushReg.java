package com.symantec.tree.nodes;

import com.google.inject.assistedinject.Assisted;
import com.ibm.wsdl.Constants;
import com.sun.identity.sm.RequiredValueValidator;
import com.symantec.tree.request.util.AuthPollPush;
import com.symantec.tree.request.util.DeleteCredential;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javax.inject.Inject;
import org.forgerock.guava.common.base.Strings;
import org.forgerock.guava.common.collect.ImmutableList;
import org.forgerock.json.JsonValue;
import org.forgerock.openam.annotations.sm.Attribute;
import org.forgerock.openam.auth.node.api.Action;
import org.forgerock.openam.auth.node.api.Action.ActionBuilder;
import org.forgerock.openam.auth.node.api.Node;
import org.forgerock.openam.auth.node.api.OutcomeProvider;
import org.forgerock.openam.auth.node.api.SharedStateConstants;
import org.forgerock.openam.auth.node.api.TreeContext;
import org.forgerock.openam.sm.annotations.adapters.Password;
import org.forgerock.openam.sm.validation.URLValidator;
import org.forgerock.util.i18n.PreferredLocales;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.symantec.tree.config.Constants.STANDARD_OTP;
import static com.symantec.tree.config.Constants.CREDCHOICE;
import static com.symantec.tree.config.Constants.CREDID;
import static com.symantec.tree.config.Constants.TXNID;

@Node.Metadata(outcomeProvider = VIPPollPushReg.SymantecOutcomeProvider.class, configClass = VIPPollPushReg.Config.class)
public class VIPPollPushReg implements Node {

	private static final String BUNDLE = "com/symantec/tree/nodes/VIPPollPushReg";

	private AuthPollPush pollPush;

	/**
	 * Configuration for the node.
	 */
	public interface Config {

		/**
		 * the ttlSeconds.
		 * 
		 * @return the ttlSeconds Reserved for future purpose
		 */

	}

	/**
	 * Create the node.
	 * 
	 * @param config The service config.
	 */
	@Inject
	public VIPPollPushReg(@Assisted Config config) {

		// verifyAuthClient = verifyAuthClientUtility.getAuthClient(uri);
		pollPush = new AuthPollPush();
	}

	public Action process(TreeContext context) {
		// logger.debug("Entered into ValidaePush porcess method");

		return verifyAuth(context);

	}

	private Action verifyAuth(TreeContext context) {
		// logger.debug("Entered into verifyAuth method");
		String credId = context.sharedState.get(CREDID).asString();
		String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
		String credType = STANDARD_OTP;
		JsonValue newSharedState = context.sharedState.copy();

		// JsonValue sharedState = context.sharedState;
		try {

			String result = pollPush.authPollPush(context.sharedState.get(TXNID).asString());

			if (result != null) {

				if (!Strings.isNullOrEmpty(result)) {

					switch (result) {
					case "7000":
						return goTo(Symantec.TRUE).replaceSharedState(newSharedState).build();

					case "7001":

						return goTo(Symantec.UNANSWERED).replaceSharedState(newSharedState).build();

					case "7002":
				        System.out.println("deleting credntial id");
						deleteCredential(userName, credId, credType);
						return goTo(Symantec.FALSE).replaceSharedState(newSharedState).build();

					case "7003":
						System.out.println("deleting credntial id");
						deleteCredential(userName, credId, credType);
						return goTo(Symantec.ERROR).replaceSharedState(newSharedState).build();

					case "7004":
						System.out.println("deleting credntial id");
						deleteCredential(userName, credId, credType);
						return goTo(Symantec.ERROR).replaceSharedState(newSharedState).build();

					case "7005":
						System.out.println("deleting credntial id");
						deleteCredential(userName, credId, credType);
						return goTo(Symantec.ERROR).replaceSharedState(newSharedState).build();

					case "7006":
						System.out.println("deleting credntial id");
						deleteCredential(userName, credId, credType);
						return goTo(Symantec.ERROR).replaceSharedState(newSharedState).build();

					case "7008":
						System.out.println("deleting credntial id");
						deleteCredential(userName, credId, credType);
						return goTo(Symantec.ERROR).replaceSharedState(newSharedState).build();

					default:
						return goTo(Symantec.UNANSWERED).replaceSharedState(newSharedState).build();

					}

				}
			}

		} catch (Exception e) {
			// logger.error(e.getMessage());
		}

		System.out.println("deleting credntial id");
		deleteCredential(userName, credId, credType);
		return goTo(Symantec.FALSE).replaceSharedState(newSharedState).build();

	}

	private ActionBuilder goTo(Symantec outcome) {
		return Action.goTo(outcome.name());
	}

	/**
	 * The possible outcomes for the SymantecVerifyAuth.
	 */
	public enum Symantec {
		/**
		 * Successful authentication.
		 */
		TRUE,
		/**
		 * Authentication failed.
		 */
		FALSE,
		/**
		 * Authentication Error.
		 */
		ERROR,
		/**
		 * The user has not been answered.
		 */
		UNANSWERED

	}

	/**
	 * Defines the possible outcomes from this SymantecOutcomeProvider node.
	 */
	public static class SymantecOutcomeProvider implements OutcomeProvider {
		@Override
		public List<Outcome> getOutcomes(PreferredLocales locales, JsonValue nodeAttributes) {
			ResourceBundle bundle = locales.getBundleInPreferredLocale(VIPPollPushReg.BUNDLE,
					SymantecOutcomeProvider.class.getClassLoader());
			return ImmutableList.of(new Outcome(Symantec.TRUE.name(), bundle.getString("trueOutcome")),
					new Outcome(Symantec.FALSE.name(), bundle.getString("falseOutcome")),
					new Outcome(Symantec.ERROR.name(), bundle.getString("errorOutcome")),
					new Outcome(Symantec.UNANSWERED.name(), bundle.getString("unansweredOutcome")));
		}
	}

	private void deleteCredential(String userName, String credId, String credType) {
		DeleteCredential delCred = new DeleteCredential();
		delCred.deleteCredential(userName, credId, credType);
	}

}
