package com.example.mission.user.service;

import com.example.mission.user.entity.User;
import com.example.mission.user.model.UserRegister;
import com.example.mission.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public boolean register(UserRegister userRegister){

        Optional<User> optionalShop = userRepository.findById(userRegister.getUserId());
        if (optionalShop.isPresent()){
            return false;
        }


        User user = new User();
        user.setUserId(userRegister.getUserId());
        user.setUserName(userRegister.getUserName());
        user.setUserAge(userRegister.getUserAge());
        user.setUserSex(userRegister.getUserSex());
        user.setUserContact(userRegister.getUserContact());
        user.setRegDt(LocalDateTime.now());

        userRepository.save(user);

        return true;
    }
}
