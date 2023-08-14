package LibrarySystem.Models;

public class Book {
    private String id;
    private String name;
    private String Author;
    private int count;

    public Book(String id, String name, String author, int count) {
        this.id = id;
        this.name = name;
        Author = author;
        this.count = count;
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

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public void incrementCount(int val) {
        this.count = this.count +  val;
    }

    public void decrementCount(int val) {
        this.count = this.count -  val;
    }

    @Override
    public String toString() {
        return "Id: " + this.getId() + " Name: " + this.getName() + " Author: " + this.getAuthor() +
                " Count: " + this.getCount();
    }
}
