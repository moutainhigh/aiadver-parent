package com.aiadver.api.demo.service;

import com.aiadver.api.demo.model.DemoModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lizhiyong
 */
public interface FeignDemoRemoteService {

    /**
     * demo 查询请求
     *
     * @param model
     * @return
     */
    @GetMapping
    List<DemoModel> query(DemoModel model);

    /**
     * demo 获取详细信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id:\\d+}")
    DemoModel getInfo(@PathVariable Integer id);

    /**
     * demo 新增请求
     *
     * @param model
     * @return
     */
    @PostMapping
    DemoModel create(@RequestBody DemoModel model);

    /**
     * demo 更新请求
     *
     * @param model
     * @return
     */
    @PutMapping
    DemoModel update(@RequestBody DemoModel model);

    /**
     * demo 删除请求
     *
     * @param id
     */
    @DeleteMapping(value = "/{id:\\d+}")
    void delete(@PathVariable Integer id);
}
