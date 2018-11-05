package com.symantec.tree.nodes.test;

import static com.symantec.tree.config.Constants.SECURECODE;
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
import com.symantec.tree.nodes.VIPOtpCheck;

/**
 * 
 * @author Symantec
 * @category test
 * test class for "VIPOtpCheck"
 *
 */
@Test
public class VIPOtpCheckTest {
	@Mock
	private VIPOtpCheck.Config config;
	@Mock
	private CoreWrapper coreWrapper;

	@BeforeMethod
	public void before() throws URISyntaxException, AuthLoginException {

		initMocks(this);
		
	}
	
	@Test
	public void proces() throws Exception {
		TreeContext context = new TreeContext(JsonValue.json(object(1)),
                new ExternalRequestContext.Builder().build(), emptyList());
        
        Map<String, String[]> parameters = new HashMap<>();
        parameters.put(SharedStateConstants.USERNAME, new String[] {"mkathi"});
        parameters.put(SECURECODE, new String[] {"12345678"});
   
        context = getTreeContext(new HashMap<String, String[]>());

//		context.sharedState.put(SharedStateConstants.USERNAME,"ruchika");
//		context.sharedState.put(SECURECODE,"678384");
		
		VIPOtpCheck node = new VIPOtpCheck(config,coreWrapper);

		// WHEN
		Action action = node.process(context);

	}

	private TreeContext getTreeContext(Map<String, String[]> parameters) {
		return new TreeContext(JsonValue.json(object(1)),
				new ExternalRequestContext.Builder().parameters(parameters).build(), emptyList());
	}
}
