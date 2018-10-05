package com.symantec.tree.nodes;

import javax.inject.Inject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.ConfirmationCallback;

import org.forgerock.guava.common.collect.ImmutableList;
import org.forgerock.json.JsonValue;
import org.forgerock.openam.auth.node.api.Action;
import org.forgerock.openam.auth.node.api.Node;
import org.forgerock.openam.auth.node.api.NodeProcessException;
import org.forgerock.openam.auth.node.api.OutcomeProvider;
import org.forgerock.openam.auth.node.api.TreeContext;
import org.forgerock.openam.auth.node.api.Action.ActionBuilder;
import org.forgerock.openam.core.CoreWrapper;
import org.forgerock.util.i18n.PreferredLocales;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.assistedinject.Assisted;
import com.sun.security.auth.callback.TextCallbackHandler;

import static org.forgerock.openam.auth.node.api.Action.send;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import static com.symantec.tree.config.Constants.CONFIRMCREDCHOICE;

@Node.Metadata(outcomeProvider  = SymantecConfirmCred.CredsOutcomeProvider.class,
configClass      = SymantecConfirmCred.Config.class)
public class SymantecConfirmCred implements Node {

    private final Config config;
    private final CoreWrapper coreWrapper;
    private static final String BUNDLE = "com/symantec/tree/nodes/SymantecConfirmCred";
    private final Logger logger = LoggerFactory.getLogger("vipAuth");

    /**
     * Configuration for the node.
     */
    public interface Config {

        /**
         * A white list of allowed Creds. If a referer is required, the request must have a referer on this list.
         *
         * @return the cred list.
         */

    	 /*      @Attribute(order = 100,validators={RequiredValueValidator.class})
      default Map<Integer, String> referrerCredList() {
            return Collections.emptyMap();
        }*/

    }
    /**
     * Create the node.
     * @param config The service config.
     * @throws NodeProcessException If the configuration was not valid.
     */
    @Inject
    public SymantecConfirmCred(@Assisted Config config, CoreWrapper coreWrapper) throws NodeProcessException {
        this.config = config;
        this.coreWrapper = coreWrapper;
    }

    @Override
    public Action process(TreeContext context) {
  	

        JsonValue sharedState = context.sharedState;
      String inputChoice= "";
        
        List<ConfirmationCallback> ls= context.getCallbacks(ConfirmationCallback.class);
        
               Iterator<ConfirmationCallback> it= ls.iterator();
        
        while(it.hasNext()) {
        	ConfirmationCallback cc = it.next();
        	System.out.println("option type is:\t"+cc.getOptionType());
        	System.out.println("selected option is:\t"+cc.getSelectedIndex());
        	inputChoice = SymantecConfirmCredOutcomeChoice.getChoiceByCode(cc.getSelectedIndex());
        	sharedState.put(CONFIRMCREDCHOICE, inputChoice);
        }
        System.out.println("choice value"+inputChoice);
        switch(inputChoice) {
        case "YES":
    		
    		return goTo(SymantecConfirmCredOutcome.YES).replaceSharedState(sharedState).build();
    	
    		
    		
    		       
        case "NO":
        	
        	return goTo(SymantecConfirmCredOutcome.NO).replaceSharedState(sharedState).build();
        	
        	
        }	
        
        	return displayCreds(context);
        /*try {
       new TextCallbackHandler().handle(new Callback[]{
                new ConfirmationCallback("Confirm", ConfirmationCallback.INFORMATION,
                        new String[]{"Yes", "No"}, 0)});
        }catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
		}
    
/*        return context.getCallback(ChoiceCallback.class)
                .map(c -> c.getSelectedIndexes()[0])
                .map(Integer::new)
                .filter(choice -> -1 < choice && choice < 2 )
                .map(choice -> {
                	sharedState.put(CONFIRMCREDCHOICE, config.referrerCredList().get(choice));
                	switch(choice) {
                	
                	case 0:
                		
                		return goTo(SymantecDisplayCredsOutcome.YES).replaceSharedState(sharedState).build();
                	case 2:
                		
                		return goTo(SymantecDisplayCredsOutcome.Cancel).replaceSharedState(sharedState).build();
                    
                		default:
                    	
                    	return goTo(SymantecDisplayCredsOutcome.NO).replaceSharedState(sharedState).build();
                	}
                	
                   // return goToNext()
                   //         .replaceTransientState(sharedState.copy().put(CREDCHOICE, config.referrerCredList().get(Integer.parseInt(choice)))).build();
                })
                .orElseGet(() -> {
                    logger.debug("collecting choice");
                    return displayCreds(context);
                })
*/
		     
    
        }

    private Action displayCreds(TreeContext context) {
    	List<Callback> cbList = new ArrayList<>(2);
        ResourceBundle bundle = context.request.locales.getBundleInPreferredLocale(BUNDLE, getClass().getClassLoader());               
       // Collection<String> values = config.referrerCredList().values();
       // String[] targetArray = values.toArray(new String[values.size()]);
        ConfirmationCallback ccb =new ConfirmationCallback("Add More Creds",ConfirmationCallback.INFORMATION,new String[]{"YES", "NO"}, 0);
        //ChoiceCallback ccb=new ChoiceCallback(bundle.getString("callback.creds"),targetArray,2,false);
        return send(ccb).build();
    }
    
    private ActionBuilder goTo(SymantecConfirmCredOutcome outcome) {
		return Action.goTo(outcome.name());
	}

	/**
	 * The possible outcomes for the EntersektVerifyAuth.
	 */
	public enum SymantecConfirmCredOutcome {
		/**
		 * selection of VIP.
		 */
		YES,
		/**
		 * selection for  SMS.
		 */
		NO,
		/**
		 * selection for VOICE.
		 
		CANCEL*/

	}
	
	public enum SymantecConfirmCredOutcomeChoice {
		
		YES(0,"YES"),
		NO(1,"NO");
		
		private int code;
		private String choice;
		SymantecConfirmCredOutcomeChoice(int code, String choice){
			this.code = code;
			this.choice=choice;
		}
		
		public static String getChoiceByCode(int code) {
			for(SymantecConfirmCredOutcomeChoice syc : SymantecConfirmCredOutcomeChoice.values()) {
				if(syc.code == code) {
					return syc.choice;
				}
			}
			return "";
		}
		
		
	}

	
	/**
	 * Defines the possible outcomes from this EntersektOutcomeProvider node.
	 */
	public static class CredsOutcomeProvider implements OutcomeProvider {
		@Override
		public List<Outcome> getOutcomes(PreferredLocales locales, JsonValue nodeAttributes) {
			ResourceBundle bundle = locales.getBundleInPreferredLocale(SymantecConfirmCred.BUNDLE,
					CredsOutcomeProvider.class.getClassLoader());
			return ImmutableList.of(
					new Outcome(SymantecConfirmCredOutcome.YES.name(), bundle.getString("YesOutcome")),
					new Outcome(SymantecConfirmCredOutcome.NO.name(), bundle.getString("NoOutcome")));
				//	new Outcome(SymantecDisplayCredsOutcome.CANCEL.name(), bundle.getString("CancelOutcome")));
		}
	}
}