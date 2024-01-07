package kr.co.sloop.security;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/** 접근이 제한된 후 다양한 처리를 위해 인터페이스를 직접 구현한다.
접근 제한된 후 쿠키나 세션에 특정 작업을 하거나 HttpServletResponse에 특정 헤더 정보를 추가하는 등*/
@Log4j2
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        log.info("----------접근제한 실행 됨----------");
        /** 서블릿 API를 이용하는 처리가 가능 (HttpServletRequest,Response를 사용하기 때문)*/
        
        log.error("Access Denied Handler");

        log.error("Redirect ......");

        /** 접근 제한이 걸리면 리다이렉트 하는 방식으로 설정
            이후 CustomAccessDeniedHandler 를
            security-context.xml에 빈으로 등록 */

        response.sendRedirect("common/accessError");
    }
}
