package com.aiadver.framework.microservice;

import com.aiadver.framework.microservice.support.YamlPropertySourceFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author george
 */
@Configuration
@ComponentScan
@PropertySource(value = "classpath:bootstrap-microservice.yml", factory = YamlPropertySourceFactory.class)
public class MicroserviceAutoConfig {
}
