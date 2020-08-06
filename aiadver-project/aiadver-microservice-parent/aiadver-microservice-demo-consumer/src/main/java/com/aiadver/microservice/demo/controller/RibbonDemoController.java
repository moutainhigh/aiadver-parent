package com.aiadver.microservice.demo.controller;

import com.aiadver.api.demo.provider.model.DemoModel;
import com.aiadver.microservice.demo.service.RibbonDemoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author george
 */
@RestController
@RequestMapping(value = "/consumer/ribbon/demo")
public class RibbonDemoController {

    @Resource(name = "ribbonDemoService")
    private RibbonDemoService demoService;

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
