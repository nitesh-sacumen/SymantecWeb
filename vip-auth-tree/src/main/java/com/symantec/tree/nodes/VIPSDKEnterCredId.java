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

import static com.symantec.tree.config.Constants.CREDID;
import static com.symantec.tree.config.Constants.MOBNUM;
import static com.symantec.tree.config.Constants.SECURECODE;
import static com.symantec.tree.config.Constants.CREDCHOICE;
import static com.symantec.tree.config.Constants.SMS;
import static com.symantec.tree.config.Constants.VOICE;

/**
 * 
 * @author Symantec
 * @category Node
 * @Descrition "VIP SDK Enter CredentialID" node with single outcome.
 *
 */
@Node.Metadata(outcomeProvider = SingleOutcomeNode.OutcomeProvider.class, configClass = VIPSDKEnterCredId.Config.class)
public class VIPSDKEnterCredId extends SingleOutcomeNode {

	private static final String BUNDLE = "com/symantec/tree/nodes/VIPEnterCredId";
	private final Logger logger = LoggerFactory.getLogger(VIPSDKEnterCredId.class);

	/**
	 * Configuration for the node.
	 */
	public interface Config {
	}

	/**
	 * Create the node.
	 */
	@Inject
	public VIPSDKEnterCredId() {

	}

	/**
     * 
     * @param context
     * @return password callback
     */
	private Action collectCredentialId(TreeContext context) {
		ResourceBundle bundle = context.request.locales.getBundleInPreferredLocale(BUNDLE, getClass().getClassLoader());
		return send(new PasswordCallback(bundle.getString("callback.credId"), false)).build();
	}

	/**
	 * Main logic of the node
	 */
    @Override
    public Action process(TreeContext context) {
    	logger.info("Collecting Credential id");
        JsonValue sharedState = context.sharedState;
        
        return context.getCallback(PasswordCallback.class)
                .map(PasswordCallback::getPassword)
                .map(String::new)
                .filter(password -> !Strings.isNullOrEmpty(password))
                .map(password -> {
                    return goToNext()
                        .replaceSharedState(sharedState.copy().put(CREDID, password)).build();
                })
                .orElseGet(() -> {
                	logger.info("Enter Credential ID");
                    return collectCredentialId(context);
                });
    }
}