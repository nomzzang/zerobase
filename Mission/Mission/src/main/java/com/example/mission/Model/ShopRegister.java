package com.example.mission.Model;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ShopRegister {

    private String userId;

    private String shopName;
    private String shopLocation;
    private String shopBriefly;
    private String shopContact;
}
