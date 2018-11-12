package com.symantec.tree.nodes.test;

import static com.symantec.tree.config.Constants.*;
import static java.util.Collections.emptyList;
import static org.forgerock.json.JsonValue.object;
import static org.mockito.MockitoAnnotations.initMocks;

import com.symantec.tree.nodes.VIPVerifyCodeAddCredential;
import java.util.HashMap;
import java.util.Map;
import org.forgerock.json.JsonValue;
import org.forgerock.openam.auth.node.api.Action;
import org.forgerock.openam.auth.node.api.ExternalRequestContext;
import org.forgerock.openam.auth.node.api.SharedStateConstants;
import org.forgerock.openam.auth.node.api.TreeContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 * 
 * @author Symantec
 * @category test
 * test class for "VIPVerifyCodeAddCredential"
 *
 */
@Test
public class VIPVerifyCodeAddCredTest {

	@BeforeMethod
	public void before() {

		initMocks(this);

	}
	
	@Test
	public void process() {
        TreeContext context = getTreeContext(new HashMap<>());

		context.sharedState.put(SharedStateConstants.USERNAME,"ruchika");
		context.sharedState.put(CRED_ID,"SYMC87283752");
		context.sharedState.put(SECURE_CODE,"487385");
		context.sharedState.put(MOB_NUM,"918147109089");
		context.sharedState.put(CRED_CHOICE,"SMS");
		
		VIPVerifyCodeAddCredential node = new VIPVerifyCodeAddCredential();

		// WHEN
		//TODO Not verifying anything here

		Action action = node.process(context);

	}

	private TreeContext getTreeContext(Map<String, String[]> parameters) {
		return new TreeContext(JsonValue.json(object(1)),
				new ExternalRequestContext.Builder().parameters(parameters).build(), emptyList());
	}
}
