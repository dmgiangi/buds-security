package dev.dmgiangi.budssecurity.authentication.events;

import dev.dmgiangi.budssecurity.securitycontext.SecurityUser;

import java.util.HashMap;
import java.util.Map;

/**
 * BasicAuthenticationEvent represents a successful basic authentication
 *
 * @author Gianluigi De Marco
 * @version 0.1
 * @since 28 09 2022
 */
public class BasicAuthenticationEvent implements SuccessfulAuthenticationEvent {
    private final Map<String, String> authenticationResponseHeader = new HashMap<>();
    private final SecurityUser<?> securityUser;

    /**
     * Constructor for BasicAuthenticationEvent.
     *
     * @param securityUser a {@link dev.dmgiangi.budssecurity.securitycontext.SecurityUser} object
     */
    public BasicAuthenticationEvent(SecurityUser<?> securityUser) {
        this.securityUser = securityUser;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SecurityUser<?> user() {
        return securityUser;
    }

    /** {@inheritDoc} */
    @Override
    public Map<String, String> getAuthenticationResponseHeader() {
        return authenticationResponseHeader;
    }

    /** {@inheritDoc} */
    @Override
    public boolean isAuthenticated() {
        return true;
    }

    /** {@inheritDoc} */
    @Override
    public boolean isRefreshTokenRequired() {
        return true;
    }

    /** {@inheritDoc} */
    @Override
    public boolean isBearerTokenRequired() {
        return true;
    }
}
