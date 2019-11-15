package com.hansi.cloud.providerfor2.modules.test;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestDao {

    @Insert("insert into test values ('2','haha3')")
    public void insert();
}
