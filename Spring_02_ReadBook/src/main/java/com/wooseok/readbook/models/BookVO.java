package com.wooseok.readbook.models;

import javax.persistence.*;

@Entity
@Table(name = "tbl_books")
public class BookVO {

    @Id
    private String isbn;
    private String title;
    private String author;
    private String comp;
    private Integer price = 0;
    private String date;
}