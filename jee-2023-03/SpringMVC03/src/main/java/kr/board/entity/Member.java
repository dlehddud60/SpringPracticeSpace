package kr.board.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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


}
