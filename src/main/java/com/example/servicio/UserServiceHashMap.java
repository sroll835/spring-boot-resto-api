package com.example.servicio;

import com.example.dto.UserDto;

import java.util.HashMap;
import com.example.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserServiceHashMap {

    private final HashMap<String,UserDto> userServices;

    public UserServiceHashMap(){
        userServices = new HashMap<String,UserDto>();
    }

    public HashMap<String, UserDto> getUserServices() {
        return userServices;
    }
}
