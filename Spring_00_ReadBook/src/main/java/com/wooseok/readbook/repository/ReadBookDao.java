package com.wooseok.readbook.repository;

import com.wooseok.readbook.models.ReadBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadBookDao extends JpaRepository<ReadBook, Long> {
}
