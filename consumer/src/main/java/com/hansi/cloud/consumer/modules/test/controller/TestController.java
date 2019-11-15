package com.hansi.cloud.consumer.modules.test.controller;


import com.hansi.cloud.service.test.TestFeignService;
import com.hansi.cloud.service.test.TestServiceForTcc;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    private static final String REST_URL_PREFIX = "http://APP-PROVIDER-BASE";

    /**
     * 使用 使用restTemplate访问restful接口非常的简单粗暴无脑。 (url, requestMap,
     * ResponseBean.class)这三个参数分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * feign的方式调用
     */
    @Autowired
    private TestFeignService testService;

    @RequestMapping(value = "/test/dept/list")
    public List list()
    {
        return testService.list();
    }

    /**
     *  ribbon的方式调用
     */
    @RequestMapping(value = "/test/dept/list2")
    @HystrixCommand(fallbackMethod = "falllist2")
    public List list2()
    {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }

    /**
     * ribbon的的回调方法
     * @return
     */
    public List falllist2(){
        List list = new ArrayList();
        list.add("这是ribbon的错误");
        return list;
    }



    //测试分布式任务
    @Autowired
    TestServiceForTcc testServiceForTcc;

    @RequestMapping(value = "/test/insert")
    public List insert() {
        return testServiceForTcc.save();
    }

    @RequestMapping(value = "/test/insert2")
    public String insert2() {
        return testServiceForTcc.save2();
    }


}
