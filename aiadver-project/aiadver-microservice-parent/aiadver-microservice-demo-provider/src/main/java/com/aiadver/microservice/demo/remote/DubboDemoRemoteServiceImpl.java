package com.aiadver.microservice.demo.remote;

import com.aiadver.api.demo.model.DemoModel;
import com.aiadver.api.demo.service.DubboDemoRemoteService;
import com.aiadver.microservice.demo.service.DemoService;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lizhiyong
 */
@Service
public class DubboDemoRemoteServiceImpl implements DubboDemoRemoteService {

    @Resource(name = "demoService")
    private DemoService demoService;

    @Override
    public List<DemoModel> query(DemoModel model) {
        return demoService.query(model);
    }

    @Override
    public DemoModel getInfo(Integer id) {
        return demoService.getInfo(id);
    }

    @Override
    public DemoModel create(DemoModel model) {
        return demoService.create(model);
    }

    @Override
    public DemoModel update(DemoModel model) {
        return demoService.update(model);
    }

    @Override
    public void delete(Integer id) {
        demoService.delete(id);
    }
}
