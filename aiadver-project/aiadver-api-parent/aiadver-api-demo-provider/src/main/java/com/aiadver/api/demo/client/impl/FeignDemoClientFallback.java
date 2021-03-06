package com.aiadver.api.demo.client.impl;

import com.aiadver.api.demo.client.FeignDemoClient;
import com.aiadver.api.demo.model.DemoModel;

import java.util.Collections;
import java.util.List;

/**
 * @author lizhiyong
 */
public class FeignDemoClientFallback implements FeignDemoClient {

    private final DemoModel ERROR_MODEL = new DemoModel(0, "error");

    @Override
    public List<DemoModel> query(DemoModel model) {
        return Collections.singletonList(ERROR_MODEL);
    }

    @Override
    public DemoModel getInfo(Integer id) {
        return ERROR_MODEL;
    }

    @Override
    public DemoModel create(DemoModel model) {
        return ERROR_MODEL;
    }

    @Override
    public DemoModel update(DemoModel model) {
        return ERROR_MODEL;
    }

    @Override
    public void delete(Integer id) {

    }
}
