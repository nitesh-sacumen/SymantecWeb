package com.symantec.tree.nodes.test;


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
import org.forgerock.openam.auth.node.api.TreeContext;
import org.forgerock.openam.core.CoreWrapper;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sun.identity.authentication.spi.AuthLoginException;
import com.symantec.tree.nodes.VIPDisplayCreds;

/**
 * 
 * @author Symantec
 * @category test
 * test class for "VIPDisplayCreds"
 *
 */
@Test
public class VIPDisplayCredsTest {
	@Mock
	private VIPDisplayCreds.Config config;
	@Mock
	private CoreWrapper coreWrapper;

	@BeforeMethod
	public void before() throws URISyntaxException, AuthLoginException {

		initMocks(this);

		HashMap<Integer, String> creds = new HashMap<Integer,String>();
		creds.put(0,"VIP");
		creds.put(1,"SMS");
		creds.put(2, "VOICE");
		when(config.referrerCredList()).thenReturn(creds);
	}

	@Test
	public void proces() throws Exception {
        TreeContext context = getTreeContext(new HashMap<String, String[]>());
		
		VIPDisplayCreds node = new VIPDisplayCreds(config,coreWrapper);

		// WHEN
		Action action = node.process(context);

	}

	private TreeContext getTreeContext(Map<String, String[]> parameters) {
		return new TreeContext(JsonValue.json(object(1)),
				new ExternalRequestContext.Builder().parameters(parameters).build(), emptyList());
	}
}
