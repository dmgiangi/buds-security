package dev.dmgiangi.budssecurity.authentication.service;

import dev.dmgiangi.budssecurity.authentication.events.AuthenticationEvent;
import dev.dmgiangi.budssecurity.authentication.events.BasicAuthenticationEvent;
import dev.dmgiangi.budssecurity.authentication.events.NoAuthenticationEvent;
import dev.dmgiangi.budssecurity.authentication.provider.mock.MockSecurityUserProvider;
import dev.dmgiangi.budssecurity.utilities.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

/**
 * BasicAuthenticationService Test
 *
 * @author Gianluigi De Marco
 * @version 0.1
 * @since 28 09 2022
 */
class BasicAuthenticationServiceTest {
    private final MockSecurityUserProvider securityUserProvider = new MockSecurityUserProvider();
    private AuthenticationService basicAuthenticationService;
    private MockHttpServletRequest request;

    @BeforeEach
    void setUp() {
        request = new MockHttpServletRequest();
        basicAuthenticationService = new BasicAuthenticationService(securityUserProvider);
    }

    @Test
    void authenticateRequestWithoutAuthenticationHeader() {
        AuthenticationEvent authentication = basicAuthenticationService.authenticate(request);
        assertNotNull(authentication, "Authentication should be not null");
        assertEquals(
                authentication.getClass(),
                NoAuthenticationEvent.class,
                "With no Basic Authorization header AuthenticationEvent should be of type NoAuthentication event"
        );
    }

    @Test
    void authenticateRequestWithWrongAuthenticationHeader() {
        request.addHeader(
                Constants.AUTHENTICATION_HEADER,
                "Basic " + Base64
                        .getEncoder()
                        .encodeToString("".getBytes(StandardCharsets.UTF_8))
        );

        AuthenticationEvent authentication = basicAuthenticationService.authenticate(request);

        assertNotNull(authentication, "Authentication should be not null");

        assertFalse(
                authentication.isAuthenticated(),
                "with no username and password authentication should be not authenticated");

        assertEquals(
                authentication.getClass(),
                NoAuthenticationEvent.class,
                "With no Basic Authorization header AuthenticationEvent should be of type NoAuthentication event"
        );
    }

    @Test
    void authenticateRequestWithRightAuthenticationHeader() {
        request.addHeader(
                Constants.AUTHENTICATION_HEADER,
                "Basic " + Base64
                        .getEncoder()
                        .encodeToString("user:password".getBytes(StandardCharsets.UTF_8))
        );

        AuthenticationEvent authentication = basicAuthenticationService.authenticate(request);

        assertNotNull(authentication, "Authentication should be not null");

        assertEquals(
                authentication.getClass(),
                BasicAuthenticationEvent.class,
                "With no Basic Authorization header AuthenticationEvent should be of type NoAuthentication event"
        );

        assertNotNull(authentication, "Authentication should be not null");

        assertTrue(authentication.isAuthenticated(), "Is authenticated should be true");

        assertEquals(
                authentication.getUser(),
                securityUserProvider.getMockedUser(),
                "SecurityUser should be the same of the mocked provider"
        );
    }
}