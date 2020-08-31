package com.aiadver.microservice.auth.service;

import com.aiadver.microservice.auth.entity.RoleInfo;

import java.util.List;

/**
 * @author george
 */
public interface RoleService {

    /**
     * 加载角色信息
     *
     * @param roleInfos
     * @return
     */
    List<RoleInfo> loadRoleInfos(List<RoleInfo> roleInfos);
}
