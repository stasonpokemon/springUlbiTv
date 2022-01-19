package com.example.springUlbiTv.model;

import com.example.springUlbiTv.entity.ToDoEntity;

public class ToDo {
    private Long id;
    private String title;
    private Boolean completed;

    public ToDo() {
    }

    public static ToDo toModel(ToDoEntity entity) {
        ToDo toDo = new ToDo();
        toDo.setId(entity.getId());
        toDo.setTitle(entity.getTitle());
        toDo.setCompleted(entity.getCompleted());
        return toDo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
