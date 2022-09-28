package dev.dmgiangi.budssecurity.authentication.provider;

import dev.dmgiangi.budssecurity.securitycontext.SecurityUser;

/**
 * class
 *
 * @author Gianluigi De Marco
 * @version x
 * @since 28 09 2022
 */
public interface SecurityUserProvider {
    SecurityUser<?> findUserByIdentifier(String identifier);
}
