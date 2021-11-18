package com.wooseok.java.service.impl;

import com.wooseok.java.repository.DDL_Dao;
import com.wooseok.java.repository.sql.CreateTableSQL;
import org.springframework.stereotype.Service;

@Service("bookServiceV1")
public class BookServiceImplV1 {


    private final DDL_Dao ddl_dao;

    public BookServiceImplV1(DDL_Dao ddl_dao) {
        this.ddl_dao = ddl_dao;

        ddl_dao.create_table(CreateTableSQL.create_book_table);
    }
}
