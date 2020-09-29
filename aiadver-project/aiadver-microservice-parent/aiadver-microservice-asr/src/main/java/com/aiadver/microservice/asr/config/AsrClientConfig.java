package com.aiadver.microservice.asr.config;

import com.aiadver.microservice.asr.client.AsrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author george
 */
@Configuration
public class AsrClientConfig {

    @Value("${thrift.asr.host}")
    private String host;

    @Value("${thrift.asr.port}")
    private int port;

    @Bean(initMethod = "init")
    public AsrClient asrClient() {
        AsrClient asrClient = new AsrClient(host, port);
        return asrClient;
    }
}
