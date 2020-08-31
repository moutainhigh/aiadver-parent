package com.aiadver.microservice.auth.repository;

import com.aiadver.boot.data.jpa.base.BaseRepository;
import com.aiadver.microservice.auth.entity.RoleInfo;

/**
 * @author george
 */
public interface RoleInfoRepository extends BaseRepository<RoleInfo, Long> {


    /**
     * 通过role获取roleInfo对象
     *
     * @param role
     * @return
     */
    RoleInfo getOneByRole(String role);
}