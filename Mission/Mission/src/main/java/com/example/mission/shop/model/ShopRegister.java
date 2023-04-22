package com.example.mission.shop.model;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ShopRegister {

    private String shopId;
    private String shopPassword;

    private String shopName;
    private String shopLocation;
    private String shopBriefly;
    private String shopContact;
}
