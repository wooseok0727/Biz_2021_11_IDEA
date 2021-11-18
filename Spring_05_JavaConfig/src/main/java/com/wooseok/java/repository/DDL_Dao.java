package com.wooseok.java.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DDL_Dao {

    @Select("${create_table}")
    public void create_table(String create_table);
}
