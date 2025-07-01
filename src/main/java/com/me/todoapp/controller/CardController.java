package com.me.todoapp.controller;

import com.me.todoapp.entity.Card;
import com.me.todoapp.service.CardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cards")
public class CardController {

  private final CardService cardService;

  public CardController(CardService cardService) {
    this.cardService = cardService;
  }

  @GetMapping
  public String index(Model model) {
    List<Card> cards = cardService.list();

    List<Card> todoCards = new ArrayList<>();
    List<Card> doingCards = new ArrayList<>();
    List<Card> doneCards = new ArrayList<>();
    for (Card card : cards) {
      if ("TODO".equals(card.getStatus())) {
        todoCards.add(card);
      } else if ("DOING".equals(card.getStatus())) {
        doingCards.add(card);
      } else if ("DONE".equals(card.getStatus())) {
        doneCards.add(card);
      }
    }
    model.addAttribute("todoCards", todoCards);
    model.addAttribute("doingCards", doingCards);
    model.addAttribute("doneCards", doneCards);

    return "cards";
  }
  
  @PostMapping
  public String create(Card card) {
    cardService.create(card);
    return "redirect:/cards";
  }
  
  @GetMapping("{id}")
  public String card(Model model, @PathVariable Long id) {
    model.addAttribute("card", cardService.find(id));
    return "card-details";
  }
  
  @PostMapping("update")
  public String update(Card card) {
    cardService.update(card);
    return "redirect:/cards";
  }
}
