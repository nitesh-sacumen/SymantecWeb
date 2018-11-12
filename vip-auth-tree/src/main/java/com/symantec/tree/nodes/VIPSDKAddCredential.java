package com.symantec.tree.nodes;

import static com.symantec.tree.config.Constants.CRED_ID;

import com.symantec.tree.request.util.SdkAddCredential;
import javax.inject.Inject;
import org.forgerock.openam.auth.node.api.*;

@Node.Metadata(outcomeProvider = AbstractDecisionNode.OutcomeProvider.class, configClass = VIPSDKAddCredential.Config.class)
public class VIPSDKAddCredential extends AbstractDecisionNode {

	private SdkAddCredential addCred;

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
	public VIPSDKAddCredential() {
		addCred = new SdkAddCredential();
	}

	@Override
	public Action process(TreeContext context) {
		String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
		String credValue = context.sharedState.get(CRED_ID).asString();
		if (credValue != null) {
			boolean isCredAdded = addCred.addCredential(userName, credValue);
			return goTo(isCredAdded).build();
		}
		return goTo(false).build();
	}

}
