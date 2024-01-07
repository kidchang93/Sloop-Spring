package kr.co.sloop.security;

import kr.co.sloop.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;

@Log4j2
@Controller
@RequiredArgsConstructor
public class SecurityController {


    private final PasswordEncoder passwordEncoder;

    private final MemberMapper memberMapper;

    @GetMapping("/accessError")
    public void accessDenied(HttpServletResponse response , Authentication auth , Model model){
        log.info("auth = {}" , auth);
    }

}
