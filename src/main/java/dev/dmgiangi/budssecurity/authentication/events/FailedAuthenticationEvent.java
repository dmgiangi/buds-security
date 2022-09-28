package dev.dmgiangi.budssecurity.authentication.events;

import dev.dmgiangi.budssecurity.securitycontext.SecurityUser;

import java.util.Map;

/**
 * AuthenticationFailedEvent represent a failed Authentication
 *
 * @author Gianluigi De Marco
 * @version 0.1
 * @since 27 09 2022
 */
public record FailedAuthenticationEvent(SecurityUser<?> user) implements AuthenticationEvent {
    /**
     * Constructor for AuthenticationFailedEvent.
     *
     * @param user a {@link SecurityUser}
     */
    public FailedAuthenticationEvent {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SecurityUser<?> user() {
        return user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, String> getAuthenticationResponseHeader() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAuthenticated() {
        return false;
    }
}
