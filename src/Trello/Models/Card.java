package Trello.Models;

import Trello.Enums.CardStatus;

import java.time.LocalDateTime;

public class Card {
    private String id;
    private String listId;
    private CardStatus status;
    private String description;
    private User user;

    private LocalDateTime createdAt;
    private String boardId;

    private LocalDateTime finishedTime;

    private int eta; // in days

    private int priority;

    public Card(String id, String boardId, String listId, String des, int eta, int priority) {
        this.id = id;
        this.listId = listId;
        this.boardId = boardId;
        this.status = CardStatus.UNASSIGNED;
        this.user = null;
        this.createdAt = LocalDateTime.now();
        this.finishedTime = null;
        this.eta = eta;
        this.priority = priority;
        this.description = des;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public CardStatus getStatus() {
        return status;
    }

    public void setStatus(CardStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(LocalDateTime finishedTime) {
        this.finishedTime = finishedTime;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", listId='" + listId + '\'' +
                ", status=" + status +
                ", user=" + user +
                ", createdAt=" + createdAt +
                ", finishedTime=" + finishedTime +
                ", eta=" + eta +
                ", priority=" + priority +
                '}';
    }
}
