package dev.dmgiangi.budssecurity.configuration;

import dev.dmgiangi.budssecurity.authentication.provider.SecurityUserProvider;
import dev.dmgiangi.budssecurity.authentication.provider.mock.MockSecurityUserProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * class
 *
 * @author Gianluigi De Marco
 * @version x
 * @since 29 09 2022
 */
@Configuration
public class SecurityUserProviderBean {
    /**
     * securityUserProvider.
     *
     * @return a {@link dev.dmgiangi.budssecurity.authentication.provider.SecurityUserProvider} object
     */
    @Bean
    @ConditionalOnMissingBean(SecurityUserProvider.class)
    public SecurityUserProvider securityUserProvider() {
        return new MockSecurityUserProvider();
    }
}
