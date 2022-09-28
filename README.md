# Buds Security

This project simply implement an authorization and authentication service in the spring context.
The core of the project is based on spring interceptor and on the use of ThreadLocal to permit controllers access to
user information.

# Getting Started

Write this sections

# HandlerChain

The handler chain use the Chain of Responsibility pattern to do a series of controls on the request
Authenticate the user and authorize it to access a specific MethodHandler.

## IsAuthRequired

The first interceptor gets from the spring context the method of the handler that should handle the request and checks
if this method is annotated as public.<br>
At this point 2 attributes are added to the request:

1. boolean isAuthRequired (I think it's self-explanatory)
2. an instance of the method handler that is used after in the chain

## AuthenticationManager

AuthenticationManager try to authenticate a request through registered AuthenticationService if an AuthenticationEvent
occurs it is notified to all AuthenticationEventListener

### AuthenticationService

AuthenticationService through the autenticate(HttpServletRequest) try to authenticate the request.
if authentication is successful a AuthenticationEvent is returned.

### AuthenticationEvent

AuthenticationEvent Holds a final instance of SecurityUser and a map with header that will be added in the response

### AuthenticationEventListener

AuthenticationEventListener adds information to the header map of the AuthenticationEvent

# Security Context

## SecurityContext

SecurityContext Hold an instance of SecurityUser for the duration of the request.
SecurityContext allow to access the authenticated user information for the duration of the request.

## SecurityUser

SecurityUser is an interface data transfer object that carry information about the user and its authorities through the
application
layer. Already exist a default implementations in the framework *
dev.dmgiangi.budssecurity.securitycontext.DefaultSecurityUser*

