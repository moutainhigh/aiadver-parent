package com.aiadver.microservice.auth.service.impl;

import com.aiadver.microservice.auth.entity.AdditionalInfo;
import com.aiadver.microservice.auth.repository.AdditionalInfoRepository;
import com.aiadver.microservice.auth.service.AdditionalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author george
 */
@Slf4j
@Service("additionalService")
@Transactional(rollbackFor = Exception.class)
public class AdditionalServiceImpl implements AdditionalService {

    @Resource(name = "additionalInfoRepository")
    AdditionalInfoRepository additionalInfoRepository;

    @Override
    public List<AdditionalInfo> loadAdditionalInfos(List<AdditionalInfo> additionalInfos) {
        return additionalInfos.stream().map(this::loadAdditionalInfo).collect(Collectors.toList());
    }

    private AdditionalInfo loadAdditionalInfo(AdditionalInfo additionalInfo) {
        String additionalKey = additionalInfo.getAdditionalKey();
        log.info("additionalKey: " + additionalKey);
        AdditionalInfo info = additionalInfoRepository.getOneByAdditionalKey(additionalKey);
        if (info == null) {
            log.info("additionalInfo: " + additionalInfo.toString());
            info = additionalInfoRepository.save(additionalInfo);
        }
        return info;
    }
}
