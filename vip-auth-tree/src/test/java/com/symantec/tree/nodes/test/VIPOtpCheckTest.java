package com.symantec.tree.nodes.test;

import static com.symantec.tree.config.Constants.SECURE_CODE;
import static java.util.Collections.emptyList;
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
 * @category test
 * test class for "VIPOTPCheck"
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
	public void process() {
		TreeContext context;
        
        Map<String, String[]> parameters = new HashMap<>();
        parameters.put(SharedStateConstants.USERNAME, new String[] {"mkathi"});
        parameters.put(SECURE_CODE, new String[] {"12345678"});
   
        context = getTreeContext(new HashMap<>());

//		context.sharedState.put(SharedStateConstants.USERNAME,"ruchika");
//		context.sharedState.put(SECURE_CODE,"678384");
		
		VIPOTPCheck node = new VIPOTPCheck();

		// WHEN
		//TODO Not verifying anything here

		Action action = node.process(context);

	}

	private TreeContext getTreeContext(Map<String, String[]> parameters) {
		return new TreeContext(JsonValue.json(object(1)),
				new ExternalRequestContext.Builder().parameters(parameters).build(), emptyList());
	}
}
