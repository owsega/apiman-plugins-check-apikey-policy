package io.apiman.plugins.checkapikey;

import io.apiman.gateway.engine.beans.ApiRequest;
import io.apiman.gateway.engine.beans.PolicyFailureType;
import io.apiman.gateway.engine.components.IPolicyFailureFactoryComponent;
import io.apiman.gateway.engine.policies.AbstractMappedPolicy;
import io.apiman.gateway.engine.policy.IPolicyChain;
import io.apiman.gateway.engine.policy.IPolicyContext;


/**
 * A policy that only permits requests with API key
 *
 * @author Gabriel Owoeye {@literal <owoeye.g.o@gmail.com>}
 */
public class ApiKeyCheckPolicy extends AbstractMappedPolicy<String> {

    private static final int KEY_NOT_PROVIDED = 9999;

    @Override
    protected Class<String> getConfigurationClass() {
        return String.class;
    }

    @Override
    protected void doApply(ApiRequest request, IPolicyContext context, String config, IPolicyChain<ApiRequest> chain) {
        if (request.getApiKey() != null) {
            chain.doApply(request);
        } else {
            String msg = "The X-API-KEY header was not set"; // todo set this in the policy UI config
            chain.doFailure(context.getComponent(IPolicyFailureFactoryComponent.class).createFailure(
                    PolicyFailureType.Authentication, KEY_NOT_PROVIDED, msg));
        }
    }
}
