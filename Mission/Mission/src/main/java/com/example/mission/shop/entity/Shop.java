package com.example.mission.shop.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Shop {

    @Id
    private String shopId;

    private String shopName;
    private String shopLocation;
    private String shopBriefly;
    private String shopContact;

    private LocalDateTime regDt;



}
