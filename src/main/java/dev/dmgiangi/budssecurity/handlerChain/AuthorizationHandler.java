package dev.dmgiangi.budssecurity.handlerChain;

import dev.dmgiangi.budssecurity.authentication.events.AuthenticationEvent;
import dev.dmgiangi.budssecurity.authentication.events.SuccessfulAuthenticationEvent;
import dev.dmgiangi.budssecurity.securitycontext.SecurityContext;
import dev.dmgiangi.budssecurity.utilities.AuthUtils;
import dev.dmgiangi.budssecurity.utilities.Constants;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * AuthorizationHandler check if Security has the authorities
 * to continue till the controller
 *
 * @author Gianluigi De Marco
 * @version 0.1.1
 * @since 27 09 2022
 */
public class AuthorizationHandler implements HandlerInterceptor {
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {
        AuthenticationEvent auth = (AuthenticationEvent) request.getAttribute(Constants.AUTHENTICATION_ATTRIBUTE);
        Boolean isAuthRequired = (Boolean) request.getAttribute(Constants.IS_AUTH_REQUIRED);

        if (auth instanceof SuccessfulAuthenticationEvent)
            return true;

        AuthUtils.setIsAuthenticationRequiredOn(response);
        return false;
    }

    /**
     * {@inheritDoc}
     *
     * remove the user from securityContext
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        SecurityContext.removeUser();
    }
}
