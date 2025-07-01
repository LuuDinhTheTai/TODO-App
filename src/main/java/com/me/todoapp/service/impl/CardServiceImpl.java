package com.me.todoapp.service.impl;

import com.me.todoapp.entity.Card;
import com.me.todoapp.repository.CardRepository;
import com.me.todoapp.repository.TodoRepository;
import com.me.todoapp.service.CardService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {
  
  private final CardRepository cardRepository;
  private final TodoRepository todoRepository;
  
  public CardServiceImpl(CardRepository cardRepository,
                         TodoRepository todoRepository) {
    this.cardRepository = cardRepository;
    this.todoRepository = todoRepository;
  }
  
  @Override
  public Card create(Card card) {
    card.setCreatedAt(LocalDate.now());
    card.setStatus("TODO");
    return cardRepository.save(card);
  }
  
  @Override
  public Card find(Long id) {
    return cardRepository.findById(id);
  }
  
  @Override
  public List<Card> list() {
    return cardRepository.findAll();
  }
  
  @Override
  public Card update(Card card) {
    card.setUpdatedAt(LocalDate.now());
    return cardRepository.save(card);
  }
  
  @Override
  public void delete(Long id) {
    cardRepository.deleteById(id);
  }
}
