package com.aiadver.microservice.demo.service.impl;

import com.aiadver.api.demo.provider.model.DemoModel;
import com.aiadver.microservice.demo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lizhiyong
 */
@Slf4j
@Service("demoService")
public class DemoServiceImpl implements DemoService {

    private static final Map<Integer, DemoModel> DEMO_MODEL_MAP = new HashMap<>();

    @Override
    public List<DemoModel> query(DemoModel model) {
        log.info("query model: " + model.toString());
        List<DemoModel> demoModels = new ArrayList<>();
        demoModels.addAll(DEMO_MODEL_MAP.values());
        return demoModels;
    }

    @Override
    public DemoModel getInfo(Integer id) {
        log.info("getInfo id: " + id);
        return DEMO_MODEL_MAP.get(id);
    }

    @Override
    public DemoModel create(DemoModel model) {
        log.info("create model: " + model.toString());
        return DEMO_MODEL_MAP.put(model.getId(), model);
    }

    @Override
    public DemoModel update(DemoModel model) {
        log.info("update model: " + model.toString());
        return DEMO_MODEL_MAP.put(model.getId(), model);
    }

    @Override
    public void delete(Integer id) {
        log.info("delete id: " + id);
        DEMO_MODEL_MAP.remove(id);
    }
}
