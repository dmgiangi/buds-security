package dev.dmgiangi.budssecurity.handlerChain;

import dev.dmgiangi.budssecurity.mock.TestController;
import dev.dmgiangi.budssecurity.securitycontext.DefaultSecurityUser;
import dev.dmgiangi.budssecurity.securitycontext.SecurityContext;
import dev.dmgiangi.budssecurity.utilities.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit5 Test IsAuthenticationRequiredHandler.java
 *
 * @author Gianluigi De Marco
 * @since 27 09 2022
 */
class IsAuthenticationRequiredHandlerTest {
    IsAuthenticationRequiredHandler isAuthenticationRequired;

    MockHttpServletRequest request;
    MockHttpServletResponse response;
    HandlerMethod handler;

    @BeforeEach
    void setUp() {
        isAuthenticationRequired = new IsAuthenticationRequiredHandler();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    @Test
    void preHandleWithPublicMethod() {
        assertDoesNotThrow(() ->
                        handler = new HandlerMethod(
                                new TestController(),
                                TestController.class.getMethod("publicMethod")
                        ),
                "Method handler mocking should not throws an exception"
        );

        assertDoesNotThrow(() ->
                        assertTrue(
                                isAuthenticationRequired.preHandle(request, response, handler),
                                "preHandle on existing endpoint should end with true"
                        ),
                "should not throws an exception"
        );

        assertFalse(
                (boolean) request.getAttribute(Constants.IS_AUTH_REQUIRED),
                "IsAuthRequiredAttributes should be false on public method"
        );


        assertEquals(
                request.getAttribute(Constants.HANDLER_METHOD),
                handler,
                "starting end ending handler Method should be equals"
        );
    }

    @Test
    void preHandleWithoutPublicMethod() {
        assertDoesNotThrow(() ->
                        handler = new HandlerMethod(
                                new TestController(),
                                TestController.class.getMethod("privateMethod")
                        ),
                "Method handler mocking should not throws an exception"
        );

        assertDoesNotThrow(() ->
                        assertTrue(
                                isAuthenticationRequired.preHandle(request, response, handler),
                                "preHandle on existing endpoint should end with true"
                        ),
                "should not throws an exception"
        );

        assertTrue(
                (boolean) request.getAttribute(Constants.IS_AUTH_REQUIRED),
                "IsAuthRequiredAttributes should be true ono private method"
        );


        assertEquals(
                request.getAttribute(Constants.HANDLER_METHOD),
                handler,
                "starting end ending handler Method should be equals"
        );
    }

    @Test
    void preHandleOnUndefinedHandlerMethod() {

        handler = null;

        assertDoesNotThrow(() ->
                        assertFalse(
                                isAuthenticationRequired.preHandle(request, response, handler),
                                "preHandle on undefined endpoint should end with false"
                        ),
                "should not throws an exception"
        );

        assertEquals(
                response.getStatus(),
                404,
                "Response status should be 404 on undefined endpoint"
        );
    }

    @Test
    void postHandle() {
        ModelAndView modelAndView = Mockito.mock(ModelAndView.class);
        SecurityContext.setUser(new DefaultSecurityUser());

        assertDoesNotThrow(
                () -> isAuthenticationRequired.postHandle(request, response, handler, modelAndView),
                "postHandle have no reason to throw an exception."
        );

        assertEquals(
                SecurityContext.getUser(),
                Optional.empty(),
                "SecurityUser should be null after postHandle");
    }
}