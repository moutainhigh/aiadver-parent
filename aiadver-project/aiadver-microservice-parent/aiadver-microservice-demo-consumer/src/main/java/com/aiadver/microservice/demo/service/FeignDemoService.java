package com.aiadver.microservice.demo.service;

import com.aiadver.api.demo.client.FeignDemoClient;
import com.aiadver.microservice.demo.service.impl.FeignDemoServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author george
 */
@FeignClient(contextId = "feignDemoService", name = "aiadver-microservice-demo-provider", fallback = FeignDemoServiceImpl.class)
public interface FeignDemoService extends FeignDemoClient {

}
