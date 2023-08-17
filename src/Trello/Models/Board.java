package Trello.Models;

import Trello.Enums.BoardAccess;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public class Board {
    private String id;
    private String name;
    private List<User> members;
    private List<SubList> lists;
    private String url;

    private LocalDateTime createdAt;

    private BoardAccess accessType;



    public Board(String name, String url, BoardAccess accessType) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.url = url;
        members = new ArrayList<>();
        lists = new ArrayList<>();
        this.accessType = accessType;
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

    public List<User> getMembers() {
        return members;
    }

    public void addMember(User member) {
        this.members.add(member);
    }

    public List<SubList> getLists() {
        return lists;
    }

    public void addList(SubList list) {
        this.lists.add(list);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void showList(int listId) {
        try {
            SubList list = this.lists.stream().filter(sl -> sl.getId().equals(listId)).findFirst().get();
            list.show();
        } catch (NoSuchElementException e) {
            System.out.println("List: " + listId + " not found");
        }
    }

    public BoardAccess getAccessType() {
        return accessType;
    }

    public void setAccessType(BoardAccess accessType) {
        this.accessType = accessType;
    }

    public void show() {
        System.out.println("Board: " + name);
        if (lists.size() == 0) {
            System.out.println("No lists found");
        }
        for (SubList list: lists) {
            System.out.println("List: " + list.getId());
            System.out.println("Cards");
            list.show();
        }

        if (members.size() == 0) {
            System.out.println("No users found");
        }
        for (User u: this.members) {
            System.out.println(u.toString());
        }
        System.out.println("--------------------");
    }
}
