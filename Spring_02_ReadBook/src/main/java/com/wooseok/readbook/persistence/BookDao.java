package com.wooseok.readbook.persistence;

import com.wooseok.readbook.models.BookVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<BookVO, String> {
}
