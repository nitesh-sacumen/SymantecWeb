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
import com.symantec.tree.nodes.SymantecAddCreds.Config;
import com.symantec.tree.request.util.AddCredential;
import com.symantec.tree.request.util.SmsDeviceRegister;

@Node.Metadata(outcomeProvider  = AbstractDecisionNode.OutcomeProvider.class,
configClass      = SymantecSmsDeviceRegister.Config.class)
public class SymantecSmsDeviceRegister extends AbstractDecisionNode {
	
	private final Config config;
    private final CoreWrapper coreWrapper;
    private final static String DEBUG_FILE = "SymantecRegisterUser";
    protected Debug debug = Debug.getInstance(DEBUG_FILE);
    
    private SmsDeviceRegister  smsRegister;

    /**
     * Configuration for the node.
     */
    public interface Config {
        @Attribute(order = 100,requiredValue = true)
        default String MobileNumber() {
            return "";
        }
    }
    /**
     * Create the node.
     * @param config The service config.
     * @throws NodeProcessException If the configuration was not valid.
     */
    @Inject
    public SymantecSmsDeviceRegister(@Assisted Config config, CoreWrapper coreWrapper) throws NodeProcessException {
        this.config = config;
        this.coreWrapper = coreWrapper;
        smsRegister = new SmsDeviceRegister();
    }

    @Override
    public Action process(TreeContext context) throws NodeProcessException {
    	String mobNum = context.sharedState.get(config.MobileNumber()).asString();
    	boolean isDeviceAdded = smsRegister.smsDeviceRegister(mobNum);        
    	return goTo(isDeviceAdded).build();
    }


}
