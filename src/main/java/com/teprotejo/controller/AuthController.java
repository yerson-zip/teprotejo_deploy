package com.teprotejo.controller;

import com.teprotejo.dto.RegisterRequest;
import com.teprotejo.dto.UserDto;
import com.teprotejo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {


    private final UserService userService;


    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest registerRequest) {
        HttpStatus response = userService.registerUser(registerRequest) ? HttpStatus.OK : HttpStatus.NOT_FOUND;

        return ResponseEntity.status(response).build();

    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, Object> data){

        String email =  (String) data.get("email");
        String password = (String) data.get("password");

        UserDto user = userService.loginUser(email, password);

        HttpStatus response = user!=null ? HttpStatus.OK : HttpStatus.NOT_FOUND;

        return ResponseEntity.status(response).body(user);


    }


}
