package dev.dmgiangi.budssecurity.securitycontext;

import java.io.Serializable;
import java.util.Collection;

/**
 * SecurityUser is a data transfer object that carry information about the user
 * and its authorities through the application layer
 *
 * @author Gianluigi De Marco
 * @version 0.1
 * @since 19 09 2022
 */
public interface SecurityUser<T> extends Serializable {
    /**
     * Gets main identifier usually the id of the user
     *
     * @return the main identifier
     */
    T getMainIdentifier();

    /**
     * Gets password of the user
     *
     * @return the password
     */
    String getPassword();

    /**
     * Gets authorities
     *
     * @return the authorities
     */
    Collection<String> getAuthorities();

    /**
     * Gets identifiers.
     * This collections usually contains unique attributes of the user
     * ex. username, email
     *
     * @return the identifiers
     */
    Collection<String> getIdentifiers();

    /**
     * Is account non expired boolean.
     *
     * @return the boolean
     */
    boolean isAccountNotExpired();

    /**
     * Is account not locked boolean.
     *
     * @return the boolean
     */
    boolean isAccountNotLocked();

    /**
     * Is credentials non expired boolean.
     *
     * @return the boolean
     */
    boolean isCredentialsNonExpired();

    /**
     * Is verified boolean.
     *
     * @return the boolean
     */
    boolean isVerified();

    /**
     * Compare MainIdentifier with main identifier of another SecurityUser
     *
     * @param otherElement a {@link java.lang.Object} object
     * @return a boolean
     */
    default boolean compareMainIdentifierWith(Object otherElement) {
        if (otherElement instanceof SecurityUser)
            return this.getMainIdentifier().equals(otherElement);
        else
            return false;
    }
}
