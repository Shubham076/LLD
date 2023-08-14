package LibrarySystem.Models;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class User {
    private String id;
    private String name;

    private Date startDate;
    private Date endDate;

    private List<IssueHistory> issueHistory;

    private Map<String, Date> borrowedBooks;

    public User(String id, String name, Date startDate, Date endDate) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        borrowedBooks = new HashMap<>();
        issueHistory = new ArrayList<>();
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Map<String, Date> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(Map<String, Date> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public void addIssueHistory(IssueHistory history) {
        this.issueHistory.add(history);
    }

    public List<IssueHistory> getIssueHistory() {
        return this.issueHistory;
    }
}
