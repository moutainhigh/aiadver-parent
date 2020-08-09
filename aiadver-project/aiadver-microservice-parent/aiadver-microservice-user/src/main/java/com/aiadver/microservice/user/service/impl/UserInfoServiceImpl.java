package com.aiadver.microservice.user.service.impl;

import com.aiadver.api.user.model.UserInfo;
import com.aiadver.microservice.user.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author george
 */
@Slf4j
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    private static final Map<Long, UserInfo> USER_INFO_MAP = new HashMap<>();

    @Override
    public List<UserInfo> query(UserInfo model) {
        log.info("query model: " + model.toString());
        List<UserInfo> demoModels = new ArrayList<>();
        demoModels.addAll(USER_INFO_MAP.values());
        return demoModels;
    }

    @Override
    public UserInfo getInfo(Long id) {
        log.info("getInfo id: " + id);
        return USER_INFO_MAP.get(id);
    }

    @Override
    public UserInfo create(UserInfo model) {
        log.info("create model: " + model.toString());
        return USER_INFO_MAP.put(model.getId(), model);
    }

    @Override
    public UserInfo update(UserInfo model) {
        log.info("update model: " + model.toString());
        return USER_INFO_MAP.put(model.getId(), model);
    }

    @Override
    public void delete(Long id) {
        log.info("delete id: " + id);
        USER_INFO_MAP.remove(id);
    }
}
