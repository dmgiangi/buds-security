package dev.dmgiangi.budssecurity.securitycontext;

import java.util.Optional;

/**
 * SecurityContext Hold an instance of SecurityUser for the duration of the request.
 * SecurityContext allow to access the authenticated user information for the duration of the request.
 *
 * @author Gianluigi De Marco
 * @version 0.1.1
 * @since 19 09 2022
 */
public class SecurityContext {
    private static final ThreadLocal<SecurityUser> threadLocal = new ThreadLocal<>();

    /**
     * get the SecurityUser.
     *
     * @return a {@link java.util.Optional} object
     */
    public static Optional<SecurityUser> getUser() {
        return Optional.ofNullable(SecurityContext.threadLocal.get());
    }

    /**
     * set the SecurityUser.
     *
     * @param securityUser a {@link dev.dmgiangi.budssecurity.securitycontext.SecurityUser} object
     */
    public static void setUser(SecurityUser securityUser) {
        SecurityContext.threadLocal.set(securityUser);
    }

    /**
     * remove the SecurityUser.
     */
    public static void removeUser() {
        threadLocal.remove();
    }
}
