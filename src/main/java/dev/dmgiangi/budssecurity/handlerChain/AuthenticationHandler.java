package dev.dmgiangi.budssecurity.handlerChain;

import dev.dmgiangi.budssecurity.authentication.AuthenticationManager;
import dev.dmgiangi.budssecurity.securitycontext.SecurityContext;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * AuthenticationHandler try to authenticate request through AuthenticationManager
 *
 * @author Gianluigi De Marco
 * @version 0.1.1
 * @since 28 09 2022
 */
public class AuthenticationHandler implements HandlerInterceptor {
    private final AuthenticationManager authenticationManager;

    /**
     * <p>Constructor for AuthenticationHandler.</p>
     *
     * @param authenticationManager a {@link dev.dmgiangi.budssecurity.authentication.AuthenticationManager} object
     */
    public AuthenticationHandler(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        authenticationManager.authenticate(request);
        return true;
    }

    /**
     * {@inheritDoc}
     * <p>
     * remove the user from securityContext
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        SecurityContext.removeUser();
    }
}
