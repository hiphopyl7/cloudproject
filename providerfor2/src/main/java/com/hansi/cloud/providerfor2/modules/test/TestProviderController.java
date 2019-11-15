package com.hansi.cloud.providerfor2.modules.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestProviderController {

    @Resource
    ServiceTest serviceTest;


    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List list()
    {
        List list = new ArrayList();
        list.add("添加成功");
        return list;

    }

    @RequestMapping(value = "/test/insert", method = RequestMethod.GET)
    public String save()
    {
        serviceTest.insert();
        return "添加成功";
    }
}
