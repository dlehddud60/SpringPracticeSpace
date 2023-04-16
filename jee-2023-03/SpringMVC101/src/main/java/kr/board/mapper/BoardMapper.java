package kr.board.mapper;

import kr.board.entity.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface BoardMapper {
    public List<Board> getLists(); //전체리스트를 가지고 옴
    public void boardInsert(Board vo);
    public Board boardContent(int idx);
    public void boardDelete(int idx);
    public void boardUpdate(Board vo);
    @Update("update myboard set count=count+1 where idx=#{idx}")
    public void boardCount(int idx);
}
