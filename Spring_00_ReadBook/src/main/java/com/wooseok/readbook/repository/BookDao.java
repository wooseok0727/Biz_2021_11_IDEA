package com.wooseok.readbook.repository;

import com.wooseok.readbook.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book, String> {
}
