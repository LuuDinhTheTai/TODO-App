package com.me.todoapp.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Todo {
    
    private Long id;
    private String description;
    private String status;
    
    public Todo(String description) {
        this.description = description;
        this.status = TodoStatus.UNDONE.name();
    }
    
    private enum TodoStatus {
        UNDONE,
        DONE,
    }
}