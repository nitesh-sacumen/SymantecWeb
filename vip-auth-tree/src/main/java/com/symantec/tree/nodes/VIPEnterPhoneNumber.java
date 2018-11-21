package com.symantec.tree.nodes;

import static org.forgerock.openam.auth.node.api.Action.send;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.security.auth.callback.NameCallback;
import org.forgerock.guava.common.base.Strings;
import org.forgerock.json.JsonValue;
import org.forgerock.openam.auth.node.api.Action;
import org.forgerock.openam.auth.node.api.Node;
import org.forgerock.openam.auth.node.api.NodeProcessException;
import org.forgerock.openam.auth.node.api.SingleOutcomeNode;
import org.forgerock.openam.auth.node.api.TreeContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.symantec.tree.request.util.SMSVoiceRegister;

import static com.symantec.tree.config.Constants.*;
/**
 * 
 * @author Sacumen(www.sacumen.com)
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
    public Action process(TreeContext context) throws NodeProcessException{
    	logger.info("Collect PhoneNumber started");
        JsonValue sharedState = context.sharedState;
        String key_store = context.sharedState.get(KEY_STORE_PATH).asString();
		String key_store_pass = context.sharedState.get(KEY_STORE_PASS).asString();
        return context.getCallback(NameCallback.class)
                .map(NameCallback::getName)
                .map(String::new)
                .filter(name -> !Strings.isNullOrEmpty(name))
                .map(name -> {
                	logger.info("CredID has been collected and placed  into the Shared State");
                	String credType= context.sharedState.get(CRED_CHOICE).asString();
                	if(credType.equalsIgnoreCase(SMS) ) {
                	logger.info("calling sms register method");
                	try {
						svRegister.smsRegister(name,key_store,key_store_pass);
					} catch (NodeProcessException e) {
						e.printStackTrace();
					}
                	return goToNext()
                	.replaceSharedState(sharedState.copy().put(MOB_NUM, name)).build();

                	}else if(credType.equalsIgnoreCase(VOICE)){
                	logger.info("calling voice register method");
                	try {
						svRegister.voiceRegister(name,key_store,key_store_pass);
					} catch (NodeProcessException e) {
						e.printStackTrace();
					}
                	return goToNext()
                	.replaceSharedState(sharedState.copy().put(MOB_NUM, name)).build();

                	}else
                	return goToNext()
                	.replaceSharedState(sharedState.copy().put(CRED_ID, name)).build();
                	
                })
                .orElseGet(() -> {
                	logger.info("Enter Credential ID");
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