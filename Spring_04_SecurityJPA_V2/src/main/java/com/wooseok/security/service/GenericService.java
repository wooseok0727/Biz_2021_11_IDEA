package com.wooseok.security.service;

import java.util.List;

/**
 * 여러 service interface 를 만들기 위한 구조형 interface
 * Generic 을 사용하여 interface 를 선언하였다
 * 
 * 기본 CRUD 5 개의 method 를 선언
 */

public interface GenericService <M, PK>{

    public List<M> selectAll();
    public M findById(PK pk);

    public void insert(M m);
    public void update(M m);
    public void delete(PK pk);
}
