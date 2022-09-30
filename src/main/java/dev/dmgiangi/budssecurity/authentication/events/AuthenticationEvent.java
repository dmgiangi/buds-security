package dev.dmgiangi.budssecurity.authentication.events;

import dev.dmgiangi.budssecurity.securitycontext.SecurityUser;

import java.util.Map;

/**
 * The AuthenticationEvent Hold a final instance of SecurityUser
 * and a map with header that will be added in the response
 *
 * @author Gianluigi De Marco
 * @version 0.1.2
 * @since 27 09 2022
 */
public interface AuthenticationEvent {
    /**
     * get a SecurityUser with information about authenticated user
     *
     * @return a {@link dev.dmgiangi.budssecurity.securitycontext.SecurityUser}
     */
    SecurityUser getUser();

    /**
     * get headers, inherent to authentication, that will be added to response
     *
     * @return a {@link java.util.Map} object
     */
    Map<String, String> getAuthenticationResponseHeader();

    /**
     * determine if the user isAuthenticated.
     *
     * @return a boolean
     */
    boolean isAuthenticated();

    /**
     * Return whether the refresh token should be added in the response
     *
     * @return a boolean, true if Refresh Token is needed in the response
     */
    default boolean isRefreshTokenRequired() {
        return false;
    }

    /**
     * Return whether the Bearer Token should be added in the response
     *
     * @return a boolean, true if Bearer Token is needed in the response
     */
    default boolean isBearerTokenRequired() {
        return false;
    }
}
