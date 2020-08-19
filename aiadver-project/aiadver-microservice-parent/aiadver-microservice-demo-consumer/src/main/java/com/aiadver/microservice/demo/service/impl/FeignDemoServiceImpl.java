package com.aiadver.microservice.demo.service.impl;

import com.aiadver.api.demo.client.impl.FeignDemoClientFallback;
import com.aiadver.microservice.demo.service.FeignDemoService;
import org.springframework.stereotype.Service;

/**
 * @author george
 */
@Service("FeignDemoService")
public class FeignDemoServiceImpl extends FeignDemoClientFallback implements FeignDemoService {

}
