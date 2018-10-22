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
import com.symantec.tree.request.util.AuthPollPush;
import java.util.List;
import java.util.ResourceBundle;
import javax.inject.Inject;
import org.forgerock.guava.common.base.Strings;
import org.forgerock.guava.common.collect.ImmutableList;
import org.forgerock.json.JsonValue;
import org.forgerock.openam.auth.node.api.Action;
import org.forgerock.openam.auth.node.api.Action.ActionBuilder;
import org.forgerock.openam.auth.node.api.Node;
import org.forgerock.openam.auth.node.api.OutcomeProvider;
import org.forgerock.openam.auth.node.api.TreeContext;
import org.forgerock.util.i18n.PreferredLocales;
import static com.symantec.tree.config.Constants.TXNID;

/** 
 * A node that checks to see PollPush status 
 * for this request. 
 */
@Node.Metadata(outcomeProvider = SymantecPollPushAuth.SymantecOutcomeProvider.class, configClass = SymantecPollPushAuth.Config.class)
public class SymantecPollPushAuth implements Node {
	
	//Node Properties
	private static final String BUNDLE = "com/symantec/tree/nodes/SymantecPollPushAuth";
	
	private AuthPollPush pollPush;
	/**
	 * Configuration for the node.
	 */
	public interface Config {

		/**
		 * the ttlSeconds.
		 * 
		 * @return the ttlSeconds 
		 * Reserved for future purpose
		 */

	}

	/**
	 * Create the node.
	 * 
	 * @param config
	 *            The service config.
	 */
	@Inject
	public SymantecPollPushAuth(@Assisted Config config) {
		
	//	verifyAuthClient = verifyAuthClientUtility.getAuthClient(uri);
		pollPush= new AuthPollPush();
	}

	/**
	 * 	This Node method Authenticates PollPush.
	 */
	public Action process(TreeContext context) {
		//logger.debug("Entered into ValidaePush porcess method");
		
	    return verifyAuth(context);

	}

	/**
	 * 	This Node method Authenticates PollPush.
	 */
	private Action verifyAuth(TreeContext context) {
		//logger.debug("Entered into verifyAuth  method");
		JsonValue newSharedState = context.sharedState.copy();


	//	 JsonValue sharedState = context.sharedState;
		try {


				String result = pollPush.authPollPush(context.sharedState.get(TXNID).asString());

				if (result != null) {

					if (!Strings.isNullOrEmpty(result)) {

						switch (result) {
						case "7000":
							return goTo(Symantec.TRUE).replaceSharedState(newSharedState).build();

						case "7001":
							
							return goTo(Symantec.UNANSWERED).replaceSharedState(newSharedState).build();

						case "7002":
							return goTo(Symantec.FALSE).replaceSharedState(newSharedState).build();

						case "7004":
							return goTo(Symantec.FALSE).replaceSharedState(newSharedState).build();

						case "7005":
							return goTo(Symantec.FALSE).replaceSharedState(newSharedState).build();

						
						default:
							return goTo(Symantec.UNANSWERED).replaceSharedState(newSharedState).build();

						}

					}
				}


		} catch (Exception e) {
			//logger.error(e.getMessage());
		}

		return goTo(Symantec.FALSE).replaceSharedState(newSharedState).build();

	}

	private ActionBuilder goTo(Symantec outcome) {
		return Action.goTo(outcome.name());
	}

	/**
	 * The possible outcomes for the PollPushAuth.
	 */
	public enum Symantec {
		/**
		 * Successful authentication.
		 */
		TRUE,
		/**
		 * Authentication failed.
		 */
		FALSE,
		/**
		 * The user has not been answered.
		 */
		UNANSWERED

	}


	/**
	 * Defines the possible outcomes from this PollPushAuthr node.
	 */
	public static class SymantecOutcomeProvider implements OutcomeProvider {
		@Override
		public List<Outcome> getOutcomes(PreferredLocales locales, JsonValue nodeAttributes) {
			ResourceBundle bundle = locales.getBundleInPreferredLocale(SymantecPollPushAuth.BUNDLE,
					SymantecOutcomeProvider.class.getClassLoader());
			return ImmutableList.of(
					new Outcome(Symantec.TRUE.name(), bundle.getString("trueOutcome")),
					new Outcome(Symantec.FALSE.name(), bundle.getString("falseOutcome")),
					new Outcome(Symantec.UNANSWERED.name(), bundle.getString("unansweredOutcome")));
		}
	}
	
 

}
