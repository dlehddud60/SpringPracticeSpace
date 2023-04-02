package com.example.crudexample5.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity @Builder @Table(name = "BOARD5")
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
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
