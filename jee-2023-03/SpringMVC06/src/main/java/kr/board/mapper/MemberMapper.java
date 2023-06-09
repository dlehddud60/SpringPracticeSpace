package kr.board.mapper;

import kr.board.entity.AuthVO;
import kr.board.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public interface MemberMapper {

    public Member registerCheck(String memID);
    public int register(Member m); //회원등록(1, 0) 성공1 실패0
    public Member memLogin(String username); //로그인체크
    public int memUpdate(Member vo); //수정하기
    public Member getMember(String memID);
    public void memProfileUpdate(Member mvo);
    public void authInsert(AuthVO saveVO);

    public void authDelete(String memID);
}
