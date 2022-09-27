package dev.dmgiangi.budssecurity.utilities;

import org.springframework.core.env.Environment;

/**
 * desc
 *
 * @author Gianluigi De Marco
 * @version 0.1
 * @since 27 09 2022
 */
public class BudsConstants {
    private static String jwtSecret;
    private static String jwtIssuer;
    private static String realm;
    private static int jwtRefreshHourDuration;
    private static int jwtBearerHourDuration;

    public static String jwtSecret() {
        return jwtSecret;
    }

    public static String jwtIssuer() {
        return jwtIssuer;
    }

    public static String realm() {
        return realm;
    }

    public static int jwtRefreshHourDuration() {
        return jwtRefreshHourDuration;
    }

    public static int jwtBearerHourDuration() {
        return jwtBearerHourDuration;
    }

    public BudsConstants(Environment env) {
        jwtSecret = env.getProperty("buds.jwt.secret", String.class, "Rn75JRy@spVfZIloZZlqv267@tPvS4Gq");

        jwtIssuer = env.getProperty("buds.jwt.issuer", String.class, "buds-security");

        realm = env.getProperty("buds.realm", String.class, "my-realm");

        jwtRefreshHourDuration = env.getProperty(
                "buds.jwt.jwtRefreshHourDuration",
                Integer.class,
                365*24);

        jwtBearerHourDuration = env.getProperty(
                "buds.jwt.jwtRefreshHourDuration",
                Integer.class,
                1);
    }
}
