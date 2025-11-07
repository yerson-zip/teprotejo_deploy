package com.teprotejo.service;

import com.teprotejo.dto.RegisterRequest;
import com.teprotejo.dto.UserDto;
import com.teprotejo.entity.User;
import com.teprotejo.mapper.UserMapper;
import com.teprotejo.repository.UserRepository;
import com.teprotejo.segurity.SegurityUtil;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;



    private final UserMapper userMapper;


    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;

        this.userMapper = userMapper;
    }

    //Este metodo registra los usuarios
    public Boolean registerUser(@NotNull RegisterRequest request) {


        if(userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("El correo ya está registrado");
        }




        User user = userMapper.RegisterUser(request);

        user.setPassword(SegurityUtil.hashPassword(request.getPassword()));


        userRepository.save(user);

        return true;

    }



    public UserDto loginUser(String email, String password) {

        Optional<User> user = userRepository.findByEmail(email);

        if (user.isEmpty()) return null;

        if(SegurityUtil.validePassword(password, user.get().getPassword()))
            return userMapper.userToUserDto(user.get());


        return null;

    }

}
