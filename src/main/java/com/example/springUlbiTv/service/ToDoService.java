package com.example.springUlbiTv.service;

import com.example.springUlbiTv.entity.ToDoEntity;
import com.example.springUlbiTv.entity.UserEntity;
import com.example.springUlbiTv.model.ToDo;
import com.example.springUlbiTv.repository.ToDoRepo;
import com.example.springUlbiTv.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepo toDoRepo;

    @Autowired
    private UserRepo userRepo;

    public ToDo createToDo(ToDoEntity toDo, Long userId) {
        UserEntity user = userRepo.findById(userId).get();
        toDo.setUser(user);
        return ToDo.toModel(toDoRepo.save(toDo));
    }

    public ToDo completeToDo(Long id) {
        ToDoEntity toDo = toDoRepo.findById(id).get();
        toDo.setCompleted(!toDo.getCompleted());
        return ToDo.toModel(toDoRepo.save(toDo));
    }


}
