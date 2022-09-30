package dev.dmgiangi.budssecurity.authentication.events;

import dev.dmgiangi.budssecurity.securitycontext.SecurityUser;

import java.util.HashMap;
import java.util.Map;

/**
 * AuthenticationFailedEvent represent a failed Authentication
 *
 * @author Gianluigi De Marco
 * @version 0.1.2
 * @since 27 09 2022
 */
public class FailedAuthenticationEvent implements AuthenticationEvent {
    Map<String, String> authenticationResponseHeader = new HashMap<>();
    SecurityUser user;

    /**
     * Constructor for AuthenticationFailedEvent.
     *
     * @param user a {@link dev.dmgiangi.budssecurity.securitycontext.SecurityUser}
     */
    public FailedAuthenticationEvent(SecurityUser user) {
        this.user = user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SecurityUser getUser() {
        return user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, String> getAuthenticationResponseHeader() {
        return authenticationResponseHeader;
    }

    /** {@inheritDoc} */
    @Override
    public boolean isAuthenticated() {
        return false;
    }
}
