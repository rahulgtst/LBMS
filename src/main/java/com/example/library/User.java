package src.main.java.com.example.library;

import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private ArrayList<Book> books;

    public User() {
        id = 0;
        name = "Default";
        books = new ArrayList<>();
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        books = new ArrayList<>();
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void borrowBook(Book book) {
        this.books.add(book);
        System.out.println("Book is added into collection: " + book.getName());
    }

    public void showBooks() {
        for (Book book : books) {
            System.out.println("Book ID: " + book.getID() + " Book Name: " + book.getName()
                    + " Book Author: " + book.getAuthor());
        }
    }
}
