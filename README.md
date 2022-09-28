# BUDS SECURITY

# How to use

Use of Buds security is very simple.\
Import the maven dependency:

```xml
<!-- the package is already available here: https://repo1.maven.org/maven2/ -->
<!-- Searching it on mvnrepository or mvncentral could take some days-->
<dependency>
    <groupId>dev.dmgiangi</groupId>
    <artifactId>buds-security</artifactId>
    <version>0.1</version>
</dependency>
```

and this annotation on a spring @Configuration class

```java
@Import(BudsSecurityConfiguration.class)
```

Now by default all MethodHandler need authentication to be accesed.\
You can create public endpoint adding the annotation

```java
@Public
```

On every method you need to be accessed without authentication.

The authentication proceeds in the same way also on public endpoint so if a user is authenticated you can access
information about that user simply invoking the SecurityContext

```java
Optional<SecurityUser> securityUser=SecurityContext.getUser();
```

_**Caution -> on public endpoint if the user has not authenticated the Optional is empty**_

# Customize buds security

## SecurityUserProvider

Most of the module of Buds Security can be overridden simply creating a Bean of that type.

The best start point in order to obtain the capabilities of authenticate your user is to implements SecurityUserProvider
interface.

```java
public interface SecurityUserProvider {
    SecurityUser findUserByIdentifier(String identifier);
}
```

Usually accessing you user repository and mapping your User To SecurityUser is just enough.
SecurityUser is an interface but there is already an implementation that should be sufficient in most cases.
Take a rapid look to the particularity of DefaultSecurityUser in to better understand hot it works.

## DefaultSecurityUser

```java
public class DefaultSecurityUser implements SecurityUser {
    private MainIdentifier mainIdentifier;
    private Collection<String> authorities;
    private Collection<String> identifiers;
    ...
```

authorities are treated as if they were Strings the following can be a possible way to popolate it:

```java
authorities=Set.of("USER","ADMIN","SUPER-SAYAN");
```

identifiers are a Collection of every identifier that the user can use in order to authenticate:
In many cases in the identifiers there are username and password but ideally every Unique Attribute of your User can be
used

```java
identifiers=Set.of("mario689","mario689@rossi.it");
```

## MainIdentifier

Last but not least MainIdentifier carry information about the id of your user it can be very useful to find the in your
repository.\
MainIdentifier is an interface that wrap the identifier in order to allow you to use the type of data you deem most
appropriate.
There is already some implementation of this interface, so you don't need to implement them. the type already
implemented are:

- LongMainIdentifier
- UUIDMainIdentifier