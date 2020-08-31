package com.aiadver.microservice.auth.config;

import org.springframework.boot.autoconfigure.security.oauth2.OAuth2ClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author george
 */
@Configuration
public class DefaultClientDetailsConfig {

    @Resource
    private OAuth2ClientProperties client;

    @Resource(name = "passwordEncoder")
    private PasswordEncoder passwordEncoder;

    public DefaultClientDetailsConfig(OAuth2ClientProperties client) {
        this.client = client;
    }

    @Bean
    public ClientDetails defaultClientDetails() {
        BaseClientDetails details = new BaseClientDetails();
        String clientId = client.getClientId();
        String clientSecret = client.getClientSecret();
        details.setClientId(clientId);
        details.setClientSecret(passwordEncoder.encode(clientSecret));
        details.setAuthorizedGrantTypes(Arrays.asList("authorization_code", "password", "client_credentials", "implicit", "refresh_token"));
        details.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
        details.setRegisteredRedirectUri(Collections.<String>emptySet());
        return details;
    }
}
