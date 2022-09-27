package dev.dmgiangi.budssecurity.authentication;

import dev.dmgiangi.budssecurity.authentication.events.NoAuthenticationEvent;
import dev.dmgiangi.budssecurity.securitycontext.SecurityContext;
import dev.dmgiangi.budssecurity.utilities.Constants;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit5 Test Class.java.java
 *
 * @author Gianluigi De Marco
 * @since 27 09 2022
 */
class AuthenticationManagerTest {

    @Test
    void requestWithoutAuthentication() {
        AuthenticationManager authenticationManager = new AuthenticationManagerBuilder().build();

        MockHttpServletRequest request = new MockHttpServletRequest();

        authenticationManager.authenticate(request);
        Object authentication = request.getAttribute(Constants.AUTHENTICATION_ATTRIBUTE);

        assertEquals(
                authentication.getClass(),
                NoAuthenticationEvent.class,
                "Request without authentication information should be of type NoAuthenticationEvent.class");
        assertEquals(
                SecurityContext.getUser(),
                Optional.empty(),
                "NoAuthenticationEvent is incoherent with user in SecurityContext");
    }

    @Test
    void requestWithWrongCredential(){

    }
}