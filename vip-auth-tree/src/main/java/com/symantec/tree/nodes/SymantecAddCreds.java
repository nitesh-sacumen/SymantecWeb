package com.symantec.tree.nodes;

import javax.inject.Inject;

import org.forgerock.openam.annotations.sm.Attribute;
import org.forgerock.openam.auth.node.api.AbstractDecisionNode;
import org.forgerock.openam.auth.node.api.Action;
import org.forgerock.openam.auth.node.api.Node;
import org.forgerock.openam.auth.node.api.NodeProcessException;
import org.forgerock.openam.auth.node.api.SharedStateConstants;
import org.forgerock.openam.auth.node.api.TreeContext;
import org.forgerock.openam.core.CoreWrapper;

import com.google.inject.assistedinject.Assisted;
import com.sun.identity.shared.debug.Debug;
import com.symantec.tree.nodes.SymantecRegisterUser.Config;
import com.symantec.tree.request.util.AddCredential;
import com.symantec.tree.request.util.VIPCreateUser;
import static com.symantec.tree.config.Constants.CREDCHOICE;
import static com.symantec.tree.config.Constants.CREDID;

@Node.Metadata(outcomeProvider  = AbstractDecisionNode.OutcomeProvider.class,
configClass      = SymantecAddCreds.Config.class)
public class SymantecAddCreds extends AbstractDecisionNode {
	
	
	  private final Config config;
	    private final CoreWrapper coreWrapper;
	    private final static String DEBUG_FILE = "SymantecRegisterUser";
	    protected Debug debug = Debug.getInstance(DEBUG_FILE);
	    
	    private AddCredential  addCred;

	    /**
	     * Configuration for the node.
	     */
	    public interface Config {
	        @Attribute(order = 100,requiredValue = true)
	        default String Credential() {
	            return "";
	        }
	    }
	    /**
	     * Create the node.
	     * @param config The service config.
	     * @throws NodeProcessException If the configuration was not valid.
	     */
	    @Inject
	    public SymantecAddCreds(@Assisted Config config, CoreWrapper coreWrapper) throws NodeProcessException {
	        this.config = config;
	        this.coreWrapper = coreWrapper;
	        addCred = new AddCredential();
	    }

	    @Override
	    public Action process(TreeContext context) throws NodeProcessException {
	    	String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
	    	//String credValue = context.sharedState.get(CREDCHOICE).asString();
	    	String credValue = context.sharedState.get(CREDID).asString();
	    	//String credValue = context.sharedState.get(config.Credential()).asString();
	    	boolean isCredAdded = addCred.addCredential(userName,credValue);        
	    	return goTo(isCredAdded).build();
	    }

}
