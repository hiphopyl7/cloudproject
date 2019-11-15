package com.hansi.cloud.providerfor2.modules.test;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class ServiceTest {

    @Resource
    TestDao testDao;

    @Transactional
    @LcnTransaction
    public void insert(){
        testDao.insert();
        //int num = 100/0;
    }
}
