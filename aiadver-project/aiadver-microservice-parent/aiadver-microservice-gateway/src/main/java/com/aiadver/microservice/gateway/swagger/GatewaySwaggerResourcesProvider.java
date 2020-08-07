package com.aiadver.microservice.gateway.swagger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author george
 */
@Component
@Primary
@Slf4j
public class GatewaySwaggerResourcesProvider implements SwaggerResourcesProvider {

    private static final String API_URI = "/v2/api-docs";
    private static Map<String, SwaggerResource> swaggerResources = new HashMap<>();
    private final RouteDefinitionLocator routeLocator;

    @Value("${spring.cloud.gateway.discovery.locator.route-id-prefix}")
    private String routeIdPrefix;

    @Value("${spring.application.name}")
    private String gatewayName;

    public GatewaySwaggerResourcesProvider(RouteDefinitionLocator routeLocator) {
        this.routeLocator = routeLocator;
        loadSwaggerResources();
    }

    private void loadSwaggerResources() {
        // 从DiscoveryClientRouteDefinitionLocator 中取出routes，构造成swaggerResource
        routeLocator.getRouteDefinitions().subscribe(routeDefinition -> {

            String name = routeDefinition.getId().substring(routeIdPrefix.length());
            String location = routeDefinition.getPredicates().get(0).getArgs().get("pattern").replace("/**", API_URI);

            if (!gatewayName.equalsIgnoreCase(name)) {
                swaggerResources.put(name, swaggerResource(name, location));
            }
        });
    }

    @Override
    public List<SwaggerResource> get() {
        loadSwaggerResources();
        return List.copyOf(swaggerResources.values());
    }

    private SwaggerResource swaggerResource(String name, String location) {
        log.info("name: " + name + " url: " + location);
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion("2.0");
        return swaggerResource;
    }
}
