package com.symantec.tree.utilities.stubs.client;

import java.io.File;
import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import com.symantec.tree.utilities.stubs.ManagementServiceStub;
import com.symantec.tree.utilities.stubs.ManagementServiceStub.AddCredentialRequest;
import com.symantec.tree.utilities.stubs.ManagementServiceStub.AddCredentialRequestType;
import com.symantec.tree.utilities.stubs.ManagementServiceStub.AddCredentialResponse;
import com.symantec.tree.utilities.stubs.ManagementServiceStub.BaseRequestWithAccountIdTypeChoice_type2;
import com.symantec.tree.utilities.stubs.ManagementServiceStub.CreateUserRequest;
import com.symantec.tree.utilities.stubs.ManagementServiceStub.CreateUserRequestType;
import com.symantec.tree.utilities.stubs.ManagementServiceStub.CreateUserResponse;
import com.symantec.tree.utilities.stubs.ManagementServiceStub.CredentialDetailType;
import com.symantec.tree.utilities.stubs.ManagementServiceStub.CredentialIdType;
import com.symantec.tree.utilities.stubs.ManagementServiceStub.CredentialTypeEnum;
import com.symantec.tree.utilities.stubs.ManagementServiceStub.PhoneNumberType;
import com.symantec.tree.utilities.stubs.ManagementServiceStub.PinType;
import com.symantec.tree.utilities.stubs.ManagementServiceStub.RegisterRequest;
import com.symantec.tree.utilities.stubs.ManagementServiceStub.RegisterRequestType;
import com.symantec.tree.utilities.stubs.ManagementServiceStub.RegisterResponse;
import com.symantec.tree.utilities.stubs.ManagementServiceStub.RequestIdType;
import com.symantec.tree.utilities.stubs.ManagementServiceStub.SmsDeliveryInfoType;
import com.symantec.tree.utilities.stubs.ManagementServiceStub.UserIdType;
import com.symantec.tree.utilities.stubs.ManagementServiceStub.VoiceDeliveryInfoType;


public class ManagementServiceClient {

	static String endpoint = "https://userservices-auth.vip.symantec.com/vipuserservices/ManagementService_1_8";
	static char SEP = File.separatorChar;
	//private static final String truststore = "D:/Entersekt/vip_cert.jks";
	private static final String truststore = System.getProperty("java.home") + SEP + "lib" + SEP + "security"+SEP+"vip_cert.jks";
	public ManagementServiceClient() {
	System.setProperty("javax.net.ssl.keyStore",truststore);
	System.setProperty("javax.net.ssl.keyStoreType", "JKS");
	System.setProperty("javax.net.ssl.keyStorePassword","Innominds123$");
	
	}
//	ManagementServiceStub managementService= new ManagementServiceStub(endpoint);

	
	
	 public static String createUser() {
		try {
			/* System.setProperty("javax.net.ssl.keyStore",truststore);
				System.setProperty("javax.net.ssl.keyStoreType", "JKS");
				System.setProperty("javax.net.ssl.keyStorePassword","Innominds123$");
			*/	
				ManagementServiceStub managementService= new ManagementServiceStub(endpoint);
				
				CreateUserRequest userRequest= new CreateUserRequest();
				CreateUserRequestType userRequestType= new CreateUserRequestType();
				
				UserIdType userType= new UserIdType();
				userType.setUserIdType("Bhargav");
				userRequestType.setUserId(userType);
				
				RequestIdType requestType= new RequestIdType();
				requestType.setRequestIdType("123456");
				userRequestType.setRequestId(requestType);
				
				PinType pinType= new PinType();
				pinType.setPinType("0225");
				
				userRequestType.setPin(pinType);
				
				userRequest.setCreateUserRequest(userRequestType);
				
				
				CreateUserResponse credentialResponse= managementService.createUser(userRequest);
				System.out.println(credentialResponse.getCreateUserResponse().getStatusMessage());
				return credentialResponse.getCreateUserResponse().getStatusMessage();
				
			}catch (AxisFault e) {
				
				// TODO Auto-generated catch block
				
			e.printStackTrace();
			return "Excepion";
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "Exception";
			}
			
			
			
	}
	 
