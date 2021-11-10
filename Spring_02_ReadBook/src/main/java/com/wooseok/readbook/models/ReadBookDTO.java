package com.wooseok.readbook.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_readbooks")
public class ReadBookDTO implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long seq;

        @Column(columnDefinition = "VARCHAR(13)",nullable = false)
        private String isbn;

}