package com.aiadver.microservice.user.controller;

import com.aiadver.api.user.model.UserInfo;
import com.aiadver.microservice.user.service.UserInfoService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;

import javax.annotation.Resource;

/**
 * @author george
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Resource(name = "userInfoService")
    private UserInfoService userInfoService;

    @GetMapping
    public Flux<UserInfo> query(UserInfo model) {
        return Flux.fromIterable(userInfoService.query(model));
    }

    @GetMapping(value = "/{id:\\d+}")
    public Mono<UserInfo> getInfo(@PathVariable Long id) {
        return Mono.justOrEmpty(userInfoService.getInfo(id));
    }

    @PostMapping
    public Mono<UserInfo> create(@RequestBody UserInfo model) {
        return Mono.create(sink -> sink.success(userInfoService.create(model)));
    }

    @PutMapping
    public Mono<UserInfo> update(@RequestBody UserInfo model) {
        return Mono.create(sink -> sink.success(userInfoService.update(model)));
    }

    @DeleteMapping(value = "/{id:\\d+}")
    public Mono<Void> delete(@PathVariable Long id) {
        userInfoService.delete(id);
        return Mono.create(MonoSink::success);
    }
}
