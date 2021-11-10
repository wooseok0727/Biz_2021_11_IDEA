package com.wooseok.readbook.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ReadBookDTO {

    private String isbn;
    private String title;
    private String comp;
    private String author;
    private String sDate;
    private String sTime;
    private String eTime;
    private String subject;
    private String content;
}
