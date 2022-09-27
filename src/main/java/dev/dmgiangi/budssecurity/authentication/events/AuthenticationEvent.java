package dev.dmgiangi.budssecurity.authentication.events;

import java.util.Map;

/**
 * The AuthenticationEvent Hold a final instance of SecurityUser
 * and a map with header that will be added in the response
 *
 * @author Gianluigi De Marco
 * @version 0.1
 * @since 27 09 2022
 */
public interface AuthenticationEvent {
    Map<String,String> getResponseHeader();
}
