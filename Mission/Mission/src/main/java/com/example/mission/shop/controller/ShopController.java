package com.example.mission.shop.controller;

import com.example.mission.shop.model.ShopRegister;
import com.example.mission.shop.service.ShopService;
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
public class ShopController {

    private final ShopService shopService;


    @RequestMapping("/")
    public String main() {

        return "/main";
    }

    @GetMapping("/shop/shop/register")
    public String register() {

        return "shop/shop_register";
    }

    @PostMapping("/shop/shop/register")
    public String ShopRegister(Model model, HttpServletRequest request, HttpServletResponse response
            , ShopRegister shopRegister) {


        boolean result = shopService.register(shopRegister);
        model.addAttribute("result", result);


        return "shop/shop_register_complete";
    }

}
