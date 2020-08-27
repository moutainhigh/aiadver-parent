package com.aiadver.microservice.user.service.impl;

import com.aiadver.api.user.model.UserInfo;
import com.aiadver.microservice.user.entity.User;
import com.aiadver.microservice.user.repository.UserRepository;
import com.aiadver.microservice.user.service.UserInfoService;
import com.aiadver.microservice.user.translator.UserTranslator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author george
 */
@Slf4j
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {


    @Resource
    private UserRepository repository;

    @Resource
    private UserTranslator translator;

    @Override
    public List<UserInfo> query(UserInfo model) {
        log.info("query model: " + model.toString());
        User user = translator.copyTargetToSource(model);
        List<User> users = repository.findAll(user);
        return translator.copySourceToTarget(users);
    }

    @Override
    public UserInfo getInfo(Long id) {
        log.info("create id: " + id);
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            return translator.copySourceToTarget(user.get());
        }
        return null;
    }

    @Override
    public UserInfo create(UserInfo model) {
        log.info("create model: " + model.toString());
        User user = translator.copyTargetToSource(model);
        user = repository.save(user);
        return translator.copySourceToTarget(user);
    }

    @Override
    public UserInfo update(UserInfo model) {
        log.info("update model: " + model.toString());
        User user = translator.copyTargetToSource(model);
        user = repository.save(user);
        return translator.copySourceToTarget(user);
    }

    @Override
    public void delete(Long id) {
        log.info("delete id: " + id);
        repository.deleteById(id);
    }
}
