package Trello.Exceptions;

public class CardNotFoundException extends Exception{
    public CardNotFoundException(String msg) {
        super(msg);
    }
}
