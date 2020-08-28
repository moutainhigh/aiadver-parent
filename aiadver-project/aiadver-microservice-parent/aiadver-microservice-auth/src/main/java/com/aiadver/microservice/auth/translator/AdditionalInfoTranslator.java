package com.aiadver.microservice.auth.translator;

import com.aiadver.framework.microservice.support.BaseTranslator;
import com.aiadver.microservice.auth.entity.AdditionalInfo;
import org.apache.commons.collections.keyvalue.DefaultMapEntry;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author george
 */
@Component
public class AdditionalInfoTranslator extends BaseTranslator<AdditionalInfo, Map.Entry<String, Object>> {
    @Override
    public Map.Entry<String, Object> copySourceToTarget(AdditionalInfo additionalInfo) {
        Map.Entry<String, Object> entry = new DefaultMapEntry(additionalInfo.getAdditionalKey(), additionalInfo.getAdditionalValue());
        return entry;
    }

    @Override
    public AdditionalInfo copyTargetToSource(Map.Entry<String, Object> entry) {
        AdditionalInfo additionalInfo = new AdditionalInfo();
        additionalInfo.setAdditionalKey(entry.getKey());
        additionalInfo.setAdditionalValue(entry.getValue().toString());
        return additionalInfo;
    }

    public Map<String, Object> copySourceToTargetMap(List<AdditionalInfo> additionalInfos) {
        Map<String, Object> map = new HashMap<>(additionalInfos.size());
        additionalInfos.forEach(additionalInfo -> {
            map.put(additionalInfo.getAdditionalKey(), additionalInfo.getAdditionalValue());
        });
        return map;
    }

    public List<AdditionalInfo> copyTargetMapToSource(Map<String, Object> map) {
        return map.entrySet().stream().map(this::copyTargetToSource).collect(Collectors.toList());
    }
}
