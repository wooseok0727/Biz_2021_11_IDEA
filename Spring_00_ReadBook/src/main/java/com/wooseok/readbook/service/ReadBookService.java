package com.wooseok.readbook.service;

import com.wooseok.readbook.models.Book;
import com.wooseok.readbook.models.ReadBook;
import com.wooseok.readbook.models.ReadBookDTO;

public interface ReadBookService extends GenericService<ReadBookDTO,String> {

    public void readBookInsert(ReadBookDTO readBookDTO);

}
