package com.symantec.tree.nodes;

import javax.inject.Inject;
import javax.security.auth.callback.TextOutputCallback;

import org.forgerock.openam.annotations.sm.Attribute;
import org.forgerock.openam.auth.node.api.AbstractDecisionNode;
import org.forgerock.openam.auth.node.api.Action;
import org.forgerock.openam.auth.node.api.Node;
import org.forgerock.openam.auth.node.api.NodeProcessException;
import org.forgerock.openam.auth.node.api.SharedStateConstants;
import org.forgerock.openam.auth.node.api.SingleOutcomeNode;
import org.forgerock.openam.auth.node.api.TreeContext;
import org.forgerock.openam.core.CoreWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.assistedinject.Assisted;
import com.sun.identity.shared.debug.Debug;

import com.symantec.tree.request.util.CheckVIPOtp;
import com.symantec.tree.request.util.SmsDeviceRegister;
import static com.symantec.tree.config.Constants.SECURECODE;
import static org.forgerock.openam.auth.node.api.Action.send;

import java.util.ResourceBundle;


@Node.Metadata(outcomeProvider  = AbstractDecisionNode.OutcomeProvider.class,
configClass= SymantecVIPOtpCheck.Config.class)
public class SymantecVIPOtpCheck extends AbstractDecisionNode {

	private final Config config;
    private final CoreWrapper coreWrapper;
    private final static String DEBUG_FILE = "SymantecRegisterUser";
    protected Debug debug = Debug.getInstance(DEBUG_FILE);
    
    private static final String BUNDLE = "com/symantec/tree/nodes/SymantecVIPOtpCheck";
    private final Logger logger = LoggerFactory.getLogger("entersektAuth");
    
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
    	if(isDeviceAdded) {
    	return goTo(isDeviceAdded).build();
    	}
    	else{
    		System.out.println("Check OTP failed");
            return sendErrorMessage(context);

        }
    }


    private Action sendErrorMessage(TreeContext context) {
        ResourceBundle bundle = context.request.locales.getBundleInPreferredLocale(BUNDLE, getClass().getClassLoader());
        logger.debug("OTP verification failed !!!!");
        System.out.println("OTP verification failed");
        return send(new TextOutputCallback(TextOutputCallback.ERROR,bundle.getString("vipotp.error"))).build();
    }
    
}
