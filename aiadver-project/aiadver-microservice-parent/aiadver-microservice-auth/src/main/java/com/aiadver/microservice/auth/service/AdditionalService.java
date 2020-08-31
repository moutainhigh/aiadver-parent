package com.aiadver.microservice.auth.service;

import com.aiadver.microservice.auth.entity.AdditionalInfo;

import java.util.List;

/**
 * @author george
 */
public interface AdditionalService {

    /**
     * 加载额外配置信息
     *
     * @param additionalInformation
     * @return
     */
    List<AdditionalInfo> loadAdditionalInfos(List<AdditionalInfo> additionalInformation);
}
