package com.example.mission.configuration;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        setUseForward(true);
        setDefaultFailureUrl("/main");
        request.setAttribute("errorMessage", "로그인에 실패하였습니다.");

        System.out.println("로그인 실패 ");
        super.onAuthenticationFailure(request, response, exception);

    }
}
