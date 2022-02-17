package com.example.servicio;

import com.example.dto.TaskDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class TakeServiceHashMap {

    private HashMap<Integer,TaskDto> taskDtoHashMap;

    public TakeServiceHashMap(HashMap<Integer, TaskDto> taskDtoHashMap) {
        taskDtoHashMap = new HashMap<Integer,TaskDto>();
    }
}