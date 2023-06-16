package Project_Management;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class List {
  private String id;
  private String name;
  private Map<String, Card> cards;

  public List(String name) {
    this.id = UUID.randomUUID().toString();
    this.name = name;
    this.cards = new HashMap<>();
    System.out.println("Created List with id: " + this.id);
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Map<String, Card> getCards() {
    return cards;
  }
  public void setCards(Map<String, Card> cards) {
    this.cards = cards;
  }
  public void addCard(Card card) {
    this.cards.put(card.getId(), card);
  }
}
