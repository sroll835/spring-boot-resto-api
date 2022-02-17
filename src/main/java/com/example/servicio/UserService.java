package com.example.servicio;

import com.example.dto.UserDto;
import java.util.List;

public interface UserService {

    UserDto create(UserDto user );

    UserDto findById( String id );

    List<UserDto> getAll();

    void deleteById( String id );

    UserDto update( UserDto userDto, String userId );


}