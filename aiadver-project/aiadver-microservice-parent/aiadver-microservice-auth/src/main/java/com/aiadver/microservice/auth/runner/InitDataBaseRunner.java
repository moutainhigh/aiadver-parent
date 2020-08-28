package com.aiadver.microservice.auth.runner;

import com.aiadver.microservice.auth.service.ClientService;
import com.aiadver.microservice.auth.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author george
 */
@Slf4j
@Component
public class InitDataBaseRunner implements ApplicationRunner {

    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "clientService")
    private ClientService clientService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("初始化user信息--saveDefaultUser");
        userService.saveDefaultUser();

        log.info("初始化client信息--saveDefaultClient");
        clientService.saveDefaultClient();
    }
}
