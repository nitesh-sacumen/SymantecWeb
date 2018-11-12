package com.symantec.tree.nodes.test;

import static com.symantec.tree.config.Constants.MOB_NUM;
import static com.symantec.tree.config.Constants.SECURE_CODE_ERROR;
import static java.util.Collections.emptyList;
import static org.forgerock.json.JsonValue.object;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import com.symantec.tree.nodes.VIPOTPAuth;
import java.util.HashMap;
import java.util.Map;
import org.forgerock.json.JsonValue;
import org.forgerock.openam.auth.node.api.Action;
import org.forgerock.openam.auth.node.api.ExternalRequestContext;
import org.forgerock.openam.auth.node.api.SharedStateConstants;
import org.forgerock.openam.auth.node.api.TreeContext;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 
 * @author Symantec
 * @category test
 * test class for "VIPOTPAuth"
 *
 */
@Test
public class VIPOTPAuthTest {
	@Mock
	private VIPOTPAuth.Config config;

	@BeforeMethod
	public void before() {

		initMocks(this);
		//TODO Duplicate Code Found
		HashMap<Integer, String> creds = new HashMap<>();
		creds.put(0,"VIP");
		creds.put(1,"SMS");
		creds.put(2, "VOICE");
		when(config.referrerCredList()).thenReturn(creds);


	}
	@Test
	public void proces() {
        TreeContext context = getTreeContext(new HashMap<>());

		context.sharedState.put(SharedStateConstants.USERNAME,"ruchika");
		context.sharedState.put(MOB_NUM,"8147109089");
		context.sharedState.put(SECURE_CODE_ERROR," Display Error");
		
		VIPOTPAuth node = new VIPOTPAuth(config);

		// WHEN
		//TODO Not verifying anything here

		Action action = node.process(context);

	}

	private TreeContext getTreeContext(Map<String, String[]> parameters) {
		return new TreeContext(JsonValue.json(object(1)),
				new ExternalRequestContext.Builder().parameters(parameters).build(), emptyList());
	}
}
