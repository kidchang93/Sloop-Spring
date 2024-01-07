package kr.co.sloop.security;



import kr.co.sloop.member.domain.MemberDTO;
import kr.co.sloop.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Log4j2
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {


  private final MemberMapper memberMapper;
  @Override
  public UserDetails loadUserByUsername(String memberEmail) throws UsernameNotFoundException {

    return null;
  }


}
