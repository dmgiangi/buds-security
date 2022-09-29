package dev.dmgiangi.budssecurity.utilities;

import javax.servlet.http.HttpServletResponse;

/**
 * This class provide static method to manipulate HttpServletResponse and HttpServletResponse
 * in order to obtain cleaner code
 *
 * @author Gianluigi De Marco
 * @version 0.1.1
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
}
