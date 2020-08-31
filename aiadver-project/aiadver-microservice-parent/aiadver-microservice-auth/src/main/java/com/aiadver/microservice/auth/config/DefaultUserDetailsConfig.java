package com.aiadver.microservice.auth.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @author george
 */
@Configuration
public class DefaultUserDetailsConfig {

    private final SecurityProperties properties;

    @Resource(name = "passwordEncoder")
    private PasswordEncoder passwordEncoder;

    public DefaultUserDetailsConfig(SecurityProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.security")
    public UserDetails defaultUserDetails() {
        SecurityProperties.User user = properties.getUser();
        UserDetails details = User.withUsername(user.getName())
                .password(passwordEncoder.encode(user.getPassword()))
                .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER,ROLE_ADMIN"))
                .build();
        return details;
    }
}
