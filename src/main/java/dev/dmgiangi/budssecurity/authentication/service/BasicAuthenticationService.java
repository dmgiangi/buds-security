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
 * class
 *
 * @author Gianluigi De Marco
 * @version x
 * @since 28 09 2022
 */
public class BasicAuthenticationService implements AuthenticationService {
    private final SecurityUserProvider securityUserProvider;

    public BasicAuthenticationService(SecurityUserProvider securityUserProvider) {
        this.securityUserProvider = securityUserProvider;
    }

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
