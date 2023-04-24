package com.example.mission.mapper;

import com.example.mission.shop.entity.Shop;
import com.example.mission.shop.dto.ShopDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShopMapper {
    public static ShopDto convertToDto(Shop shop) {
        ShopDto shopDto = new ShopDto();
        shopDto.setShopName(shop.getShopName());
        shopDto.setShopLocation(shop.getShopLocation());
        shopDto.setShopBriefly(shop.getShopBriefly());
        shopDto.setShopContact(shop.getShopContact());

        return shopDto;
    }

    public static List<ShopDto> convertToDtoList(List<Shop> shops) {
        List<ShopDto> shopDtoList = new ArrayList<>();
        for (Shop shop : shops) {
            shopDtoList.add(convertToDto(shop));
        }
        return shopDtoList;
    }

    public static List<ShopDto> convertToDtoLists(List<Shop> shops) {
        List<ShopDto> shopDtoList = new ArrayList<>();
        for (Shop shop : shops) {
            shopDtoList.add(convertToDto(shop));
        }
        return shopDtoList;
    }
}