package com.aiadver.microservice.auth.service;

import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationService;

/**
 * @author george
 */
public interface ClientService extends ClientDetailsService, ClientRegistrationService {

    /**
     * 保存默认客户端信息
     */
    void saveDefaultClient();
}
