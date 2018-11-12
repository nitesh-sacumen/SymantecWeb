package com.symantec.tree.nodes;

import static org.forgerock.openam.auth.node.api.Action.send;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.security.auth.callback.NameCallback;
import org.forgerock.guava.common.base.Strings;
import org.forgerock.json.JsonValue;
import org.forgerock.openam.auth.node.api.Action;
import org.forgerock.openam.auth.node.api.Node;
import org.forgerock.openam.auth.node.api.SingleOutcomeNode;
import org.forgerock.openam.auth.node.api.TreeContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.symantec.tree.request.util.SMSVoiceRegister;

import static com.symantec.tree.config.Constants.CRED_ID;
import static com.symantec.tree.config.Constants.MOB_NUM;
import static com.symantec.tree.config.Constants.CRED_CHOICE;
import static com.symantec.tree.config.Constants.SMS;
import static com.symantec.tree.config.Constants.VOICE;
/**
 * 
 * @author Symantec
 * @category Node
 * @Descrition "VIP Enter Phone Number" node with single outcome. This node will redirect to "VIP Enter SecurityCode/OTP".
 *
 */
@Node.Metadata(outcomeProvider  = SingleOutcomeNode.OutcomeProvider.class,
               configClass      = VIPEnterPhoneNumber.Config.class)
public class VIPEnterPhoneNumber extends SingleOutcomeNode {

    private static final String BUNDLE = "com/symantec/tree/nodes/VIPEnterPhoneNumber";
    private final Logger logger = LoggerFactory.getLogger(VIPEnterPhoneNumber.class);
    private SMSVoiceRegister svRegister;
    /**
     * Configuration for the node.
     */
    public interface Config {}


    /**
     * Create the node.
     */
    @Inject
    public VIPEnterPhoneNumber() {
    	svRegister = new SMSVoiceRegister();
    }

	/**
	 * Main logic of the node.
	 */
    @Override
    public Action process(TreeContext context) {
    	logger.info("Collect PhoneNumber started");
        JsonValue sharedState = context.sharedState;
        
        return context.getCallback(NameCallback.class)
                .map(NameCallback::getName)
                .map(String::new)
                .filter(name -> !Strings.isNullOrEmpty(name))
                .map(name -> {
                	logger.info("CredID has been collected and placed  into the Shared State");
                	String credType= context.sharedState.get(CRED_CHOICE).asString();
                	//TODO Duplicate code found in VIPEnterCredentialID, move to common class
                	if(credType.equalsIgnoreCase(SMS) ) {
                	logger.info("calling sms register method");
                	svRegister.smsRegister(name);
                	return goToNext()
                	.replaceSharedState(sharedState.copy().put(MOB_NUM, name)).build();

                	}else if(credType.equalsIgnoreCase(VOICE)){
                	logger.info("calling voice register method");
                	svRegister.voiceRegister(name);
                	return goToNext()
                	.replaceSharedState(sharedState.copy().put(MOB_NUM, name)).build();

                	}else
                	return goToNext()
                	.replaceSharedState(sharedState.copy().put(CRED_ID, name)).build();
                	
                })
                .orElseGet(() -> {
                	logger.debug("Enter Credential ID");
                    return collectOTP(context);
                });
    }

	/**
	 *
	 * @param context
	 * @return name-callback
	 */
	private Action collectOTP(TreeContext context) {
		ResourceBundle bundle = context.request.locales.getBundleInPreferredLocale(BUNDLE, getClass().getClassLoader());
		NameCallback nameCallback = new NameCallback(bundle.getString("callback.phoneNumber"),"Enter PhoneNumber");
		return send(nameCallback).build();
	}
}