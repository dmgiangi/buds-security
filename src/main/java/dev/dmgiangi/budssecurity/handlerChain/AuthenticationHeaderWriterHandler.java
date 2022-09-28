package dev.dmgiangi.budssecurity.handlerChain;

import dev.dmgiangi.budssecurity.authentication.events.AuthenticationEvent;
import dev.dmgiangi.budssecurity.securitycontext.SecurityContext;
import dev.dmgiangi.budssecurity.utilities.Constants;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * AuthenticationHeaderWriterHandler set the response header
 *
 * @author Gianluigi De Marco
 * @version 0.1
 * @since 18 09 2022
 */
public class AuthenticationHeaderWriterHandler implements HandlerInterceptor {
    /**
     * {@inheritDoc}
     *
     * Set the header of the response by taking them from the
     * AuthenticationEvent attribute of the response (if it exist).
     */
    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {
        AuthenticationEvent auth = (AuthenticationEvent) request.getAttribute(Constants.AUTHENTICATION_ATTRIBUTE);

        if (auth == null) return true;

        auth.getAuthenticationResponseHeader().forEach(response::addHeader);

        return true;
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
