package LibrarySystem.Models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IssueHistory {
    private Book book;
    private Date issueDate;
    private Date returnDate;

    private Date dueDate;
    private int fineAmount;

    public IssueHistory(Book book, Date issueDate, Date returnDate, Date dueDate, int fineAmount) {
        this.book = book;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.fineAmount = fineAmount;
        this.dueDate = dueDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(int fineAmount) {
        this.fineAmount = fineAmount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return "  - " + book.toString() + " IssueDate: " + df.format(this.issueDate) + " DueDate: " + df.format(this.dueDate) +
                " returnDate: " + (this.returnDate == null ? "null" : df.format(this.returnDate)) + " Fine: " + this.fineAmount;
    }
}