package dev.dmgiangi.budssecurity.utilities;

/**
 * This class provides constant used in buds security in order to obtain cleaner code
 *
 * @author Gianluigi De Marco
 * @version 0.1
 * @since 19 09 2022
 */
public class Constants {
    //Authentication Process constants
    public static final String IS_AUTH_REQUIRED = "is-auth-required";
    public static final String HANDLER_METHOD = "Handler-Method";


    public static final String WWW_AUTHENTICATE = "WWW-Authenticate";
    public static final String AUTHENTICATION_ATTRIBUTE = "Authentication";
    public static final String JWT_USER_CLAIM = "user";
    public static final String JWT_ID_CLAIM = "Id";
    public static final String AUTHENTICATION_HEADER = "Authorization";
    public static final String BEARER = "Bearer ";
    public static final String BASIC = "Basic ";
    public static final String REFRESH = "Refresh ";
    public static final String REFRESH_HEADER = "Authentication-refresh";
    public static final String BEARER_HEADER = "Authentication-bearer";
    public static final String HEADERS_FOR_RESPONSE = "response-header";
}
