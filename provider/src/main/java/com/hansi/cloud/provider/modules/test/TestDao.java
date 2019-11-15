package com.hansi.cloud.provider.modules.test;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestDao {

    @Insert("insert into test values ('1','haha2')")
    public void insert();
}
