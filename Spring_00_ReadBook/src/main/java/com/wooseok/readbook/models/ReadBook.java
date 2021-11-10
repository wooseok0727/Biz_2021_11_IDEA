package com.wooseok.readbook.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_readBooks")
public class ReadBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq = 0L;

    @Column(columnDefinition = "VARCHAR(13)",nullable = false)
    private String isbn;

    private String sDate;
    private String sTime;
    private String eTime;
    private String subject;
    private String content;

    @Builder
    public ReadBook(String isbn, String sDate, String sTime, String eTime, String subject, String content) {
        this.isbn = isbn;
        this.sDate = sDate;
        this.sTime = sTime;
        this.eTime = eTime;
        this.subject = subject;
        this.content = content;
    }
}
