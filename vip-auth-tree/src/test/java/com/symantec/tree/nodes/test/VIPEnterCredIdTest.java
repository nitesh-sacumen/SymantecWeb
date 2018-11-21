package com.symantec.tree.nodes.test;

import static com.symantec.tree.config.Constants.CRED_CHOICE;
import static com.symantec.tree.config.Constants.CRED_ID;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.forgerock.json.JsonValue.field;
import static org.forgerock.json.JsonValue.json;
import static org.forgerock.json.JsonValue.object;
import static org.forgerock.json.test.assertj.AssertJJsonValueAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.MockitoAnnotations.initMocks;

import com.symantec.tree.nodes.VIPEnterCredentialId;

import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.PasswordCallback;

import org.forgerock.json.JsonValue;
import org.forgerock.openam.auth.node.api.Action;
import org.forgerock.openam.auth.node.api.TreeContext;
import org.forgerock.openam.auth.node.api.ExternalRequestContext.Builder;
import org.forgerock.util.i18n.PreferredLocales;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 
 * @author Symantec
 * @category test
 * test class for "VIPEnterCredentialId"
 *
 */
@Test
public class VIPEnterCredIdTest {
	@Mock
	private VIPEnterCredentialId.Config config;

	@BeforeMethod
	public void before() {

		initMocks(this);

	}
	
	@Test
    public void testProcessWithNoCallbacksReturnsASingleCallback() {
        // Given
		VIPEnterCredentialId node = new VIPEnterCredentialId();
        JsonValue sharedState = json(object(field(CRED_CHOICE, "SMS")));
        PreferredLocales preferredLocales = mock(PreferredLocales.class);
        ResourceBundle resourceBundle = new MockResourceBundle("Enter Your Cred Id");
        given(preferredLocales.getBundleInPreferredLocale(any(), any())).willReturn(resourceBundle);

        // When
        Action result = node.process(getContext(sharedState, preferredLocales, emptyList()));

        // Then
        assertThat(result.outcome).isEqualTo(null);
        assertThat(result.callbacks).hasSize(1);
        assertThat(result.callbacks.get(0)).isInstanceOf(PasswordCallback.class);
        assertThat(((PasswordCallback) result.callbacks.get(0)).getPrompt()).isEqualTo("Enter Your Cred Id");
        assertThat((Object) result.sharedState).isNull();
        assertThat(sharedState).isObject().containsExactly(entry(CRED_CHOICE,"SMS"));
    }

    @Test
    public void testProcessWithCallbacksAddsToState() {
    	VIPEnterCredentialId node = new VIPEnterCredentialId();
        JsonValue sharedState = json(object(field(CRED_CHOICE, "SMS")));
        PasswordCallback callback = new PasswordCallback("prompt", false);
        callback.setPassword("secret".toCharArray());
        
        //WHEN
        Action result = node.process(getContext(sharedState, new PreferredLocales(), singletonList(callback)));
        
        //THEN
        assertThat(result.outcome).isEqualTo("outcome");
        assertThat(result.callbacks).isEmpty();
        assertThat(result.sharedState).isObject().contains(CRED_CHOICE, "SMS");
        assertThat(result.sharedState).isObject().contains(CRED_ID, "secret");
        assertThat(sharedState).isObject().containsExactly(entry(CRED_CHOICE, "SMS"));
    }

    private TreeContext getContext(JsonValue sharedState, PreferredLocales preferredLocales,
                                   List<? extends Callback> callbacks) {
        return new TreeContext(sharedState, new Builder().locales(preferredLocales).build(), callbacks);
    }

    static class MockResourceBundle extends ResourceBundle {
        private final String value;

        MockResourceBundle(String value) {
            this.value = value;
        }

        @Override
        protected Object handleGetObject(String key) {
            return value;
        }

        @Override
        public Enumeration<String> getKeys() {
            return null;
        }
    }
}
