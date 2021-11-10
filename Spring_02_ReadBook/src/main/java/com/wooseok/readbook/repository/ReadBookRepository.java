package com.wooseok.readbook.repository;

import com.wooseok.readbook.models.ReadBookDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadBookRepository extends JpaRepository<ReadBookDTO, Long> {
}
