package kr.co.sloop.security;

import kr.co.sloop.member.domain.MemberAuthDTO;
import kr.co.sloop.member.domain.MemberDTO;
import lombok.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
public class LoginUserDTO extends User {
    private static final long serialVersionUID = 1L;

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
    private String authority;            // 회원 권한

    public LoginUserDTO(MemberVO memberVO, List<SimpleGrantedAuthority> authorityList){
        super(memberVO.getMemberEmail(),memberVO.getMemberPassword(),authorityList);

        this.memberIdx = memberVO.getMemberIdx();
        this.memberEmail = memberVO.getMemberEmail();
        this.memberPassword = memberVO.getMemberPassword();
        this.memberNickname = memberVO.getMemberNickname();
        this.memberGender = memberVO.getMemberGender();
        this.memberRegdate = memberVO.getMemberRegdate();
        this.memberPhonenumber = memberVO.getMemberPhonenumber();
        this.memberSchool = memberVO.getMemberSchool();
        this.memberGradeCode = memberVO.getMemberGradeCode();
        this.memberSubjectCode = memberVO.getMemberSubjectCode();
        this.memberRegionCode = memberVO.getMemberRegionCode();
        this.authority = memberVO.getAuthority();

    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberVO{

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
        private String authority;            // 회원 권한

        public List<SimpleGrantedAuthority> getAuthorityList(){
            List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
            authorityList.add(new SimpleGrantedAuthority(this.getAuthority()));
            return authorityList;
        }   // ResultMap을 이용해 authDTO까지 처리하게 해주는 ListDTO
    }
}
