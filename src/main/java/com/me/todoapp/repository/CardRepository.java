package com.me.todoapp.repository;

import com.me.todoapp.entity.Card;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CardRepository {
  
  private final Map<Long, Card> cards = new HashMap<>();
  private final AtomicLong idCounter = new AtomicLong();

  public Card save(Card card) {
    if (card.getId() == null) {
      card.setId(idCounter.incrementAndGet());
    }
    cards.put(card.getId(), card);
    return card;
  }
  
  public Card findById(Long id) {
    return cards.get(id);
  }
  
  public List<Card> findAll() {
    return new ArrayList<>(cards.values());
  }
  
  public void deleteById(Long id) {
    cards.remove(id);
  }
}
