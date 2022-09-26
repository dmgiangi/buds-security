package dev.dmgiangi.budssecurity.securitycontext;

import java.util.Collection;

/**
 * DefaultSecurityUser is an implementation of SecurityUser used by default in the framework.
 * It can be
 *
 * @author Gianluigi De Marco
 * @version 0.1
 * @since 22 09 2022
 */
public class DefaultSecurityUser implements SecurityUser {
    private String mainIdentifier;
    private String password;
    private Collection<String> authorities;
    private Collection<String> identifiers;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean verified;

    public DefaultSecurityUser(
            String mainIdentifier,
            String password,
            Collection<String> authorities,
            Collection<String> identifiers,
            boolean accountNonExpired,
            boolean accountNonLocked,
            boolean credentialsNonExpired,
            boolean verified) {
        this.mainIdentifier = mainIdentifier;
        this.password = password;
        this.authorities = authorities;
        this.identifiers = identifiers;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.verified = verified;
    }

    public DefaultSecurityUser() {
    }

    @Override
    public String getMainIdentifier() {
        return mainIdentifier;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<String> getAuthorities() {
        return authorities;
    }

    @Override
    public Collection<String> getIdentifiers() {
        return identifiers;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isVerified() {
        return verified;
    }
}