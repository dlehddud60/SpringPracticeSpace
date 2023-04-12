package com.study.springboot.dao;

import com.study.springboot.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;



@Mapper
public interface IBoardDao {
    public List<BoardDto> list();
    public int write(String board_name, String board_title, String board_content);
    public BoardDto viewDto(String board_idx);
    public int updateDto(String board_idx, String board_name, String board_title, String board_content);
    public int hit(String board_idx);
    public int deleteDto(String board_idx);

}
