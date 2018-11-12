package com.symantec.tree.nodes.test;


import static java.util.Collections.emptyList;
import static org.forgerock.json.JsonValue.object;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import com.symantec.tree.nodes.VIPDisplayCredential;
import java.util.HashMap;
import java.util.Map;
import org.forgerock.json.JsonValue;
import org.forgerock.openam.auth.node.api.Action;
import org.forgerock.openam.auth.node.api.ExternalRequestContext;
import org.forgerock.openam.auth.node.api.TreeContext;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 
 * @author Symantec
 * @category test
 * test class for "VIPDisplayCredential"
 *
 */
@Test
public class VIPDisplayCredsTest {
	@Mock
	private VIPDisplayCredential.Config config;

	@BeforeMethod
	public void before() {

		//TODO Duplicate code found in VIPOTPAuthTest
		initMocks(this);

		HashMap<Integer, String> creds = new HashMap<>();
		creds.put(0,"VIP");
		creds.put(1,"SMS");
		creds.put(2, "VOICE");
		when(config.referrerCredList()).thenReturn(creds);
	}

	@Test
	public void proces() {
        TreeContext context = getTreeContext(new HashMap<>());
		
		VIPDisplayCredential node = new VIPDisplayCredential(config);

		// WHEN
		//TODO Not verifying anything here
		Action action = node.process(context);

	}

	private TreeContext getTreeContext(Map<String, String[]> parameters) {
		return new TreeContext(JsonValue.json(object(1)),
				new ExternalRequestContext.Builder().parameters(parameters).build(), emptyList());
	}
}
