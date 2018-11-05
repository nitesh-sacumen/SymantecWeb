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

import static com.symantec.tree.config.Constants.CREDID;
import static com.symantec.tree.config.Constants.MOBNUM;
import static com.symantec.tree.config.Constants.CREDCHOICE;
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
    	svRegister= new SMSVoiceRegister();

    }
    
    /**
     * 
     * @param context
     * @return name-callback
     */
	private Action collectOTP(TreeContext context) {
		ResourceBundle bundle = context.request.locales.getBundleInPreferredLocale(BUNDLE, getClass().getClassLoader());
		NameCallback nicb =new NameCallback(bundle.getString("callback.phoneNumber"),"Enter PhoneNumber");
		
		return send(nicb).build();
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
                	String credType= context.sharedState.get(CREDCHOICE).asString();
                	if(credType.equalsIgnoreCase(SMS) ) {
                	logger.info("calling sms register method");
                	svRegister.smsRegister(name);
                	return goToNext()
                	.replaceSharedState(sharedState.copy().put(MOBNUM, name)).build();

                	}else if(credType.equalsIgnoreCase(VOICE)){
                	logger.info("calling voice register method");
                	svRegister.voiceRegister(name);
                	return goToNext()
                	.replaceSharedState(sharedState.copy().put(MOBNUM, name)).build();

                	}else
                	return goToNext()
                	.replaceSharedState(sharedState.copy().put(CREDID, name)).build();
                	
                })
      
                .orElseGet(() -> {
                	logger.debug("Enter Credential ID");
                    return collectOTP(context);
                });
    }
}