package com.aiadver.microservice.auth.service;

import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author george
 */
public interface UserService extends UserDetailsService, UserDetailsPasswordService {

    /**
     * 保存默认用户信息
     */
    void saveDefaultUser();
}
