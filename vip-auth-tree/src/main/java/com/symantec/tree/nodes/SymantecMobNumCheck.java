package com.symantec.tree.nodes;

import static com.symantec.tree.config.Constants.TXNID;

import javax.inject.Inject;

import org.forgerock.openam.annotations.sm.Attribute;
import org.forgerock.openam.auth.node.api.AbstractDecisionNode;
import org.forgerock.openam.auth.node.api.Action;
import org.forgerock.openam.auth.node.api.Node;
import org.forgerock.openam.auth.node.api.NodeProcessException;
import org.forgerock.openam.auth.node.api.SharedStateConstants;
import org.forgerock.openam.auth.node.api.TreeContext;
import org.forgerock.openam.core.CoreWrapper;

import com.google.inject.assistedinject.Assisted;
import com.sun.identity.shared.debug.Debug;
import com.symantec.tree.nodes.SymantecSearchUser.Config;
import com.symantec.tree.request.util.VIPSearchUser;

import static com.symantec.tree.config.Constants.MOBNUM;

@Node.Metadata(outcomeProvider = AbstractDecisionNode.OutcomeProvider.class,
configClass = SymantecMobNumCheck.Config.class)
public class SymantecMobNumCheck extends AbstractDecisionNode {



private final Config config;
private final CoreWrapper coreWrapper;
private final static String DEBUG_FILE = "SymantecSearchUser";
protected Debug debug = Debug.getInstance(DEBUG_FILE);

private VIPSearchUser vipSearchUser;

/**
* Configuration for the node.
*/
public interface Config {

}
/**
* Create the node.
* @param config The service config.
* @throws NodeProcessException If the configuration was not valid.
*/
@Inject
public SymantecMobNumCheck(@Assisted Config config, CoreWrapper coreWrapper) throws NodeProcessException {
this.config = config;
this.coreWrapper = coreWrapper;
vipSearchUser = new VIPSearchUser();
}

@Override
public Action process(TreeContext context) throws NodeProcessException {
String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
String mobNum = vipSearchUser.getMobInfo(userName);
if(mobNum != null || !mobNum.isEmpty()) {
context.sharedState.put(MOBNUM,mobNum);
return goTo(true).build();
}
return goTo(false).build();
}
}

