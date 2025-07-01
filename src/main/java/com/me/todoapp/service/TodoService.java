package com.me.todoapp.service;

import com.me.todoapp.entity.Todo;

import java.util.List;

public interface TodoService {
  
  Todo create(Todo todo);
  Todo find(Long id);
  List<Todo> list();
  void toggle(Todo todo);
}
