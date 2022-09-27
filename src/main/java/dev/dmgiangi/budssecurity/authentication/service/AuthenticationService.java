package dev.dmgiangi.budssecurity.authentication.service;


import dev.dmgiangi.budssecurity.authentication.events.AuthenticationEvent;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * AuthenticationService through the autenticate(HttpServletRequest) try to authenticate the request.
 * if authentication is successful a AuthenticationEvent is returned.
 *
 * @author Gianluigi De Marco
 * @version 0.1
 * @since 27 09 2022
 */
public interface AuthenticationService {
    Optional<AuthenticationEvent> authenticate(HttpServletRequest request);
}
