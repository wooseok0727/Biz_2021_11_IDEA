package com.wooseok.student.controller;

import com.wooseok.student.models.StudentVO;
import com.wooseok.student.service.StService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class StController2 {

    // 인터페이스로 선언만 하기
    // @Autowired
    private StService stService;

    // setter() 를 통해서 객체를 주입받도록 하기
    public void setStService(StService stService) {
        this.stService = stService;
    }

    public void list() {
        List<StudentVO> stList = stService.selectAll();
        for(StudentVO stVO : stList) {
            log.debug(stVO.toString());
        }
    }
}
