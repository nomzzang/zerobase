package com.example.mission.user.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {

    @Id
    private String userId;
    private String userPassword;

    private String userName;
    private String userAge;
    private String userSex;
    private String userContact;

    private LocalDateTime regDt;



}
