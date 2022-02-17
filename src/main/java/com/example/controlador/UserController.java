package com.example.controlador;
import com.example.servicio.UserServiceHashMap;
import com.example.dto.UserDto;
import com.example.servicio.UserService;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.HashMap;

@RestController
@RequestMapping( "/v1/user")
public class UserController
{
    private final UserService userService;
    private HashMap<Integer,UserDto> userDtoHashMap;
    private List<UserDto> users = new ArrayList<UserDto>();

    private UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        //TODO implement this method using UserService
        Set<Integer> keys = userDtoHashMap.keySet();
        for(Integer key:keys){
            UserDto us = userDtoHashMap.get(key);
            users.add(us);
        }
        return new ResponseEntity<List<UserDto>>(users, HttpStatus.OK);
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<UserDto> findById( @PathVariable String id ) {
        //TODO implement this method using UserService
        UserDto u = null;
        Set<Integer> keys = userDtoHashMap.keySet();
        for(Integer key:keys){
            UserDto us = userDtoHashMap.get(key);
            String usId = us.getIdentificacion().toString();
            if(usId.equals(id)){
                u = us;
            }
        }
        return new ResponseEntity<UserDto>(u,HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<UserDto> create( @RequestBody UserDto userDto ) {
        //TODO implement this method using UserService
        Set<Integer> keys = userDtoHashMap.keySet();
        Integer key = keys.size()+1;
        userDtoHashMap.put(key,userDto);
        userDto.setIdentificacion(key);
        return new ResponseEntity<UserDto>(HttpStatus.OK);
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<UserDto> update( @RequestBody UserDto userDto, @PathVariable String id ) {
        //TODO implement this method using UserService
        UserDto u = null;
        Set<Integer> keys = userDtoHashMap.keySet();
        for(Integer key:keys){
            UserDto us = userDtoHashMap.get(key);
            String usId = us.getIdentificacion().toString();
            if(usId.equals(id)){
                userDtoHashMap.replace(key,userDto);
            }
        }
        return new ResponseEntity<UserDto>(HttpStatus.OK);
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete(@PathVariable String id ) {
        //TODO implement this method using UserService
        boolean val = false;
        int tamaño = userDtoHashMap.size();
        userDtoHashMap.remove(id);
        if(userDtoHashMap.size()<tamaño){
            val = true;
        }
        return new ResponseEntity<Boolean>(val,HttpStatus.OK);
    }
}