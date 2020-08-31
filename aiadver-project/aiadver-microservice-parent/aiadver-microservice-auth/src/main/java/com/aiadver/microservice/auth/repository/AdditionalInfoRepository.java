package com.aiadver.microservice.auth.repository;

import com.aiadver.boot.data.jpa.base.BaseRepository;
import com.aiadver.microservice.auth.entity.AdditionalInfo;

/**
 * @author george
 */
public interface AdditionalInfoRepository extends BaseRepository<AdditionalInfo, Long> {

    /**
     * 通过additionalKey获取AdditionalInfo对象
     *
     * @param additionalKey
     * @return
     */
    AdditionalInfo getOneByAdditionalKey(String additionalKey);
}
