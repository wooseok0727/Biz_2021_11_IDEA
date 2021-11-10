package com.wooseok.readbook.service.impl;

import com.wooseok.readbook.models.Book;
import com.wooseok.readbook.models.ReadBook;
import com.wooseok.readbook.models.ReadBookDTO;
import com.wooseok.readbook.repository.BookDao;
import com.wooseok.readbook.repository.ReadBookDao;
import com.wooseok.readbook.service.ReadBookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("readBookServiceV1")
public class ReadBookServiceImplV1 implements ReadBookService {

    private final BookDao bookDao;
    private final ReadBookDao readBookDao;

    public ReadBookServiceImplV1(BookDao bookDao, ReadBookDao readBookDao) {
        this.bookDao = bookDao;
        this.readBookDao = readBookDao;
    }

    @Override
    public List<ReadBookDTO> selectAll() {

        List<Book> bookList = bookDao.findAll();
        List<ReadBookDTO> readBooks = new ArrayList<>();

        for (Book book : bookList) {
            ReadBookDTO rbVO = ReadBookDTO.builder()
                    .isbn(book.getIsbn())
                    .title(book.getTitle())
                    .comp(book.getComp())
                    .author(book.getAuthor())
                    .build();
            readBooks.add(rbVO);
        }
        return readBooks;

    }

    @Override
    public ReadBookDTO findById(String s) {
        return null;
    }

    @Override
    public void readBookInsert(ReadBookDTO readBookDTO) {

        bookDao.save(Book.builder()
                .isbn(readBookDTO.getIsbn())
                .title(readBookDTO.getTitle())
                .comp(readBookDTO.getComp())
                .author(readBookDTO.getAuthor())
                .build());
        readBookDao.save(ReadBook.builder()
                .isbn(readBookDTO.getIsbn())
                .sDate(readBookDTO.getSDate())
                .sTime(readBookDTO.getSTime())
                .eTime(readBookDTO.getETime())
                .subject(readBookDTO.getSubject())
                .content(readBookDTO.getContent())
                .build());
    }

    @Override
    public void insert(ReadBookDTO model) {

    }

    @Override
    public void update(ReadBookDTO model) {

    }

    @Override
    public void delete(String s) {

    }
}
