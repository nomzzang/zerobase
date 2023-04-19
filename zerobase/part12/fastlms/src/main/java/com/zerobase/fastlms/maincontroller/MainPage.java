package com.zerobase.fastlms.maincontroller;

//MainPage 클래스를 만든 목적!!
// 매핑하기 위해서
// 주소(논리적인주소 인터넷주소)와 물리적인(프래그래밍을 해야 하니까) 파일 매핑
// 하나의 주소에서 대해서 어디서 매핑? 누가 매핑?
// 후보군? 클래스, 속성, 메소드

import com.zerobase.fastlms.components.Mailcomponents;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RequiredArgsConstructor
@Controller
public class MainPage {

    private final Mailcomponents mailComponents;

    @RequestMapping("/")
    public String index() {
//        String email = "starnomzzang@naver.com";
//        String subject = "하이루";
//        String text = "<p> 안녕하세요 . </p> <p> 반갑다 </p>";
//
//        mailComponents.sendMail(email, subject, text);

        return "index";
    }

// RequestMapping 에서는 리턴값으로 index.html로 반환이 된다 그래서 resources에 templates에 index.html을 만들어줘야한다.

//    @RequestMapping("/")
//    public String index(){
//
//
//        // return temaplates에 이름.html 로 만들어 줘야한다.
//        return "index";
//    }


    // 스프링 -> MVC (View -> 템플릿 엔진 화면에 내용을 출력(html))
    // .net -> MVC (View -> 출력)
    // python django -> MTV(Template -> 화면출력)
    // 백엔드과정 -> V(화면에 보여진 부분) -> 프론트엔드과정
    // V - > HTML ==> 웹페이지
    // v -> JSON ==> API
    // request -> WEB -> SERVER
    // response -> WEB
    @RequestMapping("/hello")
    public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter printWriter = response.getWriter();

        String msg = "<html>" +
                "<head>" +
                "<meta charset='UTF-8'>" +
                "</head>" +
                "<body>" +
                "<p>hello</p> <p>fastlms website!!!</p>" +
                "<p> 안녕하세요!!!</p>" +
                "</body>" +
                "</html>";

        printWriter.write(msg);
        printWriter.close();

    }


    @RequestMapping("/error/denied")
    public String errorDenied(){

        return "error/denied";
    }

}