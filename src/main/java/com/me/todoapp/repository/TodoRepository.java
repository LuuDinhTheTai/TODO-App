package com.me.todoapp.repository;

import com.me.todoapp.entity.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TodoRepository {
    
    private final Map<Long, Todo> todos = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong();
    
    public Todo save(Todo todo) {
        if (todo.getId() == null) {
            todo.setId(idCounter.incrementAndGet());
        }
        todos.put(todo.getId(), todo);
        return todo;
    }

    public List<Todo> findAll() {
        return new ArrayList<>(todos.values());
    }

    public Todo findById(Long id) {
        return todos.get(id);
    }
    
    public Todo update(Todo todo) {
        Todo exits = todos.get(todo.getId());
        if (exits != null) {
            exits.setDescription(todo.getDescription());
            exits.setStatus(todo.getStatus());
            todos.put(exits.getId(), exits);
        }
        return todo;
    }

    public void deleteById(Long id) {
        todos.remove(id);
    }

}