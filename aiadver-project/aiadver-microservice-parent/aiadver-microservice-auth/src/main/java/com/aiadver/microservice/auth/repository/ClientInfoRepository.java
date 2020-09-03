package com.aiadver.microservice.auth.repository;

import com.aiadver.boot.data.jpa.base.BaseRepository;
import com.aiadver.microservice.auth.entity.ClientInfo;

/**
 * @author george
 */
public interface ClientInfoRepository extends BaseRepository<ClientInfo, Long> {

    /**
     * 通过clientId获取ClientInfo对象
     *
     * @param clientId
     * @return
     */
    ClientInfo getOneByClientId(String clientId);

    /**
     * 通过clientId删除ClientInfo对象
     *
     * @param clientId
     * @return
     */
    ClientInfo deleteByClientId(String clientId);
}
