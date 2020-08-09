package com.aiadver.microservice.demo.service.impl;

import com.aiadver.api.demo.service.impl.FeignDemoRemoteServiceImpl;
import com.aiadver.microservice.demo.service.FeignDemoService;
import org.springframework.stereotype.Component;

/**
 * @author george
 */
@Component("feignDemoService")
public class FeignDemoServiceImpl extends FeignDemoRemoteServiceImpl implements FeignDemoService {
}
