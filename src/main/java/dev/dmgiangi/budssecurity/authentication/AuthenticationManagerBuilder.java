package dev.dmgiangi.budssecurity.authentication;

import dev.dmgiangi.budssecurity.authentication.listeners.AuthenticationEventListener;
import dev.dmgiangi.budssecurity.authentication.service.AuthenticationService;

import java.util.ArrayList;
import java.util.List;

/**
 * AuthenticationManagerBuilder class.
 *
 * @author giangi
 * @version 0.1.1
 */
public class AuthenticationManagerBuilder {
    private final List<AuthenticationService> authenticationServices = new ArrayList<>();
    private final List<AuthenticationEventListener> authenticationEventListeners = new ArrayList<>();

    /**
     * register an AuthenticationService.
     *
     * @param authenticationService a {@link dev.dmgiangi.budssecurity.authentication.service.AuthenticationService}
     * @return a {@link dev.dmgiangi.budssecurity.authentication.AuthenticationManagerBuilder}
     */
    public AuthenticationManagerBuilder addAuthenticationService(
            AuthenticationService authenticationService) {
        this.authenticationServices.add(authenticationService);
        return this;
    }

    /**
     * register an AuthenticationEventListeners.
     *
     * @param authenticationEventListener a {@link dev.dmgiangi.budssecurity.authentication.listeners.AuthenticationEventListener}
     * @return a {@link dev.dmgiangi.budssecurity.authentication.AuthenticationManagerBuilder}
     */
    public AuthenticationManagerBuilder addAuthenticationEventListeners(
            AuthenticationEventListener authenticationEventListener) {
        this.authenticationEventListeners.add(authenticationEventListener);
        return this;
    }

    /**
     * build the AuthenticationManager.
     *
     * @return a {@link dev.dmgiangi.budssecurity.authentication.AuthenticationManager}
     */
    public AuthenticationManager build() {
        return new AuthenticationManager(authenticationServices, authenticationEventListeners);
    }
}
