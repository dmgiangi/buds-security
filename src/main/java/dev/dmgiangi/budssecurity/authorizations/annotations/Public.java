package dev.dmgiangi.budssecurity.authorizations.annotations;

import java.lang.annotation.*;

/**
 * This Annotation mark all endpoint that should be accessed also without from unauthenticated user
 *
 * @author Gianluigi De Marco
 * @version 0.1-SNAPSHOT
 * @since 19 09 2022
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Public {
}
