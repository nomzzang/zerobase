package com.example.mission.user.model;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Data
public class UserRegister {

    private String userId;
    private String userPassword;
    private String userName;
    private String userAge;
    private String userSex;
    private String userContact;

}
