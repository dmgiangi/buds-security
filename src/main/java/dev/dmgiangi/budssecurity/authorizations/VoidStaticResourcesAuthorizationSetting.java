package dev.dmgiangi.budssecurity.authorizations;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Implements StaticResourcesAuthorizationSetting that return empty list
 *
 * @author Gianluigi De Marco
 * @version 0.1.2
 * @since 03 10 2022
 */
public class VoidStaticResourcesAuthorizationSetting implements StaticResourcesAuthorizationSetting {
    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getPublicResourcesPath() {
        return Collections.emptyList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, List<String>> getProtectedResourcesNeededAuthorization() {
        return Collections.emptyMap();
    }
}
