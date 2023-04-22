package com.example.mission.user.service;

import com.example.mission.user.model.UserRegister;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


public interface UserService extends UserDetailsService {

    boolean register(UserRegister userRegister);
}
