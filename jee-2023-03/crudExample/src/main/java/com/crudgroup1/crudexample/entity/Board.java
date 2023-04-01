package com.crudgroup1.crudexample.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor @Builder @Entity @Table(name = "BOARD1")
public class Board {

    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private Long no;

    @Column(length = 60)
    private String writer;

    @Column(length = 30)
    private String title;

    @Column @Lob
    private String content;

    @Column
    private int readCount;

    @CreationTimestamp
    private Date writeTime;

    @UpdateTimestamp
    private Date editTime;

}
