package dev.dmgiangi.budssecurity.authentication.provider.mock;

import dev.dmgiangi.budssecurity.authentication.provider.SecurityUserProvider;
import dev.dmgiangi.budssecurity.securitycontext.DefaultSecurityUser;
import dev.dmgiangi.budssecurity.securitycontext.SecurityUser;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Set;

/**
 * MockSecurityUserProvider mock SecurityUserProvider.
 * there is a unique SecurityUser
 * with:
 * MainIdentifier: Long 1L
 * password: password
 * roles: [USER, ADMIN]
 * identifier: [user, user@user.com]
 * accountNotExpired: true
 * accountNotLocked: true
 * credentialNotExpired: true
 * verified: true
 *
 * @author Gianluigi De Marco
 * @version x
 * @since 28 09 2022
 */
public class MockSecurityUserProvider implements SecurityUserProvider {
    private static final SecurityUser<Long> securityUser = new DefaultSecurityUser<>(
            1L,
            BCrypt.hashpw("password", BCrypt.gensalt()),
            Set.of("USER", "ADMIN"),
            Set.of("user", "user@user.com"),
            true,
            true,
            true,
            true
    );

    /**
     * {@inheritDoc}
     */
    @Override
    public SecurityUser<Long> findUserByIdentifier(String identifier) {
        boolean userMatch = securityUser
                .getIdentifiers()
                .stream()
                .anyMatch(id -> id.equals(identifier));

        return userMatch
                ? securityUser
                : null;
    }
}
