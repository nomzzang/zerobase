package com.example.mission.shop.service;

import com.example.mission.shop.entity.Shop;
import com.example.mission.shop.form.ShopDto;
import com.example.mission.shop.model.ShopRegister;

import java.util.List;

public interface ShopService {

    List<ShopDto> selectAll();

    boolean register(ShopRegister shopRegister);



}
