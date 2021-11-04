package com.wooseok.student.repository;

import com.wooseok.student.models.StudentVO;

import java.util.List;

public interface StDao {

    public List<StudentVO> selectAll();
    public StudentVO findById(String st_num);
    public void insert(StudentVO stVO);
    public void update(StudentVO stVO);
    public void delete(String st_num);
}
