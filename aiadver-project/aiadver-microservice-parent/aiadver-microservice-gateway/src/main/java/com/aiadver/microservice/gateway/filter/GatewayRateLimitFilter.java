package com.aiadver.microservice.gateway.filter;

import com.google.common.util.concurrent.RateLimiter;
import io.netty.buffer.UnpooledByteBufAllocator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.NettyDataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * @author george
 */
@Slf4j
@Order(1)
@Component
public class GatewayRateLimitFilter implements WebFilter {

    private final RateLimiter rateLimiter = RateLimiter.create(100);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        log.info("限流开始=========");
        if (rateLimiter.tryAcquire()) {
            return chain.filter(exchange);
        } else {
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
            return response.writeWith(Mono.create(sink -> {
                NettyDataBufferFactory nettyDataBufferFactory = new NettyDataBufferFactory(new UnpooledByteBufAllocator(false));
                DataBuffer dataBuffer = nettyDataBufferFactory.wrap("too many request!".getBytes());
                sink.success(dataBuffer);
            }));
        }
    }
}
