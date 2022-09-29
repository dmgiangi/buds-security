package dev.dmgiangi.budssecurity.configuration;

import dev.dmgiangi.budssecurity.authentication.provider.SecurityUserProvider;
import dev.dmgiangi.budssecurity.authentication.provider.mock.MockSecurityUserProvider;
import dev.dmgiangi.budssecurity.authentication.service.BasicAuthenticationService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * this Configuration create the bean of AuthenticationService
 *
 * @author Gianluigi De Marco
 * @version 0.1.1
 * @since 28 09 2022
 */
@Configuration
public class AuthenticationServiceBean {
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

    /**
     * basicAuthenticationService.
     *
     * @return a {@link dev.dmgiangi.budssecurity.authentication.service.BasicAuthenticationService} object
     */
    @Bean
    @ConditionalOnMissingBean(BasicAuthenticationService.class)
    public BasicAuthenticationService basicAuthenticationService() {
        return new BasicAuthenticationService(securityUserProvider());
    }
}
