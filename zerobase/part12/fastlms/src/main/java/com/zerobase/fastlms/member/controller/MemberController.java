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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String registerSubmit(Model model, HttpServletRequest request, HttpServletResponse response
    , MemberInput parameter) {

          boolean result = memberService.register(parameter);
          model.addAttribute("result", result);



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



    //http://www.naver.com/news.list.do?id=123
    //프로토콜

    @GetMapping("/member/email-auth")
    public String emailAuth(Model model, HttpServletRequest request){

        String uuid = request.getParameter("id");
        System.out.println(uuid);

        boolean result = memberService.emailAuth(uuid);
        model.addAttribute("result", result);


        return "member/email_auth";
    }

    @GetMapping("member/info")
    public String memberInfo() {

        return "member/info";
    }

}
