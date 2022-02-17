package com.example.controlador;
import com.example.servicio.TakeServiceHashMap;
import com.example.dto.TaskDto;
import com.example.servicio.TaskService;
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
public class TaskController {
    private TaskService taskService;
    private HashMap<Integer,TaskDto> taskDtoHashMap;
    private List<TaskDto> task = new ArrayList<TaskDto>();

    private TaskController(@Autowired TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAll() {
        //TODO implement this method using UserService
        Set<Integer> keys = taskDtoHashMap.keySet();
        for(Integer key:keys){
            TaskDto us = taskDtoHashMap.get(key);
            task.add(us);
        }
        return new ResponseEntity<List<TaskDto>>(task, HttpStatus.OK);
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<TaskDto> findById( @PathVariable String id ) {
        //TODO implement this method using UserService
        TaskDto u = null;
        Set<Integer> keys = taskDtoHashMap.keySet();
        for(Integer key:keys){
            TaskDto us = taskDtoHashMap.get(key);
            String usId = us.getIdentificacion().toString();
            if(usId.equals(id)){
                u = us;
            }
        }
        return new ResponseEntity<TaskDto>(u,HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<TaskDto> create( @RequestBody TaskDto taskDto ) {
        //TODO implement this method using UserService
        Set<Integer> keys = taskDtoHashMap.keySet();
        Integer key = keys.size()+1;
        taskDtoHashMap.put(key,taskDto);
        taskDto.setIdentificacion(key);
        return new ResponseEntity<TaskDto>(HttpStatus.OK);
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<TaskDto> update( @RequestBody TaskDto userDto, @PathVariable String id ) {
        //TODO implement this method using UserService
        TaskDto u = null;
        Set<Integer> keys = taskDtoHashMap.keySet();
        for(Integer key:keys){
            TaskDto us = taskDtoHashMap.get(key);
            String usId = us.getIdentificacion().toString();
            if(usId.equals(id)){
                taskDtoHashMap.replace(key,userDto);
            }
        }
        return new ResponseEntity<TaskDto>(HttpStatus.OK);
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete(@PathVariable String id ) {
        //TODO implement this method using UserService
        boolean val = false;
        int tamaño = taskDtoHashMap.size();
        taskDtoHashMap.remove(id);
        if(taskDtoHashMap.size()<tamaño){
            val = true;
        }
        return new ResponseEntity<Boolean>(val,HttpStatus.OK);
    }
}