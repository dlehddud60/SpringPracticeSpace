package kr.board.mapper;

import kr.board.entity.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    public Member registerCheck(String memID);
    public int register(Member m); //회원등록(1, 0) 성공1 실패0
    public Member memLogin(Member mvo); //로그인체크

}
