package kr.board.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class Member {
    private int memIdx;
    private String memID;
    private String memPassword;
    private String memName;
    private int memAge;
    private String memGender;
    private String memEmail;
    private String memProfile;
    private List<AuthVO> authList;


}
