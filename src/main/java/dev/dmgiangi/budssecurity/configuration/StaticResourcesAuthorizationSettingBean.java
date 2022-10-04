package dev.dmgiangi.budssecurity.configuration;

import dev.dmgiangi.budssecurity.authorizations.StaticResourcesAuthorizationSetting;
import dev.dmgiangi.budssecurity.authorizations.VoidStaticResourcesAuthorizationSetting;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This Class Create a Bean of StaticResourcesAuthorizationSetting
 *
 * @author Gianluigi De Marco
 * @version 0.1.2
 * @since 03 10 2022
 */
@Configuration
public class StaticResourcesAuthorizationSettingBean {
    /**
     * Create a bean of VoidStaticResourcesAuthorizationSetting if
     * no StaticResourcesAuthorizationSetting are already created
     *
     * @return a {@link VoidStaticResourcesAuthorizationSetting} object
     */
    @Bean
    @ConditionalOnMissingBean(StaticResourcesAuthorizationSetting.class)
    public StaticResourcesAuthorizationSetting staticResourcesAuthorizationSetting() {
        return new VoidStaticResourcesAuthorizationSetting();
    }
}
