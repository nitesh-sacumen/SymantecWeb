package com.symantec.tree.nodes.test;

import static com.symantec.tree.config.Constants.SECURE_CODE;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.forgerock.json.JsonValue.object;
import static org.mockito.MockitoAnnotations.initMocks;

import com.symantec.tree.nodes.VIPOTPCheck;

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

/**
 * 
 * @author Symantec
 * @category test test class for "VIPOTPCheck"
 *
 */
@Test
public class VIPOtpCheckTest {
	@Mock
	private VIPOTPCheck.Config config;
	@Mock
	private CoreWrapper coreWrapper;
	
	@BeforeMethod
	public void before() {

		initMocks(this);

	}

	@Test
	public void testProcess() {
		TreeContext context = getTreeContext(new HashMap<>());

		context.sharedState.put(SharedStateConstants.USERNAME, "vip123");
		context.sharedState.put(SECURE_CODE, "78695981");

		// WHEN
		VIPOTPCheck node = new VIPOTPCheck();
		Action action = node.process(context);
		
		//THEN
		assertThat(action.callbacks).isEmpty();
		assertThat(action.outcome).isEqualTo("FALSE");

	}
	

	private TreeContext getTreeContext(Map<String, String[]> parameters) {
		return new TreeContext(JsonValue.json(object(1)),
				new ExternalRequestContext.Builder().parameters(parameters).build(), emptyList());
	}
}
