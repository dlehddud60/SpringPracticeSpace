package kr.board.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class AuthVO {
    private int no; //일련번호
    private String memID; //회원 아이디
    private String auth; //회원권한(3가지 부여)
}
