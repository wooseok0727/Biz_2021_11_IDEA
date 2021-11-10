package com.wooseok.readbook.models;

import lombok.*;

import javax.persistence.*;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq = 0L;

    @Column(columnDefinition = "VARCHAR(13)",nullable = false)
    private String isbn;

    @Column(columnDefinition = "VARCHAR(125)", nullable = false)
    private String title;

    @Column(columnDefinition = "VARCHAR(30)")
    private String comp;

    @Column(columnDefinition = "VARCHAR(30)")
    private String author;

    @Builder
    public Book(String isbn, String title, String comp, String author) {
        this.isbn = isbn;
        this.title = title;
        this.comp = comp;
        this.author = author;
    }
}
