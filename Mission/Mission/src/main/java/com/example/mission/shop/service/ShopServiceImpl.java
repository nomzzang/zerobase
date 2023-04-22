package com.example.mission.shop.service;

import com.example.mission.mapper.ShopMapper;
import com.example.mission.shop.entity.Shop;
import com.example.mission.shop.form.ShopDto;
import com.example.mission.shop.model.ShopRegister;
import com.example.mission.shop.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class ShopServiceImpl implements ShopService{

    private final ShopRepository shopRepository;

    @Override
    public List<ShopDto> selectAll() {
        List<Shop> shops = shopRepository.findAll();
        return ShopMapper.convertToDtoList(shops);

        }

    @Override
    public boolean register(ShopRegister shopRegister){

        Optional<Shop> optionalShop = shopRepository.findById(shopRegister.getShopId());
        if (optionalShop.isPresent()){
            return false;
        }
        Shop shop = new Shop();
        shop.setShopId(shopRegister.getShopId());
        shop.setShopName(shopRegister.getShopName());
        shop.setShopLocation(shopRegister.getShopLocation());
        shop.setShopBriefly(shopRegister.getShopBriefly());
        shop.setShopContact(shopRegister.getShopContact());
        shop.setRegDt(LocalDateTime.now());
        shopRepository.save(shop);

        return true;
    }
}
