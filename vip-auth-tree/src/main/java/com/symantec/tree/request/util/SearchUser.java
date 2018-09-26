package com.symantec.tree.request.util;

import java.io.File;
import java.rmi.RemoteException;
import java.util.Random;

import org.apache.axis2.AxisFault;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.symantec.tree.utilities.stubs.QueryServiceStub;
import com.symantec.tree.utilities.stubs.QueryServiceStub.GetUserInfoRequest;
import com.symantec.tree.utilities.stubs.QueryServiceStub.GetUserInfoRequestType;
import com.symantec.tree.utilities.stubs.QueryServiceStub.GetUserInfoResponse;
import com.symantec.tree.utilities.stubs.QueryServiceStub.RequestIdType;
import com.symantec.tree.utilities.stubs.QueryServiceStub.UserIdType;
import com.symantec.tree.utilities.stubs.client.ManagementServiceClient;


public interface SearchUser {
	static char SEP = File.separatorChar;
	static final String truststore = System.getProperty("java.home") + SEP + "lib" + SEP + "security"+SEP+"vip_cert.jks";
	static final Logger logger = LoggerFactory.getLogger("amVipAuth");
	
	public static boolean searchUser(String ... args) {

		System.out.println(args[0]);
		System.setProperty("javax.net.ssl.keyStore",truststore);
		System.setProperty("javax.net.ssl.keyStoreType", "JKS");
		System.setProperty("javax.net.ssl.keyStorePassword",args[1]);
		//to enable debug level log use this property
		//System.setProperty("javax.net.debug", "ssl");
		try {
			QueryServiceStub queryService = new QueryServiceStub(args[0]);
			

			GetUserInfoRequest userInfo = new GetUserInfoRequest();
			GetUserInfoRequestType userType = new GetUserInfoRequestType();
			
			RequestIdType idType = new RequestIdType();
			idType.setRequestIdType(Integer.toString(new Random().nextInt()));
			userType.setRequestId(idType);
			
			UserIdType userIdType = new UserIdType();
			userIdType.setUserIdType(args[2]);
			userType.setUserId(userIdType);
			
			userInfo.setGetUserInfoRequest(userType);
			
			GetUserInfoResponse userResp = queryService.getUserInfo(userInfo);
			logger.debug("is Pin Set?:\t {}",userResp.getGetUserInfoResponse().getIsPinSet());
			logger.debug("User Satus Message {}",userResp.getGetUserInfoResponse().getStatusMessage());
			
			String status= ManagementServiceClient.voiceDeviceRegister(); //this method is for registering phone through voice
			logger.debug("Status from sms device: {}",status);
			//if(userResp.getGetUserInfoResponse().getStatus().toString().equals("0000"))
		return (userResp.getGetUserInfoResponse().getStatusMessage().equalsIgnoreCase("Success")?true:false);
		} catch (AxisFault e) {
			logger.error(e.getMessage());
		} catch (RemoteException e) {
			logger.error(e.getMessage());
		}
	
		
		return false;
	}

}
