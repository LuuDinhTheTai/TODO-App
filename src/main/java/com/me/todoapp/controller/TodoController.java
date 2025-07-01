package com.me.todoapp.controller;

import com.me.todoapp.entity.Todo;
import com.me.todoapp.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("todos", todoService.list());
        model.addAttribute("newTodo", new Todo());
        return "index";
    }

    @PostMapping
    public String create(@ModelAttribute Todo todo) {
        todoService.create(todo);
        return "redirect:/";
    }

    @PostMapping("toggle/{id}")
    public String toggle(@PathVariable Long id) {
        todoService.toggle(todoService.find(id));
        return "redirect:/";
    }
}
