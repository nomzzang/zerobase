package com.example.mission.service;

import com.example.mission.entity.Shop;
import com.example.mission.model.ShopRegister;
import com.example.mission.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ShopServiceImpl implements ShopService{

    private final ShopRepository shopRepository;

    @Override
    public boolean register(ShopRegister shopRegister){

        Optional<Shop> optionalShop = shopRepository.findById(shopRegister.getUserId());
        if (optionalShop.isPresent()){
            return false;
        }


        Shop shop = new Shop();
        shop.setUserId(shopRegister.getUserId());
        shop.setShopName(shopRegister.getShopName());
        shop.setShopLocation(shopRegister.getShopLocation());
        shop.setShopBriefly(shopRegister.getShopBriefly());
        shop.setShopContact(shopRegister.getShopContact());
        shop.setRegDt(LocalDateTime.now());

        shopRepository.save(shop);

        return false;
    }
}
