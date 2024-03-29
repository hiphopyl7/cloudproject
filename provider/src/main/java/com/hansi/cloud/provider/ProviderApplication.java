package com.hansi.cloud.provider;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient //服务发现
@EnableDistributedTransaction//分布式事务
public class ProviderApplication {

    public static void main(String[] args) {


       SpringApplication.run(ProviderApplication.class, args);
        System.out.println("===========提供者1启动==============");
    }

}
