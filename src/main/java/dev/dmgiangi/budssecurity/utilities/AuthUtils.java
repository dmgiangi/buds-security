package dev.dmgiangi.budssecurity.utilities;

import dev.dmgiangi.budssecurity.authentication.events.AuthenticationEvent;
import dev.dmgiangi.budssecurity.securitycontext.SecurityContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class provide static method to manipulate HttpServletResponse and HttpServletResponse
 * in order to obtain cleaner code
 *
 * @author Gianluigi De Marco
 * @version 0.1
 * @since 27 09 2022
 */
public class AuthUtils {
    /**
     * set NOT_FOUND status (404) in the response
     *
     * @param response a {@link javax.servlet.http.HttpServletResponse} object
     */
    public static void setNotFoundOn(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }

    /**
     * set the "WWW-Authenticate" header and set the http status as UNAUTHORIZED (401)
     *
     * @param response a {@link javax.servlet.http.HttpServletResponse} object
     */
    public static void setIsAuthenticationRequiredOn(HttpServletResponse response) {
        response.setHeader(Constants.WWW_AUTHENTICATE, "Basic realm='" + BudsConstants.realm() + "'");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }

    /**
     * add the AuthenticationEvent in the request and the user in the SecurityContext.
     *
     * @param request a {@link javax.servlet.http.HttpServletRequest} object
     * @param auth    a {@link dev.dmgiangi.budssecurity.authentication.events.AuthenticationEvent} object
     */
    public static void setSuccessfulAuthOn(HttpServletRequest request, AuthenticationEvent auth) {
        request.setAttribute(Constants.AUTHENTICATION_ATTRIBUTE, auth);
        SecurityContext.setUser(auth.user());
    }
}
