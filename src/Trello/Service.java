package Trello;

import Trello.Enums.BoardAccess;
import Trello.Enums.CardStatus;
import Trello.Exceptions.BoardNotFoundException;
import Trello.Exceptions.CardNotFoundException;
import Trello.Exceptions.ListNotFoundException;
import Trello.Exceptions.UserNotFoundException;
import Trello.Models.Board;
import Trello.Models.Card;
import Trello.Models.SubList;
import Trello.Models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public class Service {

    private List<Board> boards;

    public Service() {
        this.boards = new ArrayList<>();
    }

    public void overview() {
        if (boards.size() == 0) {
            System.out.println("Not boards found");
        }
        for (Board b: boards) {
            b.show();
        }
    }

    public void addBoard(String name, String url, String accessType) {
        try {
            Board b = new Board(name, url, BoardAccess.valueOf(accessType));
            this.boards.add(b);
            System.out.println("Board: " + b.getId() + " created successfully");
        } catch (Exception e) {
            if (e.getMessage().contains("No enum constant")) {
                System.out.println("AccessType of board shoulg be: " + BoardAccess.PRIVATE + "," + BoardAccess.PUBLIC);
            } else {
                System.out.println(e.getMessage());
            }
        }
    }

    public void deleteBoard(String id) {
        try {
            Board board = this.boards.stream().filter(b -> b.getId().equals(id)).findFirst().get();
            this.boards.remove(board);
        } catch (NoSuchElementException e) {
            System.out.println("Board: " + id + " not found");
        }
    }

    public void viewBoard(String boardID){
        try {
            Board board = this.boards.stream().filter(b -> b.getId().equals(boardID)).findFirst().get();
            System.out.println("Board: " + boardID);
            board.show();
        } catch (NoSuchElementException e) {
            System.out.println("Board: " + boardID + " not found");
        }
    }

    public void addUser(String boardId, String name, String email) {
        try {
            Board board = this.boards.stream().filter(b -> b.getId().equals(boardId)).findFirst().get();
            int id = board.getMembers().size() + 1;
            board.addMember(new User(id, name, email));
            System.out.println("User: " + name + " id: " + id + " added to board: " + boardId);
        } catch (NoSuchElementException e) {
            System.out.println("Board: " + boardId + " not found");
        }
    }

    public void deleteUser(String boardId, int userId) {
        try {
            Board board = this.boards.stream().filter(b -> b.getId().equals(boardId)).findFirst().orElse(null);
            if (board == null) {
                throw new BoardNotFoundException("Board: " + boardId + "not found");
            }
            User user = board.getMembers().stream().filter(u -> u.getId() == userId).findFirst().orElse(null);
            if (user == null) {
               throw new UserNotFoundException("User: " + userId + " not found");
            }
            System.out.println("User:"  + userId + " deleted successfully");
        } catch (BoardNotFoundException | UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addList(String boardId, String name) {
        try {
            Board board = this.boards.stream().filter(b -> b.getId().equals(boardId)).findFirst().get();
            String listId = UUID.randomUUID().toString();
            board.addList(new SubList(listId, name));
            System.out.println("List: " + name + " id: " + listId + " added to board: " + boardId);
        } catch (NoSuchElementException e) {
            System.out.println("Board: " + boardId + " not found");
        }
    }

    public void deleteList(String boardId, String listId) {
        try {
            Board board = this.boards.stream().filter(b -> b.getId().equals(boardId)).findFirst().orElse(null);
            if (board == null) {
                throw new BoardNotFoundException("Board: " + boardId + "not found");
            }
            SubList list = board.getLists().stream().filter(l -> l.getId().equals(listId)).findFirst().orElse(null);
            if (list == null) {
                throw new ListNotFoundException("List: "+ listId + " not found");
            }
            board.getLists().remove(list);
            System.out.println("List:"  + listId + " deleted successfully");
        } catch (BoardNotFoundException | ListNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showList(String boardId, String listId) {
        try {
            Board board = this.boards.stream().filter(b -> b.getId().equals(boardId)).findFirst().orElse(null);
            if (board == null) {
                throw new BoardNotFoundException("Board: " + boardId + "not found");
            }
            SubList list = board.getLists().stream().filter(l -> l.getId().equals(listId)).findFirst().orElse(null);
            if (list == null) {
                throw new ListNotFoundException("List: "+ listId + " not found");
            }
            list.show();
        } catch (BoardNotFoundException | ListNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addCard(String boardId, String listId, String des, int eta, int priority) {
        try {
            Board board = this.boards.stream().filter(b -> b.getId().equals(boardId)).findFirst().orElse(null);
            if (board == null) {
                throw new BoardNotFoundException("Board: " + boardId + "not found");
            }
            SubList list = board.getLists().stream().filter(l -> l.getId().equals(listId)).findFirst().orElse(null);
            if (list == null) {
                throw new ListNotFoundException("List: "+ listId + " not found");
            }

            String cardID = UUID.randomUUID().toString();
            Card c = new Card(cardID, boardId, listId, des, eta, priority);
            list.addCard(c);
            System.out.println("Card: " + cardID + " added to list: " + listId + " ,board: " + boardId);
        } catch (BoardNotFoundException | ListNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


    public void deleteCard(String boardId, String listId, String cardId) {
        try {
            Board board = this.boards.stream().filter(b -> b.getId().equals(boardId)).findFirst().orElse(null);
            if (board == null) {
                throw new BoardNotFoundException("Board: " + boardId + "not found");
            }
            SubList list = board.getLists().stream().filter(l -> l.getId().equals(listId)).findFirst().orElse(null);
            if (list == null) {
                throw new ListNotFoundException("List: "+ listId + " not found");
            }

            Card card  = list.getCards().stream().filter(c -> c.getId().equals(cardId)).findFirst().orElse(null);
            if (card == null) {
                throw new CardNotFoundException("Card: " + cardId + " not found");
            }

            System.out.println("Card:"  + cardId + " deleted successfully");
        } catch (BoardNotFoundException | ListNotFoundException | CardNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void moveCard(String boardId, String srclistId, String destListId, String cardId) {
        try {
            Board board = this.boards.stream().filter(b -> b.getId().equals(boardId)).findFirst().orElse(null);
            if (board == null) {
                throw new BoardNotFoundException("Board: " + boardId + "not found");
            }
            SubList srclist = board.getLists().stream().filter(l -> l.getId().equals(srclistId)).findFirst().orElse(null);
            if (srclist == null) {
                throw new ListNotFoundException("SrcList: "+ srclistId + " not found");
            }

            SubList destlist = board.getLists().stream().filter(l -> l.getId().equals(destListId)).findFirst().orElse(null);
            if (destlist == null) {
                throw new ListNotFoundException("DestList: "+ destListId + " not found");
            }

            Card card  = srclist.getCards().stream().filter(c -> c.getId().equals(cardId)).findFirst().orElse(null);
            if (card == null) {
                throw new CardNotFoundException("Card: " + cardId + " not found");
            }

            srclist.getCards().remove(card);
            card.setListId(destlist.getId());
            destlist.addCard(card);

            System.out.println("Card:"  + cardId + "moved from srcList: " + srclistId + " to destList: " + destListId);
        } catch (BoardNotFoundException | ListNotFoundException | CardNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


    public void assignCard(String boardId, String srclistId, String cardId, int userId) {
        try {
            Board board = this.boards.stream().filter(b -> b.getId().equals(boardId)).findFirst().orElse(null);
            if (board == null) {
                throw new BoardNotFoundException("Board: " + boardId + "not found");
            }
            SubList srclist = board.getLists().stream().filter(l -> l.getId().equals(srclistId)).findFirst().orElse(null);
            if (srclist == null) {
                throw new ListNotFoundException("SrcList: "+ srclistId + " not found");
            }

            User user = board.getMembers().stream().filter(u -> u.getId() == userId).findFirst().orElse(null);
            if (user == null) {
                throw new UserNotFoundException("User: "+ userId + " not found");
            }

            Card card  = srclist.getCards().stream().filter(c -> c.getId().equals(cardId)).findFirst().orElse(null);
            if (card == null) {
                throw new CardNotFoundException("Card: " + cardId + " not found");
            }

            card.setUser(user);
            card.setStatus(CardStatus.ASSIGNED);

            System.out.println("Card:"  + cardId + "assigned to user: " + userId);
        } catch (BoardNotFoundException | ListNotFoundException | CardNotFoundException  | UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


    public void showCard(String boardId, String listId, String cardId) {
        try {
            Board board = this.boards.stream().filter(b -> b.getId().equals(boardId)).findFirst().orElse(null);
            if (board == null) {
                throw new BoardNotFoundException("Board: " + boardId + "not found");
            }
            SubList list = board.getLists().stream().filter(l -> l.getId().equals(listId)).findFirst().orElse(null);
            if (list == null) {
                throw new ListNotFoundException("List: "+ listId + " not found");
            }

            Card card  = list.getCards().stream().filter(c -> c.getId().equals(cardId)).findFirst().orElse(null);
            if (card == null) {
                throw new CardNotFoundException("Card: " + cardId + " not found");
            }

            System.out.println(card);
        } catch (BoardNotFoundException | ListNotFoundException | CardNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
