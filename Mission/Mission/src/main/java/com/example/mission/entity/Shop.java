package com.example.mission.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Shop {

    @Id
    private String userId;

    private String shopName;
    private String shopLocation;
    private String shopBriefly;
    private String shopContact;



}
