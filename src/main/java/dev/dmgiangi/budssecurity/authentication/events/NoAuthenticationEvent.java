package dev.dmgiangi.budssecurity.authentication.events;

import dev.dmgiangi.budssecurity.securitycontext.SecurityUser;

import java.util.HashMap;
import java.util.Map;

/**
 * NoAuthenticationEvent indicates that the user could not be authenticated through the request data
 *
 * @author Gianluigi De Marco
 * @version 0.1.2
 * @since 27 09 2022
 */
public class NoAuthenticationEvent implements AuthenticationEvent {
    private final Map<String, String> authenticationResponseHeade =
            new HashMap<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public SecurityUser getUser() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, String> getAuthenticationResponseHeader() {
        return authenticationResponseHeade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAuthenticated() {
        return false;
    }
}
