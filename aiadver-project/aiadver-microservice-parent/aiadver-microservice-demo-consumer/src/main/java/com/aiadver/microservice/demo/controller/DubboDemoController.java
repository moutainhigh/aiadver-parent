package com.aiadver.microservice.demo.controller;

import com.aiadver.api.demo.model.DemoModel;
import com.aiadver.api.demo.service.DubboDemoRemoteService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author george
 */
@RestController
@RequestMapping(value = "/consumer/dubbo/demo")
public class DubboDemoController {

    @Reference(retries = 0, check = false)
    private DubboDemoRemoteService demoService;

    /**
     * demo 查询请求
     *
     * @param model
     * @return
     */
    @GetMapping
    public List<DemoModel> query(DemoModel model) {
        return demoService.query(model);
    }

    /**
     * demo 获取详细信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id:\\d+}")
    public DemoModel getInfo(@PathVariable Integer id) {
        return demoService.getInfo(id);
    }

    /**
     * demo 新增请求
     *
     * @param model
     * @return
     */
    @PostMapping
    public DemoModel create(@RequestBody DemoModel model) {
        return demoService.create(model);
    }

    /**
     * demo 更新请求
     *
     * @param model
     * @return
     */
    @PutMapping
    public DemoModel update(@RequestBody DemoModel model) {
        return demoService.update(model);
    }

    /**
     * demo 删除请求
     *
     * @param id
     */
    @DeleteMapping(value = "/{id:\\d+}")
    public void delete(@PathVariable Integer id) {
        demoService.delete(id);
    }
}
