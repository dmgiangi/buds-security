package dev.dmgiangi.budssecurity.handlerChain;

import dev.dmgiangi.budssecurity.authorizations.StaticResourcesAuthorizationSetting;
import dev.dmgiangi.budssecurity.authorizations.annotations.Public;
import dev.dmgiangi.budssecurity.securitycontext.SecurityContext;
import dev.dmgiangi.budssecurity.utilities.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * IsAuthRequiredInterceptor gets from the spring context the method handler that should handle the request
 * and checks if this method is annotated with @Public.
 * At this point 2 attributes are added to the request:
 * 1. boolean isAuthRequired (for that method)
 * 2. an instance of the method handler
 *
 * @author Gianluigi De Marco
 * @version 0.1.2
 * @since 27 09 2022
 */
public class IsAuthenticationRequiredHandler implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(IsAuthenticationRequiredHandler.class);

    private final StaticResourcesAuthorizationSetting staticResourcesAuthorizationSetting;

    /**
     * Constructor for IsAuthenticationRequiredHandler.
     *
     * @param staticResourcesAuthorizationSetting a {@link dev.dmgiangi.budssecurity.authorizations.StaticResourcesAuthorizationSetting} object
     */
    public IsAuthenticationRequiredHandler(StaticResourcesAuthorizationSetting staticResourcesAuthorizationSetting) {
        this.staticResourcesAuthorizationSetting = staticResourcesAuthorizationSetting;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object supposedHandler
    ) throws Exception {
        //Try to get the HandlerMethod injected by Spring
        Optional<HandlerMethod> requestMethodHandler = getRequestMethodHandler(supposedHandler);

        //determine handlerMethod is public if requested resource is a handler method
        if (requestMethodHandler.isPresent()) {
            //Check if the handler method need Authentication and
            boolean isAuthRequired = !isHandlerMethodPublic(requestMethodHandler.get());
            request.setAttribute(Constants.IS_AUTH_REQUIRED, isAuthRequired);
            request.setAttribute(Constants.HANDLER_METHOD, requestMethodHandler.get());

            return true;
        }

        //determine if exist a public static resource that match the request
        String path = request.getRequestURI().substring(
                request.getContextPath().length());

        boolean isAuthRequired = staticResourcesAuthorizationSetting
                .getPublicResourcesPath()
                .stream()
                .anyMatch(path::matches);

        request.setAttribute(Constants.IS_AUTH_REQUIRED, isAuthRequired);
        request.setAttribute(Constants.STATIC_RESOURCE, path);

        return true;
    }

    /**
     * @param handler HandlerMethod
     * @return true if HandlerMethod is annotated with @Public
     */
    private boolean isHandlerMethodPublic(HandlerMethod handler) {
        return handler.getMethod().isAnnotationPresent(Public.class);
    }

    /**
     * {@inheritDoc}
     * <p>
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

    /**
     * Try to cast Object supposedHandler to an instance of Handler method.
     * if supposedHandler is null or can not be cast this method return null
     *
     * @param supposedHandler an instance of the handler method injected by Spring
     *                        or null if not exist a HandlerMethod for this request
     * @return an instance of HandlerMethod
     */
    private Optional<HandlerMethod> getRequestMethodHandler(Object supposedHandler) {
        HandlerMethod handlerMethod = null;
        try {
            handlerMethod = (HandlerMethod) supposedHandler;
        } catch (Exception e) {
            log.debug("Cannot determine handler Method", e);
        }
        return Optional.ofNullable(handlerMethod);
    }
}
