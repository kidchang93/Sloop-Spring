package kr.co.sloop.security;

import kr.co.sloop.member.service.impl.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/register")
@Log4j2
public class RegisterController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public String signupForm(@ModelAttribute RegisterFormDTO registerFormDTO) {
        log.info("registerFormDTO = {}", registerFormDTO);
        return "member/signupForm";
    }

    @PostMapping
    public String signup(@Validated @ModelAttribute RegisterFormDTO registerFormDTO,
                         BindingResult bindingResult , Model model){
        log.info("registerFormDTO = {}" , registerFormDTO);

        // 비밀번호 입력은 두번 하게 해서 검사하는 유효성 검사 진행

        if (bindingResult.hasErrors()){
            log.info("registerFormDTO has Errors!");
            bindingResult.addError(new FieldError("registerFormDTO" ,"global Error" ,
                    "회원가입 양식에 맞게 모든 값을 입력해주세요."));
            return "member/signupForm";
        }

        // 비밀번호 암호화

        registerFormDTO.setMemberPassword(passwordEncoder.encode(registerFormDTO.getMemberPassword()));
        int registerResult = memberService.signup(registerFormDTO);
        if (registerResult > 0) {
            log.info("회원가입 성공");
            return "redirect:/login";
        } else {
            return "member/signupForm";
        }

    }

}
