package com.wooseok.student.service;

import com.wooseok.student.models.StudentVO;

public interface StudentService extends GenericService<StudentVO, String>{

    public StudentVO insert();

}
