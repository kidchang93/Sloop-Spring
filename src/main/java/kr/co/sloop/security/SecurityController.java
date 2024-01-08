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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@Log4j2
@Controller
@RequiredArgsConstructor
public class SecurityController {


    private final PasswordEncoder passwordEncoder;

    private final MemberMapper memberMapper;

    @GetMapping("/accessError")
    public String accessDenied(HttpServletResponse response , Authentication auth , Model model){
        log.info("auth = {}" , auth);
        model.addAttribute("msg","접근권한이 없습니다. 올바른 페이지로 이동하세요.");
        return "accessError";
    }
}
