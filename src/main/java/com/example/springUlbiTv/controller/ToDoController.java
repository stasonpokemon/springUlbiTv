package com.example.springUlbiTv.controller;

import com.example.springUlbiTv.entity.ToDoEntity;
import com.example.springUlbiTv.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("todos")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @PostMapping
    public ResponseEntity createToDo(@RequestBody ToDoEntity toDo, @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(toDoService.createToDo(toDo,userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping("{id}")
    public ResponseEntity completeToDo(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(toDoService.completeToDo(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
