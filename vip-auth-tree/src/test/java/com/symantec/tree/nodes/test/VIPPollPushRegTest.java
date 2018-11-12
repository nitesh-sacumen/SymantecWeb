package com.symantec.tree.nodes.test;

import static com.symantec.tree.config.Constants.TXN_ID;
import static java.util.Collections.emptyList;
import static org.forgerock.json.JsonValue.object;
import static org.mockito.MockitoAnnotations.initMocks;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.forgerock.json.JsonValue;
import org.forgerock.openam.auth.node.api.Action;
import org.forgerock.openam.auth.node.api.ExternalRequestContext;
import org.forgerock.openam.auth.node.api.TreeContext;
import org.forgerock.openam.core.CoreWrapper;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sun.identity.authentication.spi.AuthLoginException;
import com.symantec.tree.nodes.VIPPollPushReg;
/**
 * 
 * @author Symantec
 * @category test
 * test class for "VIPPollPushReg"
 *
 */
@Test
public class VIPPollPushRegTest {
	@Mock
	private VIPPollPushReg.Config config;
	@Mock
	private CoreWrapper coreWrapper;

	@BeforeMethod
	public void before() {

		initMocks(this);

	}
	@Test
	public void proces() {
        TreeContext context = getTreeContext(new HashMap<>());
		context.sharedState.put(TXN_ID,"87283752");
		
		VIPPollPushReg node = new VIPPollPushReg();

		// WHEN
		//TODO Not verifying anything here

		Action action = node.process(context);

	}

	private TreeContext getTreeContext(Map<String, String[]> parameters) {
		return new TreeContext(JsonValue.json(object(1)),
				new ExternalRequestContext.Builder().parameters(parameters).build(), emptyList());
	}
}
