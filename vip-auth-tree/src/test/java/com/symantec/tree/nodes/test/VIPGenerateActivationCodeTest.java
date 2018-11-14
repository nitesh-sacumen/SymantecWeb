package com.symantec.tree.nodes.test;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.forgerock.json.JsonValue.object;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.HashMap;
import java.util.Map;

import org.forgerock.json.JsonValue;
import org.forgerock.openam.auth.node.api.Action;
import org.forgerock.openam.auth.node.api.ExternalRequestContext;
import org.forgerock.openam.auth.node.api.TreeContext;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.symantec.tree.nodes.VIPGenerateActivationCode;

/**
 * 
 * @author Symantec
 * @category test test class for "VIPGenerateActivationCode"
 *
 */
@Test
public class VIPGenerateActivationCodeTest {
	@Mock
	private VIPGenerateActivationCode.Config config;

	@BeforeMethod
	public void before() {
		initMocks(this);

	}

	@Test
	public void nodeProcess() {
		//Given
		TreeContext context = getTreeContext(new HashMap<>());
		VIPGenerateActivationCode node = new VIPGenerateActivationCode();

		// WHEN
		Action action = node.process(context);
		
		//Then
		assertThat(action.callbacks).isEmpty();
		assertThat(action.outcome).isEqualTo("true");

	}

	private TreeContext getTreeContext(Map<String, String[]> parameters) {
		return new TreeContext(JsonValue.json(object(1)),
				new ExternalRequestContext.Builder().parameters(parameters).build(), emptyList());
	}
}
