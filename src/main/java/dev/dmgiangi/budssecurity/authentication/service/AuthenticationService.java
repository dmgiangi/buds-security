package dev.dmgiangi.budssecurity.authentication.service;


import dev.dmgiangi.budssecurity.authentication.events.AuthenticationEvent;

import javax.servlet.http.HttpServletRequest;

/**
 * AuthenticationService through the autenticate(HttpServletRequest) try to authenticate the request.
 * if authentication is successful a AuthenticationEvent is returned.
 *
 * @author Gianluigi De Marco
 * @version 0.1
 * @since 27 09 2022
 */
public interface AuthenticationService {
    /**
     * Try to authenticate user with information present in the request
     *
     * @param request a {@link javax.servlet.http.HttpServletRequest}
     * @return a {@link dev.dmgiangi.budssecurity.authentication.events.AuthenticationEvent}
     */
    AuthenticationEvent authenticate(HttpServletRequest request);
}
