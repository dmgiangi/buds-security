package dev.dmgiangi.budssecurity.authentication;

import dev.dmgiangi.budssecurity.authentication.listeners.AuthenticationEventListener;
import dev.dmgiangi.budssecurity.authentication.service.AuthenticationService;

import java.util.List;

/**
 * AuthenticationManager try to authenticate a request through registered AuthenticationService
 * if an AuthenticationEvent occurs it is notified to all AuthenticationEventListeners.
 *
 * @author Gianluigi De Marco
 * @version 0.1
 * @since 26 09 2022
 */
public class AuthenticationManager {
    List<AuthenticationService> authenticationServices;
    List<AuthenticationEventListener> authenticationEventListeners;


}
