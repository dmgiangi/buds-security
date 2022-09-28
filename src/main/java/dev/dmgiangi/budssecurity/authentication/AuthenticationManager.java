package dev.dmgiangi.budssecurity.authentication;

import dev.dmgiangi.budssecurity.authentication.events.AuthenticationEvent;
import dev.dmgiangi.budssecurity.authentication.events.FailedAuthenticationEvent;
import dev.dmgiangi.budssecurity.authentication.events.NoAuthenticationEvent;
import dev.dmgiangi.budssecurity.authentication.events.SuccessfulAuthenticationEvent;
import dev.dmgiangi.budssecurity.authentication.listeners.AuthenticationEventListener;
import dev.dmgiangi.budssecurity.authentication.service.AuthenticationService;
import dev.dmgiangi.budssecurity.securitycontext.SecurityContext;
import dev.dmgiangi.budssecurity.utilities.Constants;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Stream;

/**
 * AuthenticationManager try to authenticate a request through registered AuthenticationService
 * if an AuthenticationEvent occurs it is notified to all AuthenticationEventListeners.
 *
 * @author Gianluigi De Marco
 * @version 0.1
 * @since 26 09 2022
 */
public class AuthenticationManager {
    // TODO: 27/09/22 inject authentication services in modular way
    private final List<AuthenticationService> authenticationServices;
    // TODO: 27/09/22 inject authentication listeners in modular way
    private final List<AuthenticationEventListener> authenticationEventListeners;

    /**
     * Constructor for AuthenticationManager.
     *
     * @param authenticationServices       a {@link java.util.List}
     * @param authenticationEventListeners a {@link java.util.List}
     */
    public AuthenticationManager(
            List<AuthenticationService> authenticationServices,
            List<AuthenticationEventListener> authenticationEventListeners) {
        this.authenticationServices = authenticationServices;
        this.authenticationEventListeners = authenticationEventListeners;
    }

    /**
     * Try to authenticate user through the information present in the request
     * and the registered Authentication Services.
     *
     * @param request a {@link javax.servlet.http.HttpServletRequest}
     */
    public void authenticate(HttpServletRequest request) {

        Stream<AuthenticationEvent> authenticationEventStream =
                authenticationServices
                        .stream()
                        .map(service -> service.authenticate(request));

        AuthenticationEvent authentication = authenticationEventStream
                .filter(auth -> auth instanceof SuccessfulAuthenticationEvent)
                .findFirst()
                .orElse(authenticationEventStream
                        .filter(auth -> auth instanceof FailedAuthenticationEvent)
                        .findFirst()
                        .orElse(new NoAuthenticationEvent()));

        authenticationEventListeners
                .forEach(listener -> listener.AuthenticationDone(authentication));

        request.setAttribute(Constants.AUTHENTICATION_ATTRIBUTE, authentication);
        SecurityContext.setUser(authentication.user());
    }
}
