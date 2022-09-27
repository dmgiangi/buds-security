package dev.dmgiangi.budssecurity.mock;

import dev.dmgiangi.budssecurity.authorizations.annotations.Public;

/**
 * null.java
 *
 * @author Gianluigi De Marco
 * @since 27 09 2022
 */
public class TestController {
    @Public
    public void publicMethod(){

    }

    public void privateMethod(){

    }
}
