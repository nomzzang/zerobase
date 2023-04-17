package com.example.mission.controller;

import com.example.mission.Model.ShopRegister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class ShopController {

    @RequestMapping("/")
    public String main() {

        return "/main";
    }

    @GetMapping("/shop/register")
    public String register() {

        System.out.println("get");
        return "/shop/register";
    }

    @PostMapping("/shop/register")
    public String ShopRegister(Model model, HttpServletRequest request, HttpServletResponse response
    , ShopRegister shopRegister){

        System.out.println(shopRegister.toString());
//
//        String userId = request.getParameter("userId");
//        String shopName = request.getParameter("shopName");
//        String shopLocation = request.getParameter("shopLocation");
//        String shopBriefly = request.getParameter("shopBriefly");
//        String shopContact = request.getParameter("shopContact");
//
//        System.out.println(userId);
//        System.out.println(shopName);
//        System.out.println(shopLocation);
//        System.out.println(shopBriefly);
//        System.out.println(shopContact);

        return "shop/register";
    }

}
