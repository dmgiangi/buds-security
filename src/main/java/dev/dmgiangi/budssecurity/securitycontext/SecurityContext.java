package dev.dmgiangi.budssecurity.securitycontext;

import java.util.Optional;

/**
 * SecurityContext Hold an instance of SecurityUser for the duration of the request.
 * SecurityContext allow to access the authenticated user information for the duration of the request.
 *
 * @author Gianluigi De Marco
 * @version 0.1.2
 * @since 19 09 2022
 */
public class SecurityContext {
    private static final ThreadLocal<SecurityUser> threadLocal = new ThreadLocal<>();

    /**
     * get the SecurityUser.
     *
     * @param securityUserConcreteClass a {@link java.lang.Class} that extends {@link SecurityUser} object
     * @param <T>                       a T class
     * @return a {@link java.util.Optional} object
     */
    public static <T extends SecurityUser> Optional<T> getUser(Class<T> securityUserConcreteClass) {
        return SecurityContext.threadLocal.get() != null && SecurityContext.threadLocal.get().getClass().equals(securityUserConcreteClass)
                ? Optional.ofNullable(
                securityUserConcreteClass
                        .cast(
                                SecurityContext.threadLocal.get()))
                : Optional.empty();
    }

    /**
     * getUser.
     *
     * @return a {@link java.util.Optional}<{@link SecurityUser}> object
     */
    public static Optional<SecurityUser> getUser() {
        return Optional.ofNullable(SecurityContext.threadLocal.get());
    }

    /**
     * isUserAuthenticated.
     *
     * @return a boolean
     */
    public static boolean isUserAuthenticated() {
        return threadLocal.get() != null;
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
