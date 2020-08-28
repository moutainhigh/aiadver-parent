package com.aiadver.microservice.auth.service.impl;

import com.aiadver.microservice.auth.entity.UserInfo;
import com.aiadver.microservice.auth.repository.UserInfoRepository;
import com.aiadver.microservice.auth.service.UserService;
import com.aiadver.microservice.auth.translator.UserInfoTranslator;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author george
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userInfoRepository")
    private UserInfoRepository userInfoRepository;

    @Resource(name = "userInfoTranslator")
    private UserInfoTranslator userInfoTranslator;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoRepository.getOneByUsername(username);
        return userInfoTranslator.copySourceToTarget(userInfo);
    }
}
