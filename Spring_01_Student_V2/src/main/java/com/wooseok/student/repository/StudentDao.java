package com.wooseok.student.repository;

import com.wooseok.student.models.StudentVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<StudentVO, String> {
}
