package dev.dmgiangi.budssecurity.securitycontext;

import dev.dmgiangi.budssecurity.securitycontext.identifiers.MainIdentifier;

import java.util.Collection;
// TODO: 27/09/22 document how to override the DefaultSecurityUser

/**
 * DefaultSecurityUser is an implementation of SecurityUser used by default in the framework.
 * It can be overridden by
 *
 * @author Gianluigi De Marco
 * @version 0.1.1
 * @since 22 09 2022
 */
public class DefaultSecurityUser implements SecurityUser {
    private MainIdentifier mainIdentifier;
    private String password;
    private Collection<String> authorities;
    private Collection<String> identifiers;
    private boolean accountNotExpired;
    private boolean accountNotLocked;
    private boolean credentialsNonExpired;
    private boolean verified;

    /**
     * Instantiates a new Default security user.
     *
     * @param mainIdentifier        the main identifier
     * @param password              the password
     * @param authorities           the authorities
     * @param identifiers           useful identifiers
     * @param accountNotExpired     is account not expired
     * @param accountNotLocked      is account not locked
     * @param credentialsNonExpired the credentials non expired
     * @param verified              the verified
     */
    public DefaultSecurityUser(
            MainIdentifier mainIdentifier,
            String password,
            Collection<String> authorities,
            Collection<String> identifiers,
            boolean accountNotExpired,
            boolean accountNotLocked,
            boolean credentialsNonExpired,
            boolean verified) {
        this.mainIdentifier = mainIdentifier;
        this.password = password;
        this.authorities = authorities;
        this.identifiers = identifiers;
        this.accountNotExpired = accountNotExpired;
        this.accountNotLocked = accountNotLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.verified = verified;
    }

    /**
     * Instantiates a new Default security user.
     */
    public DefaultSecurityUser() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MainIdentifier getMainIdentifier() {
        return mainIdentifier;
    }

    /** {@inheritDoc} */
    @Override
    public String getPassword() {
        return password;
    }

    /** {@inheritDoc} */
    @Override
    public Collection<String> getAuthorities() {
        return authorities;
    }

    /** {@inheritDoc} */
    @Override
    public Collection<String> getIdentifiers() {
        return identifiers;
    }

    /** {@inheritDoc} */
    @Override
    public boolean isAccountNotExpired() {
        return accountNotExpired;
    }

    /** {@inheritDoc} */
    @Override
    public boolean isAccountNotLocked() {
        return accountNotLocked;
    }

    /** {@inheritDoc} */
    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    /** {@inheritDoc} */
    @Override
    public boolean isVerified() {
        return verified;
    }
}
