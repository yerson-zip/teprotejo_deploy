package com.teprotejo.mapper;

import com.teprotejo.dto.RegisterRequest;
import com.teprotejo.dto.UserDto;
import com.teprotejo.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userToUserDto(User user);


    User RegisterUser(RegisterRequest registerRequest);


}
