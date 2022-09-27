package dev.dmgiangi.budssecurity.utilities;

import javax.servlet.http.HttpServletResponse;

/**
 * This class provide static method to manipulate HttpServletResponse and HttpServletResponse
 * in order to obtain cleaner code
 *
 * @author Gianluigi De Marco
 * @version 0.2
 * @since 27 09 2022
 */
public class AuthUtils {
    public static void setNotFoundOn(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }
}
