package com.symantec.tree.nodes;

import javax.inject.Inject;

import org.forgerock.openam.auth.node.api.AbstractDecisionNode;
import org.forgerock.openam.auth.node.api.Action;
import org.forgerock.openam.auth.node.api.Node;
import org.forgerock.openam.auth.node.api.NodeProcessException;
import org.forgerock.openam.auth.node.api.SharedStateConstants;
import org.forgerock.openam.auth.node.api.TreeContext;
import org.forgerock.openam.core.CoreWrapper;
import com.google.inject.assistedinject.Assisted;
import com.sun.identity.shared.debug.Debug;
import com.symantec.tree.request.util.SdkAddCredential;
import static com.symantec.tree.config.Constants.CREDID;
import static com.symantec.tree.config.Constants.SHARED_SECRET;

@Node.Metadata(outcomeProvider = AbstractDecisionNode.OutcomeProvider.class, configClass = VIPSdkAddCreds.Config.class)
public class VIPSdkAddCreds extends AbstractDecisionNode {

	private final Config config;
	private final CoreWrapper coreWrapper;

	private SdkAddCredential addCred;

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
	public VIPSdkAddCreds(@Assisted Config config, CoreWrapper coreWrapper) throws NodeProcessException {
		this.config = config;
		this.coreWrapper = coreWrapper;
		addCred = new SdkAddCredential();
	}

	@Override
	public Action process(TreeContext context) throws NodeProcessException {
		String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
		String credValue = context.sharedState.get(CREDID).asString();
		if (credValue != null) {
			boolean isCredAdded = addCred.addCredential(userName, credValue);
			return goTo(isCredAdded).build();
		}
		return goTo(false).build();
	}

}
