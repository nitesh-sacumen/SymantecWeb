package com.symantec.tree.nodes;

import static com.symantec.tree.config.Constants.SECURE_CODE;
import static com.symantec.tree.config.Constants.SECURE_CODE_ERROR;

import com.symantec.tree.request.util.CheckVIPOtp;
import java.util.List;
import java.util.ResourceBundle;
import javax.inject.Inject;
import org.forgerock.guava.common.collect.ImmutableList;
import org.forgerock.json.JsonValue;
import org.forgerock.openam.auth.node.api.*;
import org.forgerock.openam.auth.node.api.Action.ActionBuilder;
import org.forgerock.util.i18n.PreferredLocales;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Symantec
 * @category Node
 * @Descrition "VIP SDK Check Symantec OTP" node with TRUE,FALSE and ERROR outcome.
 *
 */
@Node.Metadata(outcomeProvider = VIPSDKOTPCheck.SymantecOutcomeProvider.class, configClass = VIPSDKOTPCheck.Config.class)
public class VIPSDKOTPCheck implements Node {

	private static final String BUNDLE = "com/symantec/tree/nodes/VIPSDKOTPCheck";
	private final Logger logger = LoggerFactory.getLogger(VIPSDKOTPCheck.class);

	private CheckVIPOtp checkOtp;

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
	public VIPSDKOTPCheck() {
		checkOtp = new CheckVIPOtp();
	}

	/**
	 * Main logic of the node.
	 */
	@Override
	public Action process(TreeContext context) {

		String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
		String otpValue = context.sharedState.get(SECURE_CODE).asString();
		boolean isDeviceAdded = checkOtp.checkOtp(userName, otpValue);
		logger.debug("Check OTP is" + isDeviceAdded);
		if (isDeviceAdded) {
			return goTo(Symantec.TRUE).build();
		} else {

			context.sharedState.put(SECURE_CODE_ERROR, "Entered OTP is Invalid");
			return goTo(Symantec.FALSE).build();
		}

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
		 * The user has not been answered.
		 */
		ERROR

	}

	/**
	 * Defines the possible outcomes from this SymantecOutcomeProvider node.
	 */
	public static class SymantecOutcomeProvider implements OutcomeProvider {
		@Override
		public List<Outcome> getOutcomes(PreferredLocales locales, JsonValue nodeAttributes) {
			ResourceBundle bundle = locales.getBundleInPreferredLocale(VIPSDKOTPCheck.BUNDLE,
					SymantecOutcomeProvider.class.getClassLoader());
			return ImmutableList.of(new Outcome(Symantec.TRUE.name(), bundle.getString("trueOutcome")),
					new Outcome(Symantec.FALSE.name(), bundle.getString("falseOutcome")),
					new Outcome(Symantec.ERROR.name(), bundle.getString("errorOutcome")));
		}
	}

}
