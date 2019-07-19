package io.apiman.plugins.checkapikey;

import io.apiman.gateway.engine.beans.PolicyFailure;
import io.apiman.gateway.engine.beans.PolicyFailureType;
import io.apiman.test.policies.*;
import org.junit.Assert;
import org.junit.Test;


/**
 * Policy tests for {@link ApiKeyCheckPolicy} plugin.
 *
 * @author Gabriel Owoeye {@literal <owoeye.g.o@gmail.com>}
 */
@TestingPolicy(ApiKeyCheckPolicy.class)
public class ApiKeyCheckPolicyTest extends ApimanPolicyTest {

    private static final String TEST_ERROR_MSG = "No API Key";

    /**
     * Requests should fail if the Api Key is not set
     *
     * @throws Throwable throwable
     */
    @Test
    @Configuration("{\"errorMessage\": \"" + TEST_ERROR_MSG + "\"}")
    @BackEndApi(EchoBackEndApi.class)
    public void testNoApiKeyFails() throws Throwable {
        final PolicyTestRequest request = PolicyTestRequest.build(PolicyTestRequestType.POST, "/example");
        PolicyFailure failure = null;
        try {
            send(request);
        } catch (PolicyFailureError pfe) {
            failure = pfe.getFailure();
        }
        Assert.assertNotNull(failure);
        Assert.assertEquals(ApiKeyCheckPolicy.KEY_NOT_PROVIDED, failure.getFailureCode());
        Assert.assertEquals(PolicyFailureType.Authentication, failure.getType());
        Assert.assertEquals(TEST_ERROR_MSG, failure.getMessage());
    }
}
