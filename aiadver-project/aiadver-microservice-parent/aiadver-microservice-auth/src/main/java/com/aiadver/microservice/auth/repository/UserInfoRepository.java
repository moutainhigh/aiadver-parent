package com.aiadver.microservice.auth.repository;

import com.aiadver.boot.data.jpa.base.BaseRepository;
import com.aiadver.microservice.auth.entity.UserInfo;

/**
 * @author george
 */
public interface UserInfoRepository extends BaseRepository<UserInfo, Long> {


    /**
     * 通过用户名获取用户信息
     *
     * @param username
     * @return
     */
    UserInfo getOneByUsername(String username);
}
