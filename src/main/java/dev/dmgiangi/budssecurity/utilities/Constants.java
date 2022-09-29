package dev.dmgiangi.budssecurity.utilities;

/**
 * This class provides constant used in buds security in order to obtain cleaner code
 *
 * @author Gianluigi De Marco
 * @version 0.1.1
 * @since 19 09 2022
 */
public class Constants {
    //Authentication Process constants
    /**
     * Constant <code>IS_AUTH_REQUIRED="is-auth-required"</code>
     */
    public static final String IS_AUTH_REQUIRED = "is-auth-required";
    /**
     * Constant <code>HANDLER_METHOD="Handler-Method"</code>
     */
    public static final String HANDLER_METHOD = "Handler-Method";


    /**
     * Constant <code>WWW_AUTHENTICATE="WWW-Authenticate"</code>
     */
    public static final String WWW_AUTHENTICATE = "WWW-Authenticate";
    /**
     * Constant <code>AUTHENTICATION_ATTRIBUTE="Authentication"</code>
     */
    public static final String AUTHENTICATION_ATTRIBUTE = "Authentication";
    /**
     * Constant <code>JWT_USER_CLAIM="user"</code>
     */
    public static final String JWT_USER_CLAIM = "user";
    /**
     * Constant <code>JWT_ID_CLAIM="Id"</code>
     */
    public static final String JWT_ID_CLAIM = "Id";
    /**
     * Constant <code>AUTHENTICATION_HEADER="Authorization"</code>
     */
    public static final String AUTHENTICATION_HEADER = "Authorization";
    /**
     * Constant <code>BEARER="Bearer "</code>
     */
    public static final String BEARER = "Bearer ";
    /**
     * Constant <code>BASIC="Basic "</code>
     */
    public static final String BASIC = "Basic ";
    /**
     * Constant <code>REFRESH="Refresh "</code>
     */
    public static final String REFRESH = "Refresh ";
    /**
     * Constant <code>REFRESH_HEADER="Authentication-refresh"</code>
     */
    public static final String REFRESH_HEADER = "Authentication-refresh";
    /**
     * Constant <code>BEARER_HEADER="Authentication-bearer"</code>
     */
    public static final String BEARER_HEADER = "Authentication-bearer";
    /**
     * Constant <code>HEADERS_FOR_RESPONSE="response-header"</code>
     */
    public static final String HEADERS_FOR_RESPONSE = "response-header";
}
