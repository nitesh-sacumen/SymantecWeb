package com.symantec.tree.nodes.test;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.forgerock.json.JsonValue.object;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
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

import com.symantec.tree.nodes.VIPPushAuth;
/**
 * 
 * @author Symantec
 * @category test
 * test class for "VIPPushAuth"
 *
 */
@Test
public class VIPPushAuthTest {
	@Mock
	private VIPPushAuth.Config config;
	@Mock
	private CoreWrapper coreWrapper;
	
	@BeforeMethod
	public void before() {

		initMocks(this);
		when(config.displayMsgText()).thenReturn("Sacumen Push");
		when(config.displayMsgTitle()).thenReturn("Sacumen Push");
		when(config.displayMsgTitle()).thenReturn("www.sacumen.com");


	}

	@Test
	public void testProcess() {
		TreeContext context = getTreeContext(new HashMap<>());
		context.sharedState.put(SharedStateConstants.USERNAME, "vip123");

		// WHEN
		VIPPushAuth node = new VIPPushAuth(config);
		Action action = node.process(context);
		
		//THEN
		assertThat(action.callbacks).isEmpty();
		assertThat(action.outcome).isEqualTo("false");
	}
	

	private TreeContext getTreeContext(Map<String, String[]> parameters) {
		return new TreeContext(JsonValue.json(object(1)),
				new ExternalRequestContext.Builder().parameters(parameters).build(), emptyList());
	}
}
