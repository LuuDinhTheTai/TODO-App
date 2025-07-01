package com.me.todoapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card {

  private Long id;
  private String title;
  private String description;
  private LocalDate createdAt;
  private LocalDate updatedAt;
  private LocalDate dueDate;
  private List<Todo> todos;
  private String status;
  
  private enum CardStatus {
    TODO,
    DOING,
    DONE,
  }
}
