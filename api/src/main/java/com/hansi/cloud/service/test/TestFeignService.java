package com.hansi.cloud.service.test;

import com.hansi.cloud.feignFall.test.TestFall;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "APP-PROVIDER-BASE",fallbackFactory = TestFall.class)
public interface TestFeignService {

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List list();

    @RequestMapping(value = "/test/insert", method = RequestMethod.GET)
    public String insert();

}
