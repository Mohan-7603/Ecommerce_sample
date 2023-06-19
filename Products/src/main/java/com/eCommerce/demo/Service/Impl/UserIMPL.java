package com.eCommerce.demo.Service.Impl;

import com.eCommerce.demo.Dto.UserDto;
import com.eCommerce.demo.Entity.User;
import com.eCommerce.demo.Repository.UserRepository;
import com.eCommerce.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserIMPL implements UserService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public String addUser(UserDto userDto) {

        User user = new User(

                userDto.getId(),
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getEmail()
        );

        userRepository.save(user);


        return user.getUsername();
    }
}
