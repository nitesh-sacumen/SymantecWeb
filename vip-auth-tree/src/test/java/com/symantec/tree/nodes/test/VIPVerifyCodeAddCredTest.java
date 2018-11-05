package com.symantec.tree.nodes.test;

import static com.symantec.tree.config.Constants.CREDID;
import static com.symantec.tree.config.Constants.CREDCHOICE;
import static com.symantec.tree.config.Constants.SECURECODE;
import static com.symantec.tree.config.Constants.MOBNUM;
import static java.util.Collections.emptyList;
import static org.forgerock.json.JsonValue.object;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.forgerock.json.JsonValue;
import org.forgerock.openam.auth.node.api.Action;
import org.forgerock.openam.auth.node.api.ExternalRequestContext;
import org.forgerock.openam.auth.node.api.SharedStateConstants;
import org.forgerock.openam.auth.node.api.TreeContext;
import org.forgerock.openam.core.CoreWrapper;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sun.identity.authentication.spi.AuthLoginException;
import com.symantec.tree.nodes.VIPVerifyCodeAddCred;
/**
 * 
 * @author Symantec
 * @category test
 * test class for "VIPVerifyCodeAddCred"
 *
 */
@Test
public class VIPVerifyCodeAddCredTest {
	@Mock
	private VIPVerifyCodeAddCred.Config config;
	@Mock
	private CoreWrapper coreWrapper;

	@BeforeMethod
	public void before() throws URISyntaxException, AuthLoginException {

		initMocks(this);

	}
	
	@Test
	public void proces() throws Exception {
        TreeContext context = getTreeContext(new HashMap<String, String[]>());

		context.sharedState.put(SharedStateConstants.USERNAME,"ruchika");
		context.sharedState.put(CREDID,"SYMC87283752");
		context.sharedState.put(SECURECODE,"487385");
		context.sharedState.put(MOBNUM,"918147109089");
		context.sharedState.put(CREDCHOICE,"SMS");
		
		VIPVerifyCodeAddCred node = new VIPVerifyCodeAddCred(config,coreWrapper);

		// WHEN
		Action action = node.process(context);

	}

	private TreeContext getTreeContext(Map<String, String[]> parameters) {
		return new TreeContext(JsonValue.json(object(1)),
				new ExternalRequestContext.Builder().parameters(parameters).build(), emptyList());
	}
}
