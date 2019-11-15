package com.hansi.cloud.lcntcc;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableTransactionManagerServer
public class LcntccApplication {

    public static void main(String[] args) {
        SpringApplication.run(LcntccApplication.class, args);
    }

}
