package com.symantec.tree.utilities.stubs.client;

import java.io.File;
import java.rmi.RemoteException;
import org.apache.axis2.AxisFault;

import com.symantec.tree.utilities.stubs.QueryServiceStub.GetUserInfoRequestType;
import com.symantec.tree.utilities.stubs.QueryServiceStub.UserIdType;
import com.symantec.tree.utilities.stubs.QueryServiceStub.GetUserInfoResponse;
import com.symantec.tree.utilities.stubs.QueryServiceStub;
import com.symantec.tree.utilities.stubs.QueryServiceStub.GetUserInfoRequest;
import com.symantec.tree.utilities.stubs.QueryServiceStub.RequestIdType;

public class QueryServiceClient {

	static String endpoint = "https://userservices-auth.vip.symantec.com/vipuserservices/QueryService_1_8";
	static char SEP = File.separatorChar;
	//private static final String truststore = "D:/Entersekt/vip_cert.jks";
	private static final String truststore = System.getProperty("java.home") + SEP + "lib" + SEP + "security"+SEP+"vip_cert.jks";
	public static void main(String[] args) {
		System.out.println(truststore);
		System.setProperty("javax.net.ssl.keyStore",truststore);
		System.setProperty("javax.net.ssl.keyStoreType", "JKS");
		System.setProperty("javax.net.ssl.keyStorePassword","Innominds123$");
		//to enable debug level log use this property
		//System.setProperty("javax.net.debug", "ssl");
		try {
			QueryServiceStub queryService = new QueryServiceStub(endpoint);
			

			GetUserInfoRequest userInfo = new GetUserInfoRequest();
			GetUserInfoRequestType userType = new GetUserInfoRequestType();
			
			RequestIdType idType = new RequestIdType();
			idType.setRequestIdType("1234");
			userType.setRequestId(idType);
			
			UserIdType userIdType = new UserIdType();
			userIdType.setUserIdType("Bhargav");
			userType.setUserId(userIdType);
			
			userInfo.setGetUserInfoRequest(userType);
			
			GetUserInfoResponse userResp = queryService.getUserInfo(userInfo);
			System.out.println("is Pin Set?:\t"+userResp.getGetUserInfoResponse().getIsPinSet());
			System.out.println(userResp.getGetUserInfoResponse().getStatusMessage());
			
			
		//	ManagementServiceClient.createUser(); //this method is for creating a user in vip
			//ManagementServiceClient.createCredential(); //this method is for creating VIP credential for user
	//String status=	AuthenticationServiceClient.checkOtp(); // this method is for validating VIP security code
			//String status= ManagementServiceClient.smsDeviceRegister(); // this method is for registering phone through sms
			String status= ManagementServiceClient.voiceDeviceRegister(); //this method is for registering phone through voice
		System.out.println("Status from sms device: "+status);
			//if(userResp.getGetUserInfoResponse().getStatus().toString().equals("0000"))
		} catch (AxisFault e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
