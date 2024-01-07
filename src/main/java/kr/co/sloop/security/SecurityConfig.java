package kr.co.sloop.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin();
        http.authorizeRequests()
                .antMatchers("/member/login").permitAll()
                .antMatchers("/member/memberList").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/member/mypage").access("hasRole('ROLE_MEMBER')");
    }
}
