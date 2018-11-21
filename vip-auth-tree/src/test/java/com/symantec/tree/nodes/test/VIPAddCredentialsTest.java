package com.symantec.tree.nodes.test;

import static com.symantec.tree.config.Constants.*;

import com.symantec.tree.nodes.VIPAddCredential;
import com.symantec.tree.request.util.AddCredential;

import java.util.HashMap;
import java.util.Map;
import org.forgerock.openam.auth.node.api.ExternalRequestContext;
import org.forgerock.openam.auth.node.api.NodeProcessException;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.forgerock.json.JsonValue.*;
import static org.forgerock.json.test.assertj.AssertJJsonValueAssert.assertThat;
import static org.forgerock.openam.auth.node.api.SharedStateConstants.USERNAME;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.MockitoAnnotations.initMocks;
import org.forgerock.json.JsonValue;
import org.forgerock.openam.auth.node.api.Action;
import org.forgerock.openam.auth.node.api.TreeContext;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 
 * @author Symantec
 * @category test
 * test class for "VIPAddCredential"
 *
 */
@Test
public class VIPAddCredentialsTest {
	
	 @Mock
	 private AddCredential addCredential;
	 
	 @InjectMocks
	 private VIPAddCredential node;

	@BeforeMethod
	public void before() {
  
		node = null;
		initMocks(this);
	}

	@Test
	public void testProcessWithTrueOutcome() throws NodeProcessException {
		
		given(addCredential.addCredential(any(),any(),any(),any(),any())).willReturn(true);
        TreeContext context = getTreeContext(new HashMap<>());

		context.sharedState.put(USERNAME,"vip123");
		context.sharedState.put(CRED_ID,"SYMC87283752");
		context.sharedState.put(CRED_CHOICE,"VIP");
		context.sharedState.put(KEY_STORE_PATH,"C://Users//keystore.ks");
		context.sharedState.put(KEY_STORE_PASS,"WORK12345");
				
		// WHEN
		Action action = node.process(context);
		
		//THEN
		assertThat(action.callbacks).isEmpty();
	    assertThat(context.sharedState).isObject().contains(entry(USERNAME, "vip123"),entry(CRED_ID, "SYMC87283752"),entry(CRED_CHOICE,"VIP"));
	    assertThat(action.outcome).isEqualTo("true");
	}
	@Test
	public void testProcessWithFalseOutcome() throws NodeProcessException {
		
		given(addCredential.addCredential(any(),any(),any(),any(),any())).willReturn(false);
        TreeContext context = getTreeContext(new HashMap<>());

		context.sharedState.put(USERNAME,"vip123");
		context.sharedState.put(CRED_ID,"SYMC87283752");
		context.sharedState.put(CRED_CHOICE,"VIP");
				
		// WHEN
		Action action = node.process(context);
		
		// THEN
		assertThat(action.callbacks).isEmpty();
	    assertThat(context.sharedState).isObject().contains(entry(USERNAME, "vip123"),entry(CRED_ID, "SYMC87283752"),entry(CRED_CHOICE,"VIP"));
	    assertThat(action.outcome).isEqualTo("false");
	}
	
	private TreeContext getTreeContext(Map<String, String[]> parameters) {
		return new TreeContext(JsonValue.json(object(1)),
				new ExternalRequestContext.Builder().parameters(parameters).build(), emptyList());
	}
}
