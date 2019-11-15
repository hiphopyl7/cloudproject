package com.hansi.cloud.feignFall.test;

import com.hansi.cloud.service.test.TestFeignService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestFall implements FallbackFactory<TestFeignService> {
    public TestFeignService create(Throwable throwable) {
        return new TestFeignService(){

            public List list() {
                List list = new ArrayList();
                list.add("测试：meiyou--feign");
                return list;
            }

            public String insert() {

                return "测试：没有添加";
            }
        };
    }
}
