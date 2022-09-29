package dev.dmgiangi.budssecurity.securitycontext.identifiers;

import java.io.Serializable;

/**
 * MainIdentifier allow to use an unknown type as main identifier of a SecurityUser
 *
 * @author Gianluigi De Marco
 * @version 0.1.1
 * @since 28 09 2022
 */
public interface MainIdentifier extends Serializable {
    /**
     * compare To another MainIdentifier
     *
     * @param other a {@link dev.dmgiangi.budssecurity.securitycontext.identifiers.MainIdentifier} object
     * @return a boolean
     */
    boolean compareTo(MainIdentifier other);

    /**
     * mainIdentifierAsString.
     *
     * @return a {@link java.lang.String} object
     */
    String mainIdentifierAsString();
}
