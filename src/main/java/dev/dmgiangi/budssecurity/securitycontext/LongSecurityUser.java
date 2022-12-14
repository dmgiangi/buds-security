package dev.dmgiangi.budssecurity.securitycontext;

import java.util.Collection;

/**
 * DefaultSecurityUser is an implementation of SecurityUser used by default in the framework.
 * It can be overridden by
 *
 * @author Gianluigi De Marco
 * @version 0.1.2
 * @since 22 09 2022
 */
public class LongSecurityUser implements SecurityUser {
    private Long mainIdentifier;
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
    public LongSecurityUser(
            Long mainIdentifier,
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
    public LongSecurityUser() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMainIdentifierAsString() {
        return mainIdentifier.toString();
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

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isVerified() {
        return verified;
    }

    /**
     * <p>Getter for the field <code>mainIdentifier</code>.</p>
     *
     * @return a {@link java.lang.Long} object
     */
    public Long getMainIdentifier() {
        return mainIdentifier;
    }
}
