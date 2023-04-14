package com.zerobase.fastlms;

//MainPage 클래스를 만든 목적!!
// 매핑하기 위해서
// 주소(논리적인주소 인터넷주소)와 물리적인(프래그래밍을 해야 하니까) 파일 매핑
// 하나의 주소에서 대해서 어디서 매핑? 누가 매핑?
// 후보군? 클래스, 속성, 메소드

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainPage {
    @RequestMapping("/")
    public String index(){

        return "Index Page";
    }
    @RequestMapping("/hello")
    public String hello(){

        String msg = "<p>hello</p>  <p>Fastlms webpage!!</p>";

        return msg;
    }
}
