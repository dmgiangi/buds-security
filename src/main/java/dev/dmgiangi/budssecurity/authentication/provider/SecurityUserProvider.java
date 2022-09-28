package dev.dmgiangi.budssecurity.authentication.provider;

import dev.dmgiangi.budssecurity.securitycontext.SecurityUser;

/**
 * SecurityUserProvider provides a SecurityUser given an identifier
 *
 * @author Gianluigi De Marco
 * @version x
 * @since 28 09 2022
 */
public interface SecurityUserProvider {
    /**
     * Find a SecurityUser given an identifier.
     *
     * @param identifier a {@link java.lang.String} object
     * @return a {@link dev.dmgiangi.budssecurity.securitycontext.SecurityUser} object
     */
    SecurityUser<?> findUserByIdentifier(String identifier);
}
