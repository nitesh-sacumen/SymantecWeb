package com.symantec.tree.config;

public final class Constants {

    /**
     * Private constructor.
     */
    private Constants() {
    }
    
    public static final  String CRED_CHOICE ="SelectedValue";
    public static final  String CRED_ID ="CredentialID";
    public static final  String SECURE_CODE ="SecurityCode";
    public static final  String TXN_ID ="TransactionID";
    public static final  String MOB_NUM ="Mobile Number";
    public static final  String CONFIRM_CRED_CHOICE =" Cred Choice";
    public static final  String SECURE_CODE_ERROR =" Display Error";
    

    public static final String PUSH_DISPLAY_MESSAGE_TEXT = "push_display_message_text";
    public static final String PUSH_DISPLAY_MESSAGE_TITLE = "push_display_message_title";
    public static final String PUSH_DISPLAY_MESSAGE_PROFILE = "push_display_message_profile";
    
    public static final String STANDARD_OTP = "STANDARD_OTP";
    public static final String ACTIVATION_CODE ="ACTIVATION CODE";
  
    public static final String NO_CREDENTIALS_REGISTERED="NoCredentialRegistered";
    
    public static final String NO_CRED_REGISTERED = "NO_CRED_REGISTERED";
    public static final String VIP_CRED_REGISTERED = "VIP_CRED_REGISTERED";
    
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
