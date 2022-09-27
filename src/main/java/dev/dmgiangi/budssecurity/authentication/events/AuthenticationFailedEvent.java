package dev.dmgiangi.budssecurity.authentication.events;

import dev.dmgiangi.budssecurity.securitycontext.SecurityUser;

import java.util.Map;

/**
 * AuthenticationFailedEvent represent a failed Authentication
 *
 * @author Gianluigi De Marco
 * @version 0.1-SNAPSHOT
 * @since 27 09 2022
 */
public class AuthenticationFailedEvent implements AuthenticationEvent {
    private final SecurityUser user;

    /**
     * Constructor for AuthenticationFailedEvent.
     *
     * @param user a {@link dev.dmgiangi.budssecurity.securitycontext.SecurityUser}
     */
    public AuthenticationFailedEvent(SecurityUser user) {
        this.user = user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SecurityUser getUser() {
        return user;
    }

    /** {@inheritDoc} */
    @Override
    public Map<String, String> getAuthenticationResponseHeader() {
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public boolean isAuthenticated() {
        return false;
    }
}
