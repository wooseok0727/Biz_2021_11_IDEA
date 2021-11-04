package com.wooseok.student.service.impl;

import com.wooseok.student.models.StudentVO;
import com.wooseok.student.repository.StDao;
import com.wooseok.student.repository.impl.StDaoImpl;
import com.wooseok.student.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

// Ioc 컨테이너에게 StudentServiceImplV1 클래스를 사용하여 객체를 생성하고
// 필요한 곳에 주입해 달라
@Service("stServiceV1")
public class StudentServiceImplV1  implements StudentService {

    private final StDao stDao;

    public StudentServiceImplV1() {
        stDao = new StDaoImpl();
    }

    public StudentServiceImplV1(StDao stDao) {
        this.stDao = stDao;
    }

    @Override
    public List<StudentVO> selectAll() {

        return stDao.selectAll();
    }

    @Override
    public StudentVO findByNum(String st_num) {
        return null;
    }

    @Override
    public List<StudentVO> findByName(String st_name) {
        return null;
    }

    @Override
    public List<StudentVO> findByTel(String st_tel) {
        return null;
    }

    @Override
    public List<StudentVO> findByDept(String st_dept) {
        return null;
    }

    @Override
    public List<StudentVO> findByGrade(String st_grade) {
        return null;
    }

    @Override
    public StudentVO insert() {
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
