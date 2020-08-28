package com.aiadver.microservice.auth.service.impl;

import com.aiadver.microservice.auth.entity.UserInfo;
import com.aiadver.microservice.auth.repository.UserInfoRepository;
import com.aiadver.microservice.auth.service.UserService;
import com.aiadver.microservice.auth.translator.UserInfoTranslator;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author george
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "passwordEncoder")
    private PasswordEncoder passwordEncoder;

    @Resource(name = "userInfoRepository")
    private UserInfoRepository userInfoRepository;

    @Resource(name = "userInfoTranslator")
    private UserInfoTranslator userInfoTranslator;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoRepository.getOneByUsername(username);
        return userInfoTranslator.copySourceToTarget(userInfo);
    }

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        UserInfo userInfo = userInfoRepository.getOneByUsername(user.getUsername());
        userInfo.setPassword(passwordEncoder.encode(newPassword));
        userInfo = userInfoRepository.save(userInfo);
        return userInfoTranslator.copySourceToTarget(userInfo);
    }

    @Override
    public void saveDefaultUser() {

    }
}
