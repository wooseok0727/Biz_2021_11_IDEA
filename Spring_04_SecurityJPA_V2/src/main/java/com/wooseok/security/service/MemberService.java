package com.wooseok.security.service;

import com.wooseok.security.models.User;

import java.util.List;

public interface MemberService extends GenericService<User, String>{

    // GenericService 에 선언된 기본 CRUD 는 같이 상속받는다

    // 별도로 tbl_members table 과 관련된 추가 method 정의
    public List<User> findByEmail(String email);
    public List<User> findByTel(String tel);

    // DB 에 저장된 사용자가 몇명인가가
    public int userCount();
}
