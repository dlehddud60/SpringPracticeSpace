package com.crud.crudexample2.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
@Builder @Entity @Table(name = "BOARD2")
public class Board {
    @Id @GeneratedValue()
    private long no;

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