	 public static String createCredential() {
		 try {
			/* System.setProperty("javax.net.ssl.keyStore",truststore);
				System.setProperty("javax.net.ssl.keyStoreType", "JKS");
				System.setProperty("javax.net.ssl.keyStorePassword","Innominds123$");
			*/	
				
				ManagementServiceStub managementService= new ManagementServiceStub(endpoint);
				
				AddCredentialRequest credentialRequest= new AddCredentialRequest();
				 AddCredentialRequestType credentialRequestType= new AddCredentialRequestType();
				 
				 UserIdType userType= new UserIdType();
					userType.setUserIdType("Bhargav");
					credentialRequestType.setUserId(userType);
					
					RequestIdType requestType= new RequestIdType();
					requestType.setRequestIdType("12345");
					credentialRequestType.setRequestId(requestType);
					
				CredentialDetailType credDetailType= new CredentialDetailType();
				CredentialIdType idType= new CredentialIdType();
				idType.setCredentialIdType("VSST53573712");
				credDetailType.setCredentialId(idType);
				credDetailType.setCredentialType(CredentialTypeEnum.STANDARD_OTP);
				credentialRequestType.setCredentialDetail(credDetailType);
				
				credentialRequest.setAddCredentialRequest(credentialRequestType);
			AddCredentialResponse credResponse=	managementService.addCredential(credentialRequest);
				
			System.out.println(credResponse.getAddCredentialResponse().getStatusMessage());
			
			return credResponse.getAddCredentialResponse().getStatusMessage();
		
			
		 }catch (AxisFault e) {
				
				// TODO Auto-generated catch block
				
			e.printStackTrace();
			return "Excepion";
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "Exception";
			}
			
		 
	 }
	 
	 public static String smsDeviceRegister() {
		 
		 try {
			 
			 ManagementServiceStub managementService= new ManagementServiceStub(endpoint);
			 
			 RegisterRequest regSmsRequest= new RegisterRequest();
			 RegisterRequestType regSmsRequestType= new RegisterRequestType();
			  RequestIdType requestId= new RequestIdType();
			  requestId.setRequestIdType("12546");
			  regSmsRequestType.setRequestId(requestId);
			  SmsDeliveryInfoType delInfoType= new SmsDeliveryInfoType();
			  PhoneNumberType phType= new PhoneNumberType();
			  phType.setPhoneNumberType("919640920187");
			  delInfoType.setPhoneNumber(phType);
			  
			  BaseRequestWithAccountIdTypeChoice_type2 basReqType= new BaseRequestWithAccountIdTypeChoice_type2();
			  
			  basReqType.setSmsDeliveryInfo(delInfoType);
			  
			  regSmsRequestType.setBaseRequestWithAccountIdTypeChoice_type2(basReqType);
		
			 regSmsRequest.setRegisterRequest(regSmsRequestType);
			 RegisterResponse regSmsResponse= managementService.register(regSmsRequest);
			 
			 System.out.println(regSmsResponse.getRegisterResponse().getStatusMessage());
			 
			 return regSmsResponse.getRegisterResponse().getStatus().toString();
			  
			 
		 }catch (AxisFault e) {
				
				// TODO Auto-generated catch block
				
			e.printStackTrace();
			return "Excepion";
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "Exception";
			}
		 
		 
	 }
	 
 public static String voiceDeviceRegister() {
		 
		 try {
			 
			 ManagementServiceStub managementService= new ManagementServiceStub(endpoint);
			 
			 RegisterRequest regSmsRequest= new RegisterRequest();
			 RegisterRequestType regSmsRequestType= new RegisterRequestType();
			  RequestIdType requestId= new RequestIdType();
			  requestId.setRequestIdType("125468");
			  regSmsRequestType.setRequestId(requestId);
			  VoiceDeliveryInfoType delInfoType= new VoiceDeliveryInfoType();
			  
			  PhoneNumberType phType= new PhoneNumberType();
			  phType.setPhoneNumberType("919640920187");
			  delInfoType.setPhoneNumber(phType);
			  
			  BaseRequestWithAccountIdTypeChoice_type2 basReqType= new BaseRequestWithAccountIdTypeChoice_type2();
			  
			  basReqType.setVoiceDeliveryInfo(delInfoType);
			 
			  
			  regSmsRequestType.setBaseRequestWithAccountIdTypeChoice_type2(basReqType);
		
			 regSmsRequest.setRegisterRequest(regSmsRequestType);
			 RegisterResponse regSmsResponse= managementService.register(regSmsRequest);
			 
			 System.out.println(regSmsResponse.getRegisterResponse().getStatusMessage());
			 
			 return regSmsResponse.getRegisterResponse().getStatus().toString();
			  
			 
		 }catch (AxisFault e) {
				
				// TODO Auto-generated catch block
				
			e.printStackTrace();
			return "Excepion";
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "Exception";
			}
 }
	 
	
}