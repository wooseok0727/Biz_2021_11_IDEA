package com.wooseok.student.repository.impl;

import com.wooseok.student.models.StudentVO;
import com.wooseok.student.repository.StDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StDaoImpl implements StDao {
    
    private final String[] stNames =
            {
              "홍길동","이몽룡","성춘향","임꺽정","장영실","장보고"
            };
    private final Random RND = new Random();
    private final List<StudentVO> stList = new ArrayList<>();


//    public List<StudentVO> findAll() {
//        return null;
//    }
    
    @Override
    public List<StudentVO> selectAll() {

        for(int i = 0; i < 10; i++) {
            String stNum = String.format("2021%04d",i+1);
            String stName = stNames[RND.nextInt(stNames.length)];

            StudentVO stVO = StudentVO.builder()
                    .st_num(stNum)
                    .st_name(stName)
                    .st_dept("컴퓨터공학")
                    .st_grade((RND.nextInt(4) + 1) + "")
                    .st_address("광주광역시")
                    .st_tel(String.format("010-%04d-%04d"
                            ,RND.nextInt(9999) + 1
                            ,RND.nextInt(9999) + 1))
                    .build();
            stList.add(stVO);
        }
        return stList;
    }

    @Override
    public StudentVO findById(String st_num) {
        return null;
    }

    @Override
    public void insert(StudentVO stVO) {

    }

    @Override
    public void update(StudentVO stVO) {

    }

    @Override
    public void delete(String st_num) {

    }
}
