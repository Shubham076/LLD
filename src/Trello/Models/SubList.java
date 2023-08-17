package Trello.Models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SubList {
    private String id;
    private String name;
    private List<Card> cards;

    private LocalDateTime createdAt;

    public SubList(String id, String name) {
        this.id = id;
        this.name = name;
        this.cards = new ArrayList<>();
        this.createdAt = LocalDateTime.now();
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

    public List<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void show() {
        if (cards.size() == 0) {
            System.out.println("No cards found");
        }
        for (Card c: cards) {
            System.out.println(c.toString());
        }
    }

    public void show(String cardId) {

    }
}
