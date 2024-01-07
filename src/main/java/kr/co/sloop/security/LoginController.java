package kr.co.sloop.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
@Log4j2
public class LoginController {

    @GetMapping("/login")
    public String LoginForm(Principal principal , HttpServletRequest request , Model model){
        log.info("Principal = " + principal);
        HttpSession session = request.getSession();
        if (session.getAttribute("loginFailMsg") != null){
            model.addAttribute("loginFailMsg" , session.getAttribute("loginFailMsg"));
            session.removeAttribute("loginFailMsg");
        }
        return "member/loginForm";

    }

}
