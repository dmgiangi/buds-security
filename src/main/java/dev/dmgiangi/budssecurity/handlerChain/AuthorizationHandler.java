package dev.dmgiangi.budssecurity.handlerChain;

import dev.dmgiangi.budssecurity.authentication.events.AuthenticationEvent;
import dev.dmgiangi.budssecurity.securitycontext.SecurityContext;
import dev.dmgiangi.budssecurity.utilities.AuthUtils;
import dev.dmgiangi.budssecurity.utilities.Constants;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * desc
 *
 * @author Gianluigi De Marco
 * @version 0.1-SNAPSHOT
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

        if (auth == null && isAuthRequired) {
            AuthUtils.setIsAuthenticationRequiredOn(response);
            return false;
        }

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
