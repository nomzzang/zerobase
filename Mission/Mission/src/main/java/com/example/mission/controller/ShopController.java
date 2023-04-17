package com.example.mission.controller;

import com.example.mission.entity.Shop;
import com.example.mission.model.ShopRegister;
import com.example.mission.repository.ShopRepository;
import com.example.mission.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;


@RequiredArgsConstructor
@Controller
public class ShopController {

    private final ShopService shopService;



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

        boolean result = shopService.register(shopRegister);
        model.addAttribute("result", result);

        return "shop/register_complete";
    }

}
