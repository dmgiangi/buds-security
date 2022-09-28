package dev.dmgiangi.budssecurity.authentication.provider.mock;

import dev.dmgiangi.budssecurity.authentication.provider.SecurityUserProvider;
import dev.dmgiangi.budssecurity.securitycontext.DefaultSecurityUser;
import dev.dmgiangi.budssecurity.securitycontext.SecurityUser;
import dev.dmgiangi.budssecurity.securitycontext.identifiers.LongMainIdentifier;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Set;

/**
 * MockSecurityUserProvider mock SecurityUserProvider.
 * there is a unique SecurityUser that is returner if given identifier
 * matches identifiers
 * The single user data:
 * MainIdentifier: new LongMainIdentifier(1L)
 * password: password
 * roles: [USER, ADMIN]
 * identifiers: [user, user@user.com]
 * accountNotExpired: true
 * accountNotLocked: true
 * credentialNotExpired: true
 * verified: true
 *
 * @author Gianluigi De Marco
 * @version 0.1
 * @since 28 09 2022
 */
public class MockSecurityUserProvider implements SecurityUserProvider {
    private static final SecurityUser securityUser = new DefaultSecurityUser(
            new LongMainIdentifier(1L),
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
    public SecurityUser findUserByIdentifier(String identifier) {
        boolean userMatch = securityUser
                .getIdentifiers()
                .stream()
                .anyMatch(id -> id.equals(identifier));

        return userMatch
                ? securityUser
                : null;
    }

    /**
     * Return the instance of SecurityUser present in this mock Service
     * This method as this class is intended only for testing
     *
     * @return a SecurityUser object
     */
    public SecurityUser getMockedUser() {
        return MockSecurityUserProvider.securityUser;
    }
}
