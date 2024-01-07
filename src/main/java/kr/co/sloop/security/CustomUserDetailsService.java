package kr.co.sloop.security;




import kr.co.sloop.member.domain.MemberDTO;
import kr.co.sloop.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.StringUtils;

@Log4j2
public class CustomUserDetailsService implements UserDetailsService {

@Autowired
  private MemberMapper memberMapper;
  @Override
  public UserDetails loadUserByUsername(String memberEmail) throws UsernameNotFoundException {

    log.warn("loadUserByUserName = " + memberEmail);

    if (!StringUtils.hasText(memberEmail)){
      throw new UsernameNotFoundException("이메일을 입력해주세요.");
    }

    MemberDTO dto = new MemberDTO();
    String type = dto.getAuthority();
    LoginUserDTO.MemberVO result = null;

    if (type.equals("ROLE_ADMIN")){
      result = memberMapper.AdminLogin(memberEmail);
    } else if (type.equals("ROLE_MEMBER")){
      result = memberMapper.MemberLogin(memberEmail);
    } else {
      throw new UsernameNotFoundException("아무런 권한이 부여되지 않은 회원입니다.");
    }

    if (result != null){
      LoginUserDTO.MemberVO memberVO = LoginUserDTO.MemberVO.builder()
              .memberIdx(result.getMemberIdx())
              .memberEmail(result.getMemberEmail())
              .memberNickname(result.getMemberNickname())
              .memberGender(result.getMemberGender())
              .memberRegdate(result.getMemberRegdate())
              .memberPhonenumber(result.getMemberPhonenumber())
              .memberSchool(result.getMemberSchool())
              .memberGradeCode(result.getMemberGradeCode())
              .memberSubjectCode(result.getMemberSubjectCode())
              .memberRegionCode(result.getMemberRegionCode())
              .authority(result.getAuthority())
              .build();
      return new LoginUserDTO(memberVO, memberVO.getAuthorityList());
    } else {

      /** 기존에는 password만을 읽어서 판별했지만 아이디조차 없는 경우 해당 예외를 처리 */
      throw new UsernameNotFoundException("일치하는 사용자가 없습니다." + memberEmail);
    }
  }
}
