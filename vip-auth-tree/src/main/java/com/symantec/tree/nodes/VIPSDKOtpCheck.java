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
 * @Descrition "VIP SDK Check Symantec OTP" node with TRUE,FALSE and ERROR outcome.
 *
 */
@Node.Metadata(outcomeProvider = VIPSDKOtpCheck.SymantecOutcomeProvider.class, configClass = VIPSDKOtpCheck.Config.class)
public class VIPSDKOtpCheck implements Node {

	private final Config config;
	private final CoreWrapper coreWrapper;

	private static final String BUNDLE = "com/symantec/tree/nodes/VIPSDKOtpCheck";
	private final Logger logger = LoggerFactory.getLogger(VIPSDKOtpCheck.class);

	private CheckVIPOtp checkOtp;

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
	public VIPSDKOtpCheck(@Assisted Config config, CoreWrapper coreWrapper) throws NodeProcessException {
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
		logger.debug("Check OTP is" + isDeviceAdded);
		if (isDeviceAdded) {
			return goTo(Symantec.TRUE).build();
		} else {

			context.sharedState.put(SECURECODEERROR, "Entered OTP is Invalid");
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
			ResourceBundle bundle = locales.getBundleInPreferredLocale(VIPSDKOtpCheck.BUNDLE,
					SymantecOutcomeProvider.class.getClassLoader());
			return ImmutableList.of(new Outcome(Symantec.TRUE.name(), bundle.getString("trueOutcome")),
					new Outcome(Symantec.FALSE.name(), bundle.getString("falseOutcome")),
					new Outcome(Symantec.ERROR.name(), bundle.getString("errorOutcome")));
		}
	}

}
