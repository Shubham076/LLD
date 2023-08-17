package Trello.Exceptions;

public class BoardNotFoundException extends Exception{
    public BoardNotFoundException(String msg) {
        super(msg);
    }
}
