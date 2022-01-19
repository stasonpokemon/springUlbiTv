package com.example.springUlbiTv.repository;

import com.example.springUlbiTv.entity.ToDoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepo extends CrudRepository<ToDoEntity, Long> {
}
