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
 * @Descrition "VIP Check Symantec OTP" node with TRUE,FALSE and ERROR outcome.
 *             If TRUE, it will go to "Success". If False, go to "VIP OTPAuth
 *             Creds". If Error, go to "Failure".
 *
 */
@Node.Metadata(outcomeProvider = VIPOTPCheck.SymantecOutcomeProvider.class, configClass = VIPOTPCheck.Config.class)
public class VIPOTPCheck implements Node {

	private static final String BUNDLE = "com/symantec/tree/nodes/VIPOTPCheck";
	private final Logger logger = LoggerFactory.getLogger(VIPOTPCheck.class);

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
	public VIPOTPCheck() {
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
		logger.info("Check OTP is" + isDeviceAdded);
		if (isDeviceAdded) {
			return goTo(Symantec.TRUE).build();
		} else {

			context.sharedState.put(SECURE_CODE_ERROR, "Entered Security Code is Invalid");
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
			ResourceBundle bundle = locales.getBundleInPreferredLocale(VIPOTPCheck.BUNDLE,
					SymantecOutcomeProvider.class.getClassLoader());
			return ImmutableList.of(new Outcome(Symantec.TRUE.name(), bundle.getString("trueOutcome")),
					new Outcome(Symantec.FALSE.name(), bundle.getString("falseOutcome")),
					new Outcome(Symantec.ERROR.name(), bundle.getString("errorOutcome")));
		}
	}

}
