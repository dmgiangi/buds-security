package dev.dmgiangi.budssecurity.handlerChain;

import dev.dmgiangi.budssecurity.authorizations.annotations.Public;
import dev.dmgiangi.budssecurity.securitycontext.SecurityContext;
import dev.dmgiangi.budssecurity.utilities.AuthUtils;
import dev.dmgiangi.budssecurity.utilities.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * IsAuthRequiredInterceptor gets from the spring context the method handler that should handle the request
 * and checks if this method is annotated with @Public.
 * At this point 2 attributes are added to the request:
 * 1. boolean isAuthRequired (for that method)
 * 2. an instance of the method handler
 *
 * @author Gianluigi De Marco
 * @version 0.2
 * @since 27 09 2022
 */
public class IsAuthenticationRequiredHandler implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(IsAuthenticationRequiredHandler.class);

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object supposedHandler
    ) throws Exception {
        //Get the HandlerMethod injected by Spring
        HandlerMethod requestMethodHandler = getRequestMethodHandler(supposedHandler);

        //if no method cannot be found a response with 404 http status is Returned
        if (requestMethodHandler == null) {
            AuthUtils.setNotFoundOn(response);
            return false;
        }

        //Check if the handler method need Authentication and
        boolean isAuthRequired = !isTheEndpointPublic(requestMethodHandler);
        request.setAttribute(Constants.IS_AUTH_REQUIRED, isAuthRequired);
        request.setAttribute(Constants.HANDLER_METHOD, requestMethodHandler);

        return true;
    }


    /**
     * @param handler HandlerMethod
     * @return true if HandlerMethod is annotated with @Public
     */
    private boolean isTheEndpointPublic(HandlerMethod handler) {
        return handler.getMethod().isAnnotationPresent(Public.class);
    }

    /**
     * Try to cast Object supposedHandler to an instance of Handler method.
     * if supposedHandler is null or can not be cast this method return null
     *
     * @param supposedHandler an instance of the handler method injected by Spring
     *                        or null if not exist a HandlerMethod for this request
     * @return an instance of HandlerMethod
     */
    private HandlerMethod getRequestMethodHandler(Object supposedHandler) {
        HandlerMethod handlerMethod = null;
        try {
            handlerMethod = (HandlerMethod) supposedHandler;
        } catch (Exception e) {
            log.error("Cannot determine handler Method", e);
        }
        return handlerMethod;
    }

    /**
     * remove the user from securityContext
     */
    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView) throws Exception {
        SecurityContext.removeUser();
    }
}
