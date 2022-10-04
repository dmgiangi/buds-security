package dev.dmgiangi.budssecurity.authorizations;

import java.util.List;
import java.util.Map;

/**
 * This class provide the authorization required in order to access to static resources
 *
 * @author Gianluigi De Marco
 * @version 0.1.2
 * @since 03 10 2022
 */
public interface StaticResourcesAuthorizationSetting {
    /**
     * return a List containing the path that are public
     *
     * @return a {@link java.util.List} object
     */
    List<String> getPublicResourcesPath();

    /**
     * Return a Map of String - List<String> where:
     * String is the path that require authorization
     * List<String> contains the roles that have access granted to that resources
     *
     * @return a {@link java.util.Map} object
     */
    Map<String, List<String>> getProtectedResourcesNeededAuthorization();
}
