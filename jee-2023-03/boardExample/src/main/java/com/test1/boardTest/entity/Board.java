package com.test1.boardTest.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "BOARD")
public class Board {

    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private Long no;

    @Column(length = 60)
    private String writer;

    @Column(length = 300)
    private String title;

    @Column @Lob
    private String content;

    @Column
    private int readcount;

    @CreationTimestamp
    private Date writeTime;

    @UpdateTimestamp
    private Date editTime;


}
