package LibrarySystem.Service;

import LibrarySystem.Models.Book;
import LibrarySystem.Models.IssueHistory;
import LibrarySystem.Models.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Calendar;

import static LibrarySystem.Constants.BORROW_LIMIT;
import static LibrarySystem.Constants.FINE_PER_DAY;
public class LibraryService {
    List<Book> books;
    List<User> users;

    public LibraryService() {
        books = new ArrayList<>();
        users = new ArrayList<>();
        this.addBooks();
    }

    public void addBooks() {
        books.add(new Book("1", "Fading Shadows", "Emily Smith", 15));
        books.add(new Book("2", "Whispers in the Wind", "Michael Johnson", 8));
        books.add(new Book("3", "Echoes of Eternity", "Sophia Carter", 20));
        books.add(new Book("4", "The Silent Melody", "David Williams", 12));
        books.add(new Book("5", "A World Apart", "Olivia Adams", 25));
    }

    public void addUser(String userId, String username, String startDate, String endDate) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date start = df.parse(startDate);
            Date end = df.parse(endDate);
            this.users.add(new User(userId, username, start, end));
            System.out.println("User with id " + userId + " registered successfully");
        }
        catch (ParseException e) {
            System.out.println("Failed to parse date");
        }

    }

    private Date min(Date date1, Date date2) {
        if (date1.before(date2)) {
            return date1;
        } else {
            return date2;
        }
    }

    public void borrowBook(String userId, String bookId, String issueDate) {
        try {
            User user = this.users.stream().filter(u -> u.getId().equals(userId)).findFirst().get();
            Map<String, Date> borrowedBooks = user.getBorrowedBooks();
            Book book = this.books.stream().filter(b -> b.getId().equals(bookId)).findFirst().get();

            if (borrowedBooks.size() < 2 && !borrowedBooks.containsKey(book.getId())) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date issuedDate = df.parse(issueDate);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(issuedDate);
                calendar.add(Calendar.DAY_OF_MONTH, BORROW_LIMIT);
                Date dueDate = min(calendar.getTime(), user.getEndDate());
                borrowedBooks.put(book.getId(), dueDate);

                //add issue history
                user.addIssueHistory(new IssueHistory(book, issuedDate, null, dueDate, 0));
                System.out.println("Book borrowed: " + book.getName() + " issueDate: " + df.format(issuedDate) +
                        " dueDate: " + df.format(dueDate));

                //update inventory
                book.decrementCount(1);

            } else {
                System.out.println("Cannot borrow the book.");
            }
        } catch (ParseException e) {
            System.out.println("Failed to parse date");
        }

    }

    public void returnBook(String userId, String bookId, String returnDate) {
        try {
            User user = this.users.stream().filter(u -> u.getId().equals(userId)).findFirst().get();
            Map<String, Date> borrowedBooks = user.getBorrowedBooks();
            Book book = this.books.stream().filter(b -> b.getId().equals(bookId)).findFirst().get();

            if (borrowedBooks.containsKey(book)) {
                Date dueDate = borrowedBooks.get(book);
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date formattedReturnedDate = df.parse(returnDate);
                int fine = 0;
                if (formattedReturnedDate.after(dueDate)) {
                    fine = (int) ((formattedReturnedDate.getTime() - dueDate.getTime()) / (1000 * 60 * 60 * 24)) * FINE_PER_DAY;
                }

                // Update the issue history for the returned book
                for (IssueHistory history : user.getIssueHistory()) {
                    if (history.getBook().getId().equals(book.getId()) && history.getReturnDate() == null) {
                        history.setReturnDate(formattedReturnedDate);
                        history.setFineAmount(fine);
                        break;
                    }
                }
                borrowedBooks.remove(book);

                //update the inventory
                book.incrementCount(1);
                System.out.println("Book returned. Fine amount: " + fine);
            } else {
                System.out.println("Book not borrowed by user.");
            }

        } catch(ParseException e) {
            System.out.println("Failed to parse date");
        }
    }

    public void showInventory() {
        for (Book b: this.books) {
            System.out.println(b);
        }
    }

    public void view(String userId) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        User user = this.users.stream().filter(u -> u.getId().equals(userId)).findFirst().get();
        System.out.println("Name: " + user.getName() + " Id: " + user.getId());
        System.out.println("Issue History -");
        for(IssueHistory h: user.getIssueHistory()) {
            System.out.println(h);
        }
        System.out.println("Membership Details- " + "StartDate: " + df.format(user.getStartDate()) +
                " EndDate: " + df.format(user.getEndDate()));
    }
}
