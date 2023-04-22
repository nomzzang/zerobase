package com.example.mission.user.service;

import com.example.mission.user.entity.User;
import com.example.mission.user.model.UserRegister;
import com.example.mission.user.repository.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Builder
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public boolean register(UserRegister userRegister) {

        Optional<User> optionalUser = userRepository.findById(userRegister.getUserId());
        if (optionalUser.isPresent()) {
            return false;
        }

        String encPassword = BCrypt.hashpw(userRegister.getUserPassword(), BCrypt.gensalt());


        User user = new User();
        user.setUserId(userRegister.getUserId());
        user.setUserPassword(encPassword);
        user.setUserName(userRegister.getUserName());
        user.setUserAge(userRegister.getUserAge());
        user.setUserSex(userRegister.getUserSex());
        user.setUserContact(userRegister.getUserContact());
        user.setRegDt(LocalDateTime.now());

        userRepository.save(user);

        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        Optional<User> optionalUser = userRepository.findById(userId);
        if (!optionalUser.isPresent()) {
            throw new UsernameNotFoundException(" 아이디가 존재 하지 않습니다~ ");
        }

        User user = optionalUser.get();

        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new org.springframework.security.core.userdetails.User(user.getUserId(), user.getUserPassword(), grantedAuthorityList);
    }
}
