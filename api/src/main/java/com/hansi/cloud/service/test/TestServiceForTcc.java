package com.hansi.cloud.service.test;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestServiceForTcc {

    private static final String REST_URL_PREFIX = "http://app-provider-s";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TestFeignService testService;

    @LcnTransaction //分布式事务注解
    @Transactional
    public List save(){
        List list = new ArrayList();

        //String a  = restTemplate.getForObject("http://app-provider-base" + "/test/insert", String.class);

        String b = this.getSaveRibbon();
        String a  = testService.insert();
        list.add(a);
        list.add(b);
        return list;
    };

    @HystrixCommand(fallbackMethod = "getSaveRibbonfall" )
    public String getSaveRibbon(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/test/insert", String.class);
    }
    public String getSaveRibbonfall(){
        return "ribbon报错";
    }
    @HystrixCommand(fallbackMethod = "getSaveRibbonfall2" )
    public String save2(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/test/insert", String.class);
    }
    public String getSaveRibbonfall2(){
        return "ribbon报错";
    }
}
