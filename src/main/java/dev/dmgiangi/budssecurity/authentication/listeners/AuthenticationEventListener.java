package dev.dmgiangi.budssecurity.authentication.listeners;

import dev.dmgiangi.budssecurity.authentication.events.AuthenticationEvent;

/**
 * AuthenticationEventListener adds information to the header map of the AuthenticationEvent
 *
 * @author Gianluigi De Marco
 * @version 0.1
 * @since 27 09 2022
 */
public interface AuthenticationEventListener {
    void AuthenticationDone(AuthenticationEvent authenticationEvent);
}
