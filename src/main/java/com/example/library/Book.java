package src.main.java.com.example.library;

public class Book {
    private int id;
    private String name;
    private String author;
    private boolean isAvailable;
    private int userId;

    public Book() {
        id = 0;
        name = "Default";
        author = "None";
        isAvailable = true;
        userId = -1;
    }

    public Book(int id, String name, String author, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.isAvailable = isAvailable;
        userId = -1;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public boolean getAvailablity() {
        return isAvailable;
    }

    public int getUserID() {
        return this.userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAvailablity(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void setUserID(int userId) {
        this.userId = userId;
    }
}
