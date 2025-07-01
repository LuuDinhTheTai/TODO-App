package com.me.todoapp.service.impl;

import com.me.todoapp.entity.Todo;
import com.me.todoapp.repository.TodoRepository;
import com.me.todoapp.service.TodoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TodoServiceImpl implements TodoService {
  
  private final TodoRepository todoRepository;
  
  public TodoServiceImpl(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }
  
  @Override
  public Todo create(Todo todo) {
    return todoRepository.save(todo);
  }
  
  @Override
  public Todo find(Long id) {
    return todoRepository.findById(id);
  }
  
  @Override
  public List<Todo> list() {
    return todoRepository.findAll();
  }
  
  @Override
  public void toggle(Todo todo) {
    if (Objects.equals(todo.getStatus(), "DONE")) {
      todo.setStatus("UNDONE");
    } else {
      todo.setStatus("DONE");
    }
    todoRepository.save(todo);
  }
}
