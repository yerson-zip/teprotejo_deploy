package com.teprotejo.mapper;

import com.teprotejo.dto.RegisterRequest;
import com.teprotejo.dto.UserDto;
import com.teprotejo.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-06T22:52:24-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setName( user.getName() );
        userDto.setLast_name( user.getLast_name() );
        userDto.setTel( user.getTel() );
        userDto.setEmail( user.getEmail() );
        userDto.setDirection( user.getDirection() );
        userDto.setCity( user.getCity() );

        return userDto;
    }

    @Override
    public User RegisterUser(RegisterRequest registerRequest) {
        if ( registerRequest == null ) {
            return null;
        }

        User user = new User();

        user.setName( registerRequest.getName() );
        user.setLast_name( registerRequest.getLast_name() );
        user.setTel( registerRequest.getTel() );
        user.setEmail( registerRequest.getEmail() );
        user.setPassword( registerRequest.getPassword() );
        user.setDirection( registerRequest.getDirection() );
        user.setCity( registerRequest.getCity() );

        return user;
    }
}
