package com.aiadver.boot.oauth2.config;

import com.aiadver.boot.oauth2.token.redis.GenericJackson2JsonSerializationStrategy;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @author george
 */
@Configuration
@ConditionalOnClass(RedisConnectionFactory.class)
public class TokenStoreConfig {

    @Bean
    @ConditionalOnMissingBean(TokenStore.class)
    public TokenStore tokenStore(RedisConnectionFactory redisConnectionFactory) {
        RedisTokenStore tokenStore = new RedisTokenStore(redisConnectionFactory);
        tokenStore.setPrefix("token/");
        tokenStore.setSerializationStrategy(new GenericJackson2JsonSerializationStrategy());
        return tokenStore;
    }
}
