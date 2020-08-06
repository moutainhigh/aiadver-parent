package com.aiadver.microservice.demo.service.impl;

import com.aiadver.api.demo.provider.model.DemoModel;
import com.aiadver.microservice.demo.service.RibbonDemoService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author george
 */
@Service("ribbonDemoService")
public class RibbonDemoServiceImpl implements RibbonDemoService {

    private static final String URL = "http://aiadver-microservice-demo-provider/provider/demo";

    @Resource(name = "restTemplate")
    private RestTemplate restTemplate;

    @Override
    public List<DemoModel> query(DemoModel model) {
        return restTemplate.getForEntity(URL, List.class, model).getBody();
    }

    @Override
    public DemoModel getInfo(Integer id) {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(URL + "/{id:\\d+}").build().expand(id).encode();
        URI uri = uriComponents.toUri();
        return restTemplate.getForEntity(uri, DemoModel.class).getBody();
    }

    @Override
    public DemoModel create(DemoModel model) {
        return restTemplate.postForEntity(URL, model, DemoModel.class).getBody();
    }

    @Override
    public DemoModel update(DemoModel model) {
        restTemplate.put(URL, model);
        return model;
    }

    @Override
    public void delete(Integer id) {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(URL + "/{id:\\d+}").build().expand(id).encode();
        URI uri = uriComponents.toUri();
        restTemplate.delete(uri);
    }
}
