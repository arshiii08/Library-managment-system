package library_management_system;

import java.util.ArrayList;
import java.util.List;

class Book {
    private int id;
    private String title;
    private String author;
    private boolean available;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrow() {
        if (available) {
            available = false;
        } else {
            System.out.println("This book is not available for borrowing.");
        }
    }

    public void returnBook() {
        available = true;
    }

    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", available=" + available + "]";
    }
}

class User {
    private int id;
    private String name;
    private List<Book> borrowedBooks;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.borrow();
            System.out.println(name + " borrowed " + book.getTitle());
        } else {
            System.out.println(book.getTitle() + " is not available for borrowing.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.returnBook();
            System.out.println(name + " returned " + book.getTitle());
        } else {
            System.out.println("You did not borrow " + book.getTitle());
        }
    }
}

public class LibraryManagementSystem{
    public static void main(String[] args) {
        Book book1 = new Book(1, "Java Programming", "John Doe");
        Book book2 = new Book(2, "Introduction to Algorithms", "Alice Smith");
        Book book3 = new Book(3, "Data Structures and Algorithms", "Bob Johnson");

        User user1 = new User(101, "Alice");
        User user2 = new User(102, "Bob");

        user1.borrowBook(book1);
        user1.borrowBook(book2);
        user2.borrowBook(book2);

        System.out.println("Books borrowed by Alice: " + user1.getBorrowedBooks());
        System.out.println("Books borrowed by Bob: " + user2.getBorrowedBooks());

        user1.returnBook(book1);
        user2.returnBook(book2);

        System.out.println("Books borrowed by Alice after returning: " + user1.getBorrowedBooks());
        System.out.println("Books borrowed by Bob after returning: " + user2.getBorrowedBooks());
    }
}
