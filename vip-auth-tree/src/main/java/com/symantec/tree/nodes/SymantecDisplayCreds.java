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

import com.google.inject.assistedinject.Assisted;
import com.sun.identity.sm.RequiredValueValidator;

import static org.forgerock.openam.auth.node.api.Action.send;
import org.forgerock.json.JsonValue;
import org.forgerock.openam.annotations.sm.Attribute;
import org.forgerock.openam.auth.node.api.*;
import org.forgerock.openam.core.CoreWrapper;
import org.forgerock.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.security.auth.callback.ChoiceCallback;
import java.util.*;

import static com.symantec.tree.config.Constants.CREDCHOICE;
/** 
 * A node that checks to see if zero-page login headers have specified username and shared key 
 * for this request. 
 */
@Node.Metadata(outcomeProvider  = SingleOutcomeNode.OutcomeProvider.class,
               configClass      = SymantecDisplayCreds.Config.class)
public class SymantecDisplayCreds extends SingleOutcomeNode {

    private final Config config;
    private final CoreWrapper coreWrapper;
    private static final String BUNDLE = "com/symantec/tree/nodes/SymantecDisplayCreds";
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

        @Attribute(order = 100,validators={RequiredValueValidator.class})
        default Map<Integer, String> referrerCredList() {
            return Collections.emptyMap();
        }

    }
    /**
     * Create the node.
     * @param config The service config.
     * @throws NodeProcessException If the configuration was not valid.
     */
    @Inject
    public SymantecDisplayCreds(@Assisted Config config, CoreWrapper coreWrapper) throws NodeProcessException {
        this.config = config;
        this.coreWrapper = coreWrapper;
    }

    @Override
    public Action process(TreeContext context) {

        JsonValue sharedState = context.sharedState;
        return context.getCallback(ChoiceCallback.class)
        		.map(c -> Integer.toString(c.getSelectedIndexes()[0]))
                .map(String::new)
                .filter(choice -> !Strings.isNullOrEmpty(choice))
                .map(choice -> {
                    logger.debug("choice has been collected and put in the shared state");
                    System.out.println("Selected index ... "+choice);
                    System.out.println("Selected value ... "+config.referrerCredList().get(Integer.parseInt(choice)));
                   
                    
                 
                    return goToNext()
                    		.replaceSharedState(sharedState.copy().put(CREDCHOICE, config.referrerCredList().get(Integer.parseInt(choice)))).build();
                })
                .orElseGet(() -> {
                    logger.debug("collecting choice");
                    return collectPassword(context);
                });
    }

    private Action collectPassword(TreeContext context) {
        ResourceBundle bundle = context.request.locales.getBundleInPreferredLocale(BUNDLE, getClass().getClassLoader());
        Collection<String> values = config.referrerCredList().values();
        String[] targetArray = values.toArray(new String[values.size()]);
        return send(new ChoiceCallback(bundle.getString("callback.creds"),targetArray,0,false)).build();
    }
}