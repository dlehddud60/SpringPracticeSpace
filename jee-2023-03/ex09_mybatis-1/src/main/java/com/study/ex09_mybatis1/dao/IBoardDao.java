package com.study.ex09_mybatis1.dao;

import com.study.ex09_mybatis1.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper Mybatis와 인터페이스 함수를 연결함.
@Mapper
public interface IBoardDao {
    public List<BoardDto> list();
    public int write(String board_name, String  board_title,String board_content);
    public BoardDto viewDto(String board_idx);
    public int updateDto(String board_idx,String board_name,String board_title,String board_content);
    public int deleteDto(String board_idx);
    public int hit(String board_idx);
}
