package com.me.todoapp.service;

import com.me.todoapp.entity.Card;

import java.util.List;

public interface CardService {
  
  Card create(Card card);
  Card find(Long id);
  List<Card> list();
  Card update(Card card);
  void delete(Long id);
}
