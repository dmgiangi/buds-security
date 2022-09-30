package dev.dmgiangi.budssecurity.utilities;

import org.springframework.core.env.Environment;

/**
 * desc
 *
 * @author Gianluigi De Marco
 * @version 0.1.2
 * @since 27 09 2022
 */
public class BudsConstants {
    private static String jwtSecret;
    private static String jwtIssuer;
    private static String realm;
    private static int jwtRefreshHourDuration;
    private static int jwtBearerHourDuration;

    /**
     * Constructor for BudsConstants.
     *
     * @param env a {@link org.springframework.core.env.Environment} object
     */
    public BudsConstants(Environment env) {
        jwtSecret = env.getProperty("buds.jwt.secret", String.class, "Rn75JRy@spVfZIloZZlqv267@tPvS4Gq");

        jwtIssuer = env.getProperty("buds.jwt.issuer", String.class, "buds-security");

        realm = env.getProperty("buds.realm", String.class, "my-realm");

        jwtRefreshHourDuration = env.getProperty(
                "buds.jwt.jwtRefreshHourDuration",
                Integer.class,
                8760); //8760 correspond to 1 year

        jwtBearerHourDuration = env.getProperty(
                "buds.jwt.jwtRefreshHourDuration",
                Integer.class,
                1);
    }

    /**
     * jwtSecret.
     *
     * @return a {@link java.lang.String} object
     */
    public static String jwtSecret() {
        return jwtSecret;
    }

    /**
     * jwtIssuer.
     *
     * @return a {@link java.lang.String} object
     */
    public static String jwtIssuer() {
        return jwtIssuer;
    }

    /**
     * realm.
     *
     * @return a {@link java.lang.String} object
     */
    public static String realm() {
        return realm;
    }

    /**
     * jwtRefreshHourDuration.
     *
     * @return a int
     */
    public static int jwtRefreshHourDuration() {
        return jwtRefreshHourDuration;
    }

    /**
     * jwtBearerHourDuration.
     *
     * @return a int
     */
    public static int jwtBearerHourDuration() {
        return jwtBearerHourDuration;
    }
}
