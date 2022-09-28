package dev.dmgiangi.budssecurity.authentication.service;

import dev.dmgiangi.budssecurity.authentication.events.AuthenticationEvent;
import dev.dmgiangi.budssecurity.authentication.events.BasicAuthenticationEvent;
import dev.dmgiangi.budssecurity.authentication.events.FailedAuthenticationEvent;
import dev.dmgiangi.budssecurity.authentication.events.NoAuthenticationEvent;
import dev.dmgiangi.budssecurity.authentication.provider.SecurityUserProvider;
import dev.dmgiangi.budssecurity.models.BasicTicket;
import dev.dmgiangi.budssecurity.utilities.HeaderCodec;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.http.HttpServletRequest;

/**
 * Basic Authentication service try to authenticate the user reading the header
 * Authorization with value base64(username:password)
 * check the given credential against a user retrieved with the SecurityUserProvider
 *
 * @author Gianluigi De Marco
 * @version 0.1
 * @since 28 09 2022
 */
public class BasicAuthenticationService implements AuthenticationService {
    private final SecurityUserProvider securityUserProvider;

    /**
     * Constructor for BasicAuthenticationService.
     *
     * @param securityUserProvider a {@link dev.dmgiangi.budssecurity.authentication.provider.SecurityUserProvider} object
     */
    public BasicAuthenticationService(SecurityUserProvider securityUserProvider) {
        this.securityUserProvider = securityUserProvider;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AuthenticationEvent authenticate(HttpServletRequest request) {
        //try to obtain username:password from request header and authenticate it
        BasicTicket basicTicket = HeaderCodec.getBasicTicketFrom(request);

        if (basicTicket == null || !basicTicket.isValidTicket())
            return new NoAuthenticationEvent();

        var user = securityUserProvider.findUserByIdentifier(basicTicket.username());

        return BCrypt.checkpw(
                basicTicket.Password(),
                user.getPassword()
        )
                ? new BasicAuthenticationEvent(user)
                : new FailedAuthenticationEvent(user);

    }
}
