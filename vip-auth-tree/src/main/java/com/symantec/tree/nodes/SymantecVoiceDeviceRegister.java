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
import com.symantec.tree.nodes.SymantecSmsDeviceRegister.Config;
import com.symantec.tree.request.util.SmsDeviceRegister;
import com.symantec.tree.request.util.VoiceDeviceRegister;

@Node.Metadata(outcomeProvider  = AbstractDecisionNode.OutcomeProvider.class,
configClass      = SymantecVoiceDeviceRegister.Config.class)
public class SymantecVoiceDeviceRegister extends AbstractDecisionNode {

	private final Config config;
    private final CoreWrapper coreWrapper;
    private final static String DEBUG_FILE = "SymantecRegisterUser";
    protected Debug debug = Debug.getInstance(DEBUG_FILE);
    
    private VoiceDeviceRegister  voiceRegister;

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
    public SymantecVoiceDeviceRegister(@Assisted Config config, CoreWrapper coreWrapper) throws NodeProcessException {
        this.config = config;
        this.coreWrapper = coreWrapper;
        voiceRegister = new VoiceDeviceRegister();
    }

    @Override
    public Action process(TreeContext context) throws NodeProcessException {
    	String mobNum = context.sharedState.get(config.MobileNumber()).asString();
    	boolean isDeviceAdded = voiceRegister.voiceDeviceRegister(mobNum);        
    	return goTo(isDeviceAdded).build();
    }


}
