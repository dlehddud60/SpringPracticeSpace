package com.study.springboot.dto;

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
