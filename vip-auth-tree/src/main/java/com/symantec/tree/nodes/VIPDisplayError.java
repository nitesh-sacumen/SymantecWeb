package com.symantec.tree.nodes;

import static com.symantec.tree.config.Constants.DISPLAY_ERROR;
import static org.forgerock.openam.auth.node.api.Action.send;

import com.google.common.base.Strings;
import javax.inject.Inject;
import javax.security.auth.callback.TextOutputCallback;
import org.forgerock.openam.auth.node.api.Action;
import org.forgerock.openam.auth.node.api.Node;
import org.forgerock.openam.auth.node.api.SingleOutcomeNode;
import org.forgerock.openam.auth.node.api.TreeContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Sacumen(www.sacumen.com)<br> <br>
 * 
 * @category Node
 * 
 * "VIP DISPLAY ERROR" node with single outcome, which will lead to "login failure".
 * 
 * It Displays error to the user.
 *
 */
@Node.Metadata(outcomeProvider  = SingleOutcomeNode.OutcomeProvider.class,
               configClass      = VIPDisplayError.Config.class)
public class VIPDisplayError extends SingleOutcomeNode{
	 static Logger logger = LoggerFactory.getLogger(VIPDisplayError.class);

	    
	    /**
	     * Configuration for the node.
	     */
	    public interface Config {}

	    /**
	     * Create the node.
	     */
	    @Inject
	    public VIPDisplayError() {
	        }
	    
	    /**
	     * 
	     * @param context TreeContext instance
	     * @return Action instance
	     */
		private Action displayError(TreeContext context) {
			String outputError=context.sharedState.get(DISPLAY_ERROR).asString();
			TextOutputCallback pcb = new TextOutputCallback(0, outputError);
			return send(pcb).build();
		}
		
		
		/**
	     * This Node method displays Error.
	     */
	    @Override
	    public Action process(TreeContext context) {
	    	logger.info("Displaying Error...........");
	    	return context.getCallback(TextOutputCallback.class).map(TextOutputCallback::getMessage)
	                .map(String::new)
	                .filter(name -> !Strings.isNullOrEmpty(name))
	                .map(name -> {
	                	return goToNext().build();
	                }).orElseGet(() -> {
						return displayError(context);
					});
	                	
	    }
	  }
