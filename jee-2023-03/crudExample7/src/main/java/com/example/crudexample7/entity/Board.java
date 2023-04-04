package com.example.crudexample7.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "BOARD7")
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long no;
    @Column(length = 60)
    private String write;
    @Column(length = 30)
    private String title;
    @Column @Lob
    private String content;
    @Column
    private int readCound;
    @CreationTimestamp
    private Date writeTime;
    @UpdateTimestamp
    private Date editTime;
}
