package com.example.mission.shop.controller;

import com.example.mission.shop.dto.ShopDto;
import com.example.mission.shop.entity.Shop;
import com.example.mission.shop.model.ShopParam;
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
import java.util.List;
import java.util.Optional;


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
    public String ShopRegister(Model model,ShopRegister shopRegister) {


        boolean result = shopService.register(shopRegister);
        model.addAttribute("result", result);

        return "shop/shop_register_complete";
    }

    @GetMapping("/shop/shop/main")
    public String ShopMain() {

        return "shop/shop_main";
    }
    @GetMapping("/shop/shop-list")
    public String ShopList(Model model, ShopParam shopParam) {


        // 전체 자료 출력
//        if(shopParam.getSearchType().equals("all") && shopParam.getSearchValue().equals("")){
//            System.out.println("모든데이터 출력");
//            List<ShopDto> shopDtoList = shopService.selectAll();
//            model.addAttribute("shops", shopDtoList);
//        } else {

            List<ShopDto> shopDtoList = shopService.selectAll();
            model.addAttribute("shops", shopDtoList);

//        }
//        else {
//            Optional<Shop> Optional = shopService.selectOneById(shopParam.getSearchValue());
//        }


        return "shop/shop_list";
    }



}
