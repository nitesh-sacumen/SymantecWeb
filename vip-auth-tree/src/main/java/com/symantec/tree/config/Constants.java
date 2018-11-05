package com.symantec.tree.config;

public final class Constants {

    /**
     * Private constructor.
     */
    private Constants() {
    }
    
    public static final  String CREDCHOICE="SelectedValue";
    public static final  String CREDID="CredentialID";
    public static final  String SECURECODE="SecurityCode";
    public static final  String TXNID="TransactionID";
    public static final  String MOBNUM="Mobile Number";
    public static final  String CONFIRMCREDCHOICE=" Cred Choice";
    public static final  String SECURECODEERROR=" Display Error";
    public static final  String FINALCODEERROR=" Display Error";
    

    public static final String PUSHDISPLAYMESSAGETEXT = "push_display_message_text";
    public static final String PUSHDISPLAYMESSAGETITLE = "push_display_message_title";
    public static final String PUSHDISPLAYMESSAGEPROFILE = "push_display_message_profile";
    
    public static final String STANDARD_OTP = "STANDARD_OTP";
    public static final  String ACTIVATIONCODE="ACTIVATION CODE";
    public static final String SHARED_SECRET="SharedSecret";
    public static final String NO_CREDENTIALS_REGISTERED="NoCredentialRegistered";
    
    public static final String NOCREDREGISTERED = "NOCREDREGISTERED";
    public static final String VIPCREDREGISTERED = "VIPCREDREGISTERED";
    
    public static final String VIP="VIP";
    public static final String SMS="SMS";
    public static final String VOICE="VOICE";
    public static final String SMS_OTP="SMS_OTP";
    public static final String VOICE_OTP="VOICE_OTP";

    
    
    public final class VIPAuthStatusCode{
    	public VIPAuthStatusCode() {
		}
    	public static final String SUCCESS_CODE="6040";
    }
    
    public final class VIPSDKStatusCode{
    	public VIPSDKStatusCode() {
		}
    	public static final String SUCCESS_CODE="0000";
    }
    
    public final class DeleteCredentialsStatusCode{
    	public DeleteCredentialsStatusCode() {
		}
    	public static final String SUCCESS_CODE="0000";
    }
    
    public final class VIPPollPush{
    	public VIPPollPush() {
		}
    	public static final String ACCEPTED="7000";
    	public static final String UNANSWERED="7001";
    	public static final String REJECTED="7002";
    }
}
