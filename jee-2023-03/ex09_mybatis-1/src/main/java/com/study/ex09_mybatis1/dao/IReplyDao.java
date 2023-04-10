package com.study.ex09_mybatis1.dao;

import com.study.ex09_mybatis1.dto.BoardDto;
import com.study.ex09_mybatis1.dto.ReplyDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // MyBatis와 인터페이스 함수를 연결함
public interface IReplyDao {

    List<ReplyDto> reply_list(String reply_board_index);
    public int reply_write(String reply_name, String reply_content,String reply_board_index);
    public int reply_deleteDto(String reply_idx);

}
