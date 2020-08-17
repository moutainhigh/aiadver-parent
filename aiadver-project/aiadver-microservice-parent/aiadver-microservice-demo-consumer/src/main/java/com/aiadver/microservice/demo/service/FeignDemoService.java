package com.aiadver.microservice.demo.service;

import com.aiadver.api.demo.client.FeignDemoClient;
import com.aiadver.api.demo.client.impl.FeignDemoClientFallback;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author george
 */
@FeignClient(contextId = "feignDemoService", name = "aiadver-microservice-demo-provider", fallback = FeignDemoService.FeignDemoServiceFallback.class)
public interface FeignDemoService extends FeignDemoClient {

    class FeignDemoServiceFallback extends FeignDemoClientFallback implements FeignDemoService {

    }
}
