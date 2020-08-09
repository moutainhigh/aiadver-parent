package com.aiadver.microservice.user.service;

import com.aiadver.api.user.model.UserInfo;

import java.util.List;

public interface UserInfoService {

    /**
     * demo 查询请求
     *
     * @param model
     * @return
     */
    List<UserInfo> query(UserInfo model);

    /**
     * demo 获取详细信息
     *
     * @param id
     * @return
     */
    UserInfo getInfo(Long id);

    /**
     * demo 新增请求
     *
     * @param model
     * @return
     */
    UserInfo create(UserInfo model);

    /**
     * demo 更新请求
     *
     * @param model
     * @return
     */
    UserInfo update(UserInfo model);

    /**
     * demo 删除请求
     *
     * @param id
     */
    void delete(Long id);
}
