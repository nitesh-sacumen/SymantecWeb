package com.symantec.tree.nodes;

import javax.inject.Inject;

import org.forgerock.openam.annotations.sm.Attribute;
import org.forgerock.openam.auth.node.api.AbstractDecisionNode;
import org.forgerock.openam.auth.node.api.Action;
import org.forgerock.openam.auth.node.api.Node;
import org.forgerock.openam.auth.node.api.NodeProcessException;
import org.forgerock.openam.auth.node.api.SharedStateConstants;
import org.forgerock.openam.auth.node.api.SingleOutcomeNode;
import org.forgerock.openam.auth.node.api.TreeContext;
import org.forgerock.openam.core.CoreWrapper;

import com.google.inject.assistedinject.Assisted;
import com.sun.identity.shared.debug.Debug;

import com.symantec.tree.request.util.CheckVIPOtp;
import com.symantec.tree.request.util.SmsDeviceRegister;
import static com.symantec.tree.config.Constants.SECURECODE;


@Node.Metadata(outcomeProvider  = AbstractDecisionNode.OutcomeProvider.class,
configClass= SymantecVIPOtpCheck.Config.class)
public class SymantecVIPOtpCheck extends AbstractDecisionNode {

	private final Config config;
    private final CoreWrapper coreWrapper;
    private final static String DEBUG_FILE = "SymantecRegisterUser";
    protected Debug debug = Debug.getInstance(DEBUG_FILE);
    
    private CheckVIPOtp  checkOtp;

    /**
     * Configuration for the node.
     */
    public interface Config {
        
    }
    /**
     * Create the node.
     * @param config The service config.
     * @throws NodeProcessException If the configuration was not valid.
     */
    @Inject
    public SymantecVIPOtpCheck(@Assisted Config config, CoreWrapper coreWrapper) throws NodeProcessException {
        this.config = config;
        this.coreWrapper = coreWrapper;
        checkOtp = new CheckVIPOtp();
    }

    @Override
    public Action process(TreeContext context) throws NodeProcessException {
    	String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
    	//String otpValue = context.sharedState.get(config.OTP()).asString();
    	String otpValue = context.sharedState.get(SECURECODE).asString();
    	boolean isDeviceAdded = checkOtp.checkOtp(userName, otpValue);  
    	System.out.println("Check OTP is"+ isDeviceAdded);
    	return goTo(isDeviceAdded).build();
    }


}
