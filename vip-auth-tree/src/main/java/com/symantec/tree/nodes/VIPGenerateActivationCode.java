package com.symantec.tree.nodes;

import com.google.inject.assistedinject.Assisted;
import com.sun.identity.shared.debug.Debug;
import com.symantec.tree.request.util.GenerateActivationCode;

import org.forgerock.openam.annotations.sm.Attribute;
import org.forgerock.openam.auth.node.api.*;
import org.forgerock.openam.core.CoreWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.symantec.tree.config.Constants.ACTIVATIONCODE;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

@Node.Metadata(outcomeProvider  = AbstractDecisionNode.OutcomeProvider.class,
configClass      = VIPGenerateActivationCode.Config.class)
public class VIPGenerateActivationCode extends AbstractDecisionNode{

	private final static String DEBUG_FILE = "SymantecSearchUser";
    protected Debug debug = Debug.getInstance(DEBUG_FILE);
    
    private final Config config;
    private final CoreWrapper coreWrapper;
    
    private GenerateActivationCode generateActivationCode;
    final Map<String, String> vipPushCodeMap = new HashMap<>();
    private final Logger logger = LoggerFactory.getLogger("SymantecGenerateActivationCode");
    
    /**
     * Configuration for the node.
     */
    public interface Config {
    	
    	 @Attribute(order = 100,requiredValue = true)
         default String vipuserservice_url() {
             return "";
         }
    }

        
        @Inject
        public VIPGenerateActivationCode(@Assisted Config config, CoreWrapper coreWrapper) throws NodeProcessException {
        	
            this.config = config;
            this.coreWrapper = coreWrapper;
            generateActivationCode = new GenerateActivationCode();
    }
        
        @Override
        public Action process(TreeContext context) throws NodeProcessException {
        	String Stat  = generateActivationCode.generateCode();
        	String[] array=Stat.split(",");
        	for(String s:array)
        		System.out.println("Values:"+s);
        	String status=array[0];
        	String activationCode=array[1];
        	System.out.println("status of get Activation_code api call  .. "+ status);
        	System.out.println("activationCode is .. "+ activationCode);
        	
        	context.sharedState.put(ACTIVATIONCODE,activationCode);
        		if(status.equalsIgnoreCase("0000")) {
        			System.out.println("Activation code generated successfuly:"+status);
        			return goTo(true).build();
        		}
        		else {
            		return goTo(false).build();
            	}
            
        }
}