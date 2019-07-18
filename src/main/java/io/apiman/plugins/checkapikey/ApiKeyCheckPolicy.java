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
public class ApiKeyCheckPolicy extends AbstractMappedPolicy<ApiKeyCheckBean> {

    private static final int KEY_NOT_PROVIDED = 9999;

    @Override
    protected Class<ApiKeyCheckBean> getConfigurationClass() {
        return ApiKeyCheckBean.class;
    }

    @Override
    protected void doApply(ApiRequest request, IPolicyContext context, ApiKeyCheckBean config,
                           IPolicyChain<ApiRequest> chain) {
        if (request.getApiKey() != null) {
            chain.doApply(request);
        } else {
            chain.doFailure(context.getComponent(IPolicyFailureFactoryComponent.class).createFailure(
                    PolicyFailureType.Authentication, KEY_NOT_PROVIDED, config.getErrorMessage()));
        }
    }
}
