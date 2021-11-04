package com.wooseok.student.controller;

import com.wooseok.student.models.StudentVO;
import com.wooseok.student.service.impl.StService1;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class StController {

    private final StService1 stService = new StService1();

    public void list() {
        List<StudentVO> stList = stService.selectAll();
        for(StudentVO stVO : stList) {
            log.debug(stVO.toString());
        }
    }
}
