package com.aiadver.api.demo.provider.service;

import com.aiadver.api.demo.provider.model.DemoModel;

import java.util.List;

/**
 * @author lizhiyong
 */
public interface DubboDemoRemoteService {

    /**
     * demo 查询请求
     *
     * @param model
     * @return
     */
    List<DemoModel> query(DemoModel model);

    /**
     * demo 获取详细信息
     *
     * @param id
     * @return
     */
    DemoModel getInfo(Integer id);

    /**
     * demo 新增请求
     *
     * @param model
     * @return
     */
    DemoModel create(DemoModel model);

    /**
     * demo 更新请求
     *
     * @param model
     * @return
     */
    DemoModel update(DemoModel model);

    /**
     * demo 删除请求
     *
     * @param id
     */
    void delete(Integer id);
}
