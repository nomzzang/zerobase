package com.example.mission.shop.service;

import com.example.mission.shop.dto.ShopDto;
import com.example.mission.shop.entity.Shop;
import com.example.mission.shop.model.ShopRegister;

import java.util.List;
import java.util.Optional;

public interface ShopService {

    List<ShopDto> selectAll();

//    Optional<Shop> selectOneById(String Id);

    boolean register(ShopRegister shopRegister);





}
