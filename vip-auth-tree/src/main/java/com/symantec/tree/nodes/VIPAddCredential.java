package com.symantec.tree.nodes;

import static com.symantec.tree.config.Constants.*;

import com.sun.identity.shared.debug.Debug;
import com.symantec.tree.request.util.AddCredential;
import javax.inject.Inject;
import org.forgerock.openam.auth.node.api.*;

@Node.Metadata(outcomeProvider  = AbstractDecisionNode.OutcomeProvider.class,
configClass      = VIPAddCredential.Config.class)
public class VIPAddCredential extends AbstractDecisionNode {

    private final static String DEBUG_FILE = "SymantecRegisterUser";
    protected Debug debug = Debug.getInstance(DEBUG_FILE);
	    
    private AddCredential  addCred;

    /**
	     * Configuration for the node.
	     */
    public interface Config {

    }
    /**
     * Create the node.
     */
    @Inject
    public VIPAddCredential() {
        addCred = new AddCredential();
    }

    @Override
    public Action process(TreeContext context) {
        String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
        String credValue = context.sharedState.get(CRED_ID).asString();

        //TODO Remove unused code
        /*String credIdType="";
        if(context.sharedState.get(CRED_CHOICE).asString().equalsIgnoreCase("SMS")) {
            credIdType="SMS_OTP";
            boolean isCredAdded = addCred.addCredential(userName,credValue,credIdType);
            boolean isOTPSmsAuthenticated=smsReg.smsDeviceRegister(userName,credValue);
             return goTo(isOTPSmsAuthenticated).build();
        }else if(context.sharedState.get(CRED_CHOICE).asString().equalsIgnoreCase("VOICE")) {
             credIdType="VOICE_OTP";
             boolean isCredAdded = addCred.addCredential(userName,credValue,credIdType);
             boolean isOTPVoiceAuthenticated=voiceReg.voiceDeviceRegister(userName,credValue);
             return goTo(isOTPVoiceAuthenticated).build();

        }*/
        String otpReceived=context.sharedState.get(SECURE_CODE).asString();
        System.out.println("secure code" + otpReceived);
        String credIdType;
        //TODO Remove unused code
    /*	if(context.sharedState.get(CRED_CHOICE).asString().equalsIgnoreCase("SMS")) {
        System.out.println("Inside add credential cred_type= sms_otp");
        credIdType="SMS_OTP";

        boolean isCredAdded = addCred.addCredential(userName,credValue,credIdType,otpRecieved);
        //boolean isOTPSmsAuthenticated=smsReg.smsDeviceRegister(userName,credValue);
        return goTo(isCredAdded).build();
        }else if(context.sharedState.get(CRED_CHOICE).asString().equalsIgnoreCase("VOICE")) {
        credIdType="VOICE_OTP";
        boolean isCredAdded = addCred.addCredential(userName,credValue,credIdType,otpRecieved);
        // boolean isOTPVoiceAuthenticated=voiceReg.voiceDeviceRegister(userName,credValue);
        return goTo(isCredAdded).build();

        }
        else*/
            if(context.sharedState.get(CRED_CHOICE).asString().equalsIgnoreCase("VIP")) {
             credIdType="STANDARD_OTP";
             boolean isCredAdded = addCred.addCredential(userName,credValue,credIdType);
             return goTo(isCredAdded).build();
        }	    	//String credValue = context.sharedState.get(CRED_CHOICE).asString();

        //String credValue = context.sharedState.get(config.Credential()).asString();


     return goTo(false).build();
    }

}
