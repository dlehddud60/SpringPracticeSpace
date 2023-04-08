package com.study.ex09_mybatis1.dto;


// board_idx         NUMBER(4)       PRIMARY KEY,
//         board_name        VARCHAR2(20),
//         board_title       VARCHAR2(100),
//         board_content     VARCHAR2(300),
//         board_date        SYSDATE(4) SYSDATE,
//         board_hit         NUMBER(4) DEFAULT 0

import lombok.Data;

import java.util.Date;

@Data //lombok연결

public class BoardDto {
    private int board_idx;
    private String board_name;
    private String board_title;
    private String board_content;
    private Date board_date;
    private int board_hit;

    public BoardDto() {
    }

    public BoardDto(int board_idx, String board_name, String board_title, String board_content, Date board_date, int board_hit) {
        this.board_idx = board_idx;
        this.board_name = board_name;
        this.board_title = board_title;
        this.board_content = board_content;
        this.board_date = board_date;
        this.board_hit = board_hit;
    }


}
