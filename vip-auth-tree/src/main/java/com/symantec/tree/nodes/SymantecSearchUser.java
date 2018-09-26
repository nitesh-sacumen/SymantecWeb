/*
 * The contents of this file are subject to the terms of the Common Development and
 * Distribution License (the License). You may not use this file except in compliance with the
 * License.
 *
 * You can obtain a copy of the License at legal/CDDLv1.0.txt. See the License for the
 * specific language governing permission and limitations under the License.
 *
 * When distributing Covered Software, include this CDDL Header Notice in each file and include
 * the License file at legal/CDDLv1.0.txt. If applicable, add the following below the CDDL
 * Header, with the fields enclosed by brackets [] replaced by your own identifying
 * information: "Portions copyright [year] [name of copyright owner]".
 *
 * Copyright 2018 ForgeRock AS.
 */


package com.symantec.tree.nodes;

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
import com.sun.identity.sm.RequiredValueValidator;
import com.symantec.tree.request.util.SearchUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * A node that checks to see if zero-page login headers have specified username and shared key 
 * for this request. 
 */
@Node.Metadata(outcomeProvider  = AbstractDecisionNode.OutcomeProvider.class,
               configClass      = SymantecSearchUser.Config.class)
public class SymantecSearchUser extends AbstractDecisionNode {

    private final Config config;
    private final CoreWrapper coreWrapper;
    private final static String DEBUG_FILE = "SymantecSearchUser";
    protected Debug debug = Debug.getInstance(DEBUG_FILE);
    private final Logger logger = LoggerFactory.getLogger("amVipAuth");

    /**
     * Configuration for the node.
     */
    public interface Config {
    	@Attribute(order = 100, validators = {RequiredValueValidator.class})
        default String vipuserservice_url() {
            return "";
        }
        @Attribute(order = 100, validators = {RequiredValueValidator.class})
        default String keyStorePassword() {
            return "";
        }

    }
    /**
     * Create the node.
     * @param config The service config.
     * @throws NodeProcessException If the configuration was not valid.
     */
    @Inject
    public SymantecSearchUser(@Assisted Config config, CoreWrapper coreWrapper) throws NodeProcessException {
        this.config = config;
        this.coreWrapper = coreWrapper;
    }

    @Override
    public Action process(TreeContext context) throws NodeProcessException {
    	String userName = context.sharedState.get(SharedStateConstants.USERNAME).asString();
        return goTo(SearchUser.searchUser(config.vipuserservice_url(),config.keyStorePassword(),userName)).build();
    }
}