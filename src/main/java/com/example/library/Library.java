package src.main.java.com.example.library;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> collection;
    private ArrayList<User> members;

    public Library() {
        collection = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void registerMembers(User user) {
        members.add(user);
        System.out.println(
                "SUCCESS: User '" + user.getName() + "' registered with ID: " + user.getID());
    }

    public void viewMembers() {
        if (members.isEmpty()) {
            System.out.println("No members registered yet.");
        } else {
            for (User member : members) {
                System.out.println("Member ID: " + member.getID() + " | Name: " + member.getName());
            }
        }
    }

    public void viewBooks() {
        if (collection.isEmpty()) {
            System.out.println("No books in collection yet.");
        } else {
            for (Book book : collection) {
                String status = book.getAvailablity() ? "Available" : "Borrowed";
                System.out.println("ID: " + book.getID() + " | Title: " + book.getName()
                        + " | Author: " + book.getAuthor() + " | Status: " + status);
            }
        }
    }

    public void addBook(Book book) {
        this.collection.add(book);
        System.out.println("SUCCESS: Book '" + book.getName() + "' added to collection with ID: "
                + book.getID());
    }

    public void updateBook(int id, String name, String author) {
        for (Book book : collection) {
            if (book.getID() == id) {
                book.setName(name);
                book.setAuthor(author);
                System.out.println("Book is updated: " + book.getName());
                return;
            }
        }
        System.out.println("Book is not found");
    }

    public void removeBook(int id) {
        for (Book book : collection) {
            if (book.getID() == id) {
                collection.remove(book);
                System.out.println("Book is removed: " + book.getName());
                return;
            }
        }
        System.out.println("Book is not found");
    }

    public void borrowBook(int bookId, int userId) {
        for (Book book : collection) {
            if (book.getID() == bookId) {
                if (book.getAvailablity()) {
                    book.setAvailablity(false);
                    book.setUserID(userId);
                    System.out.println("SUCCESS: Book '" + book.getName()
                            + "' borrowed by User ID: " + userId);
                    return;
                }
                System.out
                        .println("ERROR: Book '" + book.getName() + "' is currently unavailable.");
                return;
            }
        }
        System.out.println("ERROR: Book with ID " + bookId + " not found.");
    }

    public void returnBook(int bookId, int userId) {
        for (Book book : collection) {
            if (book.getID() == bookId) {
                if (book.getUserID() == userId) {
                    book.setAvailablity(true);
                    book.setUserID(-1);
                    System.out.println("SUCCESS: Book '" + book.getName()
                            + "' returned by User ID: " + userId);
                    return;
                }
                System.out.println("ERROR: Book '" + book.getName()
                        + "' was not borrowed by User ID: " + userId);
                return;
            }
        }
        System.out.println("ERROR: Book with ID " + bookId + " not found.");
    }
}
