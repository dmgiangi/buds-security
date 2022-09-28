package dev.dmgiangi.budssecurity.utilities;

import dev.dmgiangi.budssecurity.models.BasicTicket;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * HeaderCodec decode header from a request to different form
 *
 * @author Gianluigi De Marco
 * @version x
 * @since 28 09 2022
 */
public class HeaderCodec {

    /**
     * getBasicTicketFrom.
     *
     * @param request a {@link javax.servlet.http.HttpServletRequest} object
     * @return a {@link dev.dmgiangi.budssecurity.models.BasicTicket} object
     */
    public static BasicTicket getBasicTicketFrom(HttpServletRequest request) {
        String token = request.getHeader(Constants.AUTHENTICATION_HEADER);

        if (token == null || !token.startsWith(Constants.BASIC))
            return null;

        token = token.replace("Basic ", "");

        token = new String(
                Base64.getDecoder().decode(token),
                StandardCharsets.UTF_8);

        String[] credential = token.split(":", 2);
        return credential.length == 2
                ? new BasicTicket(credential[0], credential[1], true)
                : new BasicTicket(credential[0], credential[1], false);
    }

    /**
     * getBearerTicketFrom.
     *
     * @param request a {@link javax.servlet.http.HttpServletRequest} object
     * @return a {@link java.lang.String} object
     */
    public static String getBearerTicketFrom(HttpServletRequest request) {
        String token = request.getHeader(Constants.AUTHENTICATION_HEADER);

        if (token == null || !token.startsWith(Constants.BEARER))
            return null;

        return token.replace(Constants.BEARER, "");
    }

    /**
     * getRefreshTicketFrom.
     *
     * @param request a {@link javax.servlet.http.HttpServletRequest} object
     * @return a {@link java.lang.String} object
     */
    public static String getRefreshTicketFrom(HttpServletRequest request) {
        String token = request.getHeader(Constants.AUTHENTICATION_HEADER);

        if (token == null || !token.startsWith(Constants.REFRESH))
            return null;

        return token.replace(Constants.REFRESH, "");
    }
}
