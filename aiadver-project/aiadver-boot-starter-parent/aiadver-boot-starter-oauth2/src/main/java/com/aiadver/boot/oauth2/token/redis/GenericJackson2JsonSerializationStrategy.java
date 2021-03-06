package com.aiadver.boot.oauth2.token.redis;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.security.jackson2.CoreJackson2Module;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.store.redis.StandardStringSerializationStrategy;
import org.springframework.security.web.jackson2.WebJackson2Module;

/**
 * @author george
 */
public class GenericJackson2JsonSerializationStrategy extends StandardStringSerializationStrategy {

    private static GenericJackson2JsonRedisSerializer jsonRedisSerializer;

    public GenericJackson2JsonSerializationStrategy() {
        ObjectMapper objectMapper = getObjectMapper();
        jsonRedisSerializer = new GenericJackson2JsonRedisSerializer(objectMapper);
    }

    private ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.activateDefaultTyping(objectMapper.getPolymorphicTypeValidator(), ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
        objectMapper.disable(MapperFeature.AUTO_DETECT_SETTERS);
        objectMapper.registerModule(new CoreJackson2Module());
        objectMapper.registerModule(new WebJackson2Module());
        objectMapper.addMixIn(OAuth2AccessToken.class, Oauth2AccessTokenMixIn.class);
        objectMapper.addMixIn(OAuth2Authentication.class, Oauth2AuthenticationMixIn.class);
        objectMapper.addMixIn(OAuth2Request.class, Oauth2RequestMixIn.class);
        return objectMapper;
    }

    @Override
    protected <T> T deserializeInternal(byte[] bytes, Class<T> clazz) {
        return jsonRedisSerializer.deserialize(bytes, clazz);
    }

    @Override
    protected byte[] serializeInternal(Object object) {
        return jsonRedisSerializer.serialize(object);
    }
}
