package com.zerobase.fastlms.member.controller;

import com.zerobase.fastlms.member.entity.Member;
import com.zerobase.fastlms.member.model.MemberInput;
import com.zerobase.fastlms.member.repository.MemberRepository;
import com.zerobase.fastlms.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;


@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;



//    }
    //@GetMapping("member/register")
    @RequestMapping(value = "/member/register", method = RequestMethod.GET)
    public String register(){

        System.out.println("request get!");

        return "member/register";
    }


    // request WEB -> SERBER
    // response SERVER -> WEB
    @PostMapping(value = "/member/register")
    public String registerSubmit(HttpServletRequest request, HttpServletResponse response
    , MemberInput parameter) {

          boolean result = memberService.register(parameter);


//
//        String userId = request.getParameter("userId");
//        String userName = request.getParameter("userName");
//        String password = request.getParameter("password");
//        String phone = request.getParameter("phone");
//
//        System.out.println("userId = " + userId);
//        System.out.println("userName = " + userName);
//        System.out.println("password = " + password);
//        System.out.println("phone = " + phone);

        return "member/register_complete";
    }
}
