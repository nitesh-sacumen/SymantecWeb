package com.symantec.tree.nodes;

import javax.inject.Inject;
import org.forgerock.guava.common.collect.ImmutableList;
import org.forgerock.json.JsonValue;
import org.forgerock.openam.auth.node.api.Action;
import org.forgerock.openam.auth.node.api.Node;
import org.forgerock.openam.auth.node.api.NodeProcessException;
import org.forgerock.openam.auth.node.api.OutcomeProvider;
import org.forgerock.openam.auth.node.api.SharedStateConstants;
import org.forgerock.openam.auth.node.api.TreeContext;
import org.forgerock.openam.auth.node.api.Action.ActionBuilder;
import org.forgerock.openam.core.CoreWrapper;
import org.forgerock.util.i18n.PreferredLocales;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.inject.assistedinject.Assisted;
import com.sun.identity.shared.debug.Debug;
import com.symantec.tree.request.util.CheckVIPOtp;
import static com.symantec.tree.config.Constants.SECURECODE;
import static com.symantec.tree.config.Constants.SECURECODEERROR;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * 
 * @author Symantec
 * @category Node
 * @Descrition "VIP Check Symantec OTP" node with TRUE,FALSE and ERROR outcome.
 *             If TRUE, it will go to "Success". If False, go to "VIP OTPAuth
 *             Creds". If Error, go to "Failure".
 *
 */
@Node.Metadata(outcomeProvider = VIPOtpCheck.SymantecOutcomeProvider.class, configClass = VIPOtpCheck.Config.class)
public class VIPOtpCheck implements Node {

	private final Config config;
	private final CoreWrapper coreWrapper;

	private static final String BUNDLE = "com/symantec/tree/nodes/VIPOtpCheck";
	private final Logger logger = LoggerFactory.getLogger(VIPOtpCheck.class);

	private CheckVIPOtp checkOtp;
	static int counter = 0;

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
	public VIPOtpCheck(@Assisted Config config, CoreWrapper coreWrapper) throws NodeProcessException {
		this.config = config;
		this.coreWrapper = coreWrapper;
		checkOtp = new CheckVIPOtp();
	}

	/**
	 * Main logic of the node.
	 */
	@Override
	public Action process(TreeContext context) throws NodeProcessException {
		JsonValue sharedState = context.sharedState.copy();

		String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
		String otpValue = context.sharedState.get(SECURECODE).asString();
		boolean isDeviceAdded = checkOtp.checkOtp(userName, otpValue);
		logger.info("Check OTP is" + isDeviceAdded);
		if (isDeviceAdded) {
			return goTo(Symantec.TRUE).build();
		} else {

			context.sharedState.put(SECURECODEERROR, "Entered Security Code is Invalid");
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
			ResourceBundle bundle = locales.getBundleInPreferredLocale(VIPOtpCheck.BUNDLE,
					SymantecOutcomeProvider.class.getClassLoader());
			return ImmutableList.of(new Outcome(Symantec.TRUE.name(), bundle.getString("trueOutcome")),
					new Outcome(Symantec.FALSE.name(), bundle.getString("falseOutcome")),
					new Outcome(Symantec.ERROR.name(), bundle.getString("errorOutcome")));
		}
	}

}
