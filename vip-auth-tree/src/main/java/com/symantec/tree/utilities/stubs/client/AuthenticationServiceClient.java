package com.symantec.tree.utilities.stubs.client;

import java.io.File;
import java.rmi.RemoteException;
import org.apache.axis2.AxisFault;

import com.symantec.tree.utilities.stubs.AuthenticationServiceStub;
import com.symantec.tree.utilities.stubs.AuthenticationServiceStub.CheckOtpRequest;
import com.symantec.tree.utilities.stubs.AuthenticationServiceStub.CheckOtpRequestType;
import com.symantec.tree.utilities.stubs.AuthenticationServiceStub.CheckOtpResponse;
import com.symantec.tree.utilities.stubs.AuthenticationServiceStub.OtpAuthDataType;
import com.symantec.tree.utilities.stubs.AuthenticationServiceStub.OtpType;
import com.symantec.tree.utilities.stubs.AuthenticationServiceStub.RequestIdType;
import com.symantec.tree.utilities.stubs.AuthenticationServiceStub.UserIdType;




public class AuthenticationServiceClient {
	
	static String endpoint = "https://userservices-auth.vip.symantec.com/vipuserservices/AuthenticationService_1_8";
	static char SEP = File.separatorChar;
	//private static final String truststore = "D:/Entersekt/vip_cert.jks";
	private static final String truststore = System.getProperty("java.home") + SEP + "lib" + SEP + "security"+SEP+"vip_cert.jks";

	public static String checkOtp() {
		try {
		System.setProperty("javax.net.ssl.keyStore",truststore);
		System.setProperty("javax.net.ssl.keyStoreType", "JKS");
		System.setProperty("javax.net.ssl.keyStorePassword","Innominds123$");
	
		AuthenticationServiceStub authenticationService= new AuthenticationServiceStub(endpoint);
		
		CheckOtpRequest otpRequest= new CheckOtpRequest();
		CheckOtpRequestType otpRequestType= new CheckOtpRequestType();
		UserIdType idType= new UserIdType();
		idType.setUserIdType("Bhargav");
		otpRequestType.setUserId(idType);
		
		RequestIdType reqIdType= new RequestIdType();
		reqIdType.setRequestIdType("1234567");
		otpRequestType.setRequestId(reqIdType);
		
		OtpAuthDataType otpType= new OtpAuthDataType();
		
		OtpType otpvalue= new OtpType();
		otpvalue.setOtpType("953040");
		otpType.setOtp(otpvalue);
		otpRequestType.setOtpAuthData(otpType);
		
		otpRequest.setCheckOtpRequest(otpRequestType);
		CheckOtpResponse otpResponse= authenticationService.checkOtp(otpRequest);
		
		System.out.println(otpResponse.getCheckOtpResponse().getStatusMessage());
		
		return otpResponse.getCheckOtpResponse().getStatus().toString();
		
		
		
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
