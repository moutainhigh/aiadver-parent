package com.aiadver.microservice.auth.config;

import org.springframework.boot.autoconfigure.security.oauth2.OAuth2ClientProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;

/**
 * @author george
 */
@Configuration
public class DefaultClientDetailsConfig {

    private final OAuth2ClientProperties client;
    @Resource
    private PasswordEncoder passwordEncoder;

    protected DefaultClientDetailsConfig(OAuth2ClientProperties client) {
        this.client = client;
    }

    @Bean
    @ConfigurationProperties(prefix = "security.oauth2.client")
    public BaseClientDetails defaultClientDetails() {
        BaseClientDetails details = new BaseClientDetails();
        if (this.client.getClientId() == null) {
            this.client.setClientId(UUID.randomUUID().toString());
        }
        details.setClientId(this.client.getClientId());
        details.setClientSecret(passwordEncoder.encode(this.client.getClientSecret()));
        details.setAuthorizedGrantTypes(Arrays.asList("authorization_code", "password", "client_credentials", "implicit", "refresh_token"));
        details.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
        details.setRegisteredRedirectUri(Collections.<String>emptySet());
        return details;
    }
}
