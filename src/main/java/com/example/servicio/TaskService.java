package com.example.servicio;

import com.example.datos.Task;
import com.example.dto.TaskDto;

import java.util.*;

public interface TaskService {

    Task create( Task task );

    Task findById( String id );

    List<Task> getAll();

    boolean deleteById( String id );

    Task update( TaskDto taskDto, String id );
}