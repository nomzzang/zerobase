package com.example.mission.user.controller;

import com.example.mission.user.model.UserRegister;
import com.example.mission.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

//
//    @RequestMapping("/")
//    public String main() {
//
//        return "/main";
//    }

    @GetMapping("/user/user/register")
    public String register() {

        return "user/user_register";
    }

    @PostMapping("/user/user/register")
    public String UserRegister(Model model, HttpServletRequest request, HttpServletResponse response
            , UserRegister userRegister) {


        boolean result = userService.register(userRegister);
        model.addAttribute("result", result);


        return "user/user_register_complete";
    }
    @GetMapping("/user/user/main")
    public String UserMain() {

        return "user/user_main";
    }


    @RequestMapping("/user/user/login")
    public String UserLogin() {

        System.out.println("로그인 실행 ");
        return "user/user_login";
    }

}
