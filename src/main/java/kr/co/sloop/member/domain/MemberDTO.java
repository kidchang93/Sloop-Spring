package kr.co.sloop.member.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.Valid;
import java.util.Date;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class MemberDTO {
    private int memberIdx;              // '회원 index',

    private String memberEmail;         // '회원 이메일',
    private String memberPassword;      //'회원 비밀번호',
    private String memberNickname;      // '회원 닉네임',
    private String memberGender;        //	'회원 성별',
    private Date memberRegdate;         // '회원가입 날짜',
    private String memberPhonenumber;   // '회원 핸드폰번호',
    private String memberSchool;        // '회원 학교',
    private String memberGradeCode;        // '학년 카테고리 코드',
    private String memberSubjectCode;      // '과목 카테고리 코드',
    private String memberRegionCode;       // '지역 카테고리 코드',
}
