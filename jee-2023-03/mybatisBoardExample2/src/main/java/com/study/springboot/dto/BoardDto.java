package com.study.springboot.dto;
// board_idx         NUMBER(4)       PRIMARY KEY,
//         board_name        VARCHAR2(20),
//         board_title       VARCHAR2(100),
//         board_content     VARCHAR2(300),
//         board_date        SYSDATE(4) SYSDATE,
//         board_hit         NUMBER(4) DEFAULT 0

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
public class BoardDto {
    private int board_idx;
    private String board_name;
    private String board_title;
    private String board_content;
    private Date board_date;
    private int board_hit;

}
