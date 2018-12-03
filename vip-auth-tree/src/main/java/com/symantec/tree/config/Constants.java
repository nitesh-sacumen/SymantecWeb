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
    public static final  String SECURE_CODE_ERROR ="Securiy Code Error";
    public static final  String PUSH_ERROR = "Push Auth Error";
    public static final  String CREDENTIAL_ID_ERROR ="Credential Id Error";
    public static final  String OTP_ERROR ="Invalid OTP";
    public static final  String DISPLAY_ERROR = "Failure Error";
    public static final  String PHONE_NUMBER_ERROR = "Invalid Phone Number";
    public static final  String KEY_STORE_PATH = "key_store_path";
    public static final  String KEY_STORE_PASS = "key_store_pass";
    public static final  String AUTHENTICATION_SERVICE_URL = "Authentication_Service_URL";
    public static final  String QUERY_SERVICE_URL = "Query_Service_URL";
    public static final  String MANAGEMENT_SERVICE_URL = "Management_Service_URL";
    public static final String DUPLICATE_CREDENTIAL_MESSAGE = "Duplicate Credential Message";
    public static final  String SDK_SERVICE_URL = "Sdk Service URL";
    

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
    public static final String SUCCESS_CODE = "0000";
    public static final String USER_DOES_NOT_EXIST = "6003";
    public static final String INVALID_CREDENIALS = "6004";
    public static final String INVALID_PHONE_NUMBER = "6015";
    public static final String SCHEMA_INVALID = "600B";
    public static final String AUTHENTICATION_FAILED = "6009";
    public static final String CREDENTIALS_ALREADY_REGISTERED = "6026";


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
    
    
    public final class VIPPollPush{
    	public VIPPollPush() {
		}
    	public static final String ACCEPTED="7000";
    	public static final String UNANSWERED="7001";
    	public static final String REJECTED="7002";
    }
}