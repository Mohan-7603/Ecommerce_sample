package com.eCommerce.demo.UserController;


import com.eCommerce.demo.Dto.UserDto;
import com.eCommerce.demo.Entity.User;
import com.eCommerce.demo.Repository.UserRepository;
import com.eCommerce.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private UserService userService;


    @PostMapping(path = "/register")
    public String saveUser(@RequestBody UserDto userDto) {

        String id = userService.addUser(userDto);
        return id;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        User user = userRepository.findByUsername(username);
        if (user != null) {
            if (passwordMatches(password, user.getPassword())) {
                return ResponseEntity.ok().body("Login successful");
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
    }

    private boolean passwordMatches(String inputPassword, String storedPassword) {
        // Compare the input password with the stored password directly
        return inputPassword.equals(storedPassword);
    }


}
