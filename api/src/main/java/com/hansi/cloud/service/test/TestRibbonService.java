package com.hansi.cloud.service.test;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory=String.class)
public interface TestRibbonService {

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List list();

}
