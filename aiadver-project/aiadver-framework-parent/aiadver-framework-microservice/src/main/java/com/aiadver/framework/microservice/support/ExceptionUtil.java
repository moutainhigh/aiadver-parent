package com.aiadver.framework.microservice.support;

import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;

@Slf4j
public class ExceptionUtil {

    public static SentinelClientHttpResponse handleException(HttpRequest request, byte[] body, ClientHttpRequestExecution execution, BlockException ex) {
        log.error(ex.getMessage(), ex);
        return new SentinelClientHttpResponse("RestTemplate FallBack Msg");
    }
}
