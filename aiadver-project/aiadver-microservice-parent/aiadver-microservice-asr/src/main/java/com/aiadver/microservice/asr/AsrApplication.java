package com.aiadver.microservice.asr;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author george
 */
@EnableOpenApi
@SpringCloudApplication
public class AsrApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsrApplication.class, args);
    }
}
