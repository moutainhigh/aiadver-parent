package com.aiadver.microservice.demo.service;

import com.aiadver.api.demo.service.FeignDemoRemoteService;
import com.aiadver.api.demo.service.impl.FeignDemoRemoteServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author george
 */
@FeignClient(name = "aiadver-microservice-demo-provider", fallback = FeignDemoService.FeignDemoServiceImpl.class)
public interface FeignDemoService extends FeignDemoRemoteService {

    class FeignDemoServiceImpl extends FeignDemoRemoteServiceImpl implements FeignDemoService {

    }
}
