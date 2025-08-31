import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n========================================");
        System.out.println("   Welcome to Library Management System");
        System.out.println("========================================\n");
        
        Library library = new Library();
        
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n--- MAIN MENU ---");
                System.out.println("1. Register User");
                System.out.println("2. Add Book");
                System.out.println("3. View Books");
                System.out.println("4. View Members");
                System.out.println("5. Borrow Book");
                System.out.println("6. Return Book");
                System.out.println("7. Exit");
                System.out.println("-----------------");
                System.out.print("Choose an option (1-7): ");
                
                int choice = scanner.nextInt();
                scanner.nextLine();
                
                switch (choice) {
                    case 1:
                        System.out.println("\n--- USER REGISTRATION ---");
                        System.out.print("Enter User ID: ");
                        int userId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter User Name: ");
                        String userName = scanner.nextLine();
                        library.registerMembers(new User(userId, userName));
                        break;
                        
                    case 2:
                        System.out.println("\n--- ADD NEW BOOK ---");
                        System.out.print("Enter Book ID: ");
                        int bookId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Book Name: ");
                        String bookName = scanner.nextLine();
                        System.out.print("Enter Author Name: ");
                        String authorName = scanner.nextLine();
                        library.addBook(new Book(bookId, bookName, authorName, true));
                        break;
                        
                    case 3:
                        System.out.println("\n--- BOOK COLLECTION ---");
                        library.viewBooks();
                        break;
                        
                    case 4:
                        System.out.println("\n--- REGISTERED MEMBERS ---");
                        library.viewMembers();
                        break;
                        
                    case 5:
                        System.out.println("\n--- BORROW BOOK ---");
                        System.out.print("Enter Book ID to borrow: ");
                        int borrowBookId = scanner.nextInt();
                        System.out.print("Enter Your User ID: ");
                        int borrowUserId = scanner.nextInt();
                        library.borrowBook(borrowBookId, borrowUserId);
                        break;
                        
                    case 6:
                        System.out.println("\n--- RETURN BOOK ---");
                        System.out.print("Enter Book ID to return: ");
                        int returnBookId = scanner.nextInt();
                        System.out.print("Enter Your User ID: ");
                        int returnUserId = scanner.nextInt();
                        library.returnBook(returnBookId, returnUserId);
                        break;
                        
                    case 7:
                        System.out.println("\n========================================");
                        System.out.println("  Thank you for using Library System!");
                        System.out.println("========================================");
                        return;
                        
                    default:
                        System.out.println("\nInvalid option! Please choose 1-7.");
                }
            }
        }
    }
}

class Library {
    ArrayList<Book> collection;
    ArrayList<User> members;

    Library() {
        collection = new ArrayList<Book>();
        members = new ArrayList<User>();
    }

    void registerMembers(User user) {
        members.add(user);
        System.out.println("SUCCESS: User '" + user.getName() + "' registered with ID: " + user.getID());
    }

    void viewMembers() {
        if (members.isEmpty()) {
            System.out.println("No members registered yet.");
        } else {
            for (User member: members) {
                System.out.println("Member ID: " + member.getID() + " | Name: " + member.getName());
            }
        }
    }

    void viewBooks() {
        if (collection.isEmpty()) {
            System.out.println("No books in collection yet.");
        } else {
            for (Book book: collection) {
                String status = book.getAvailablity() ? "Available" : "Borrowed";
                System.out.println("ID: " + book.getID() + " | Title: " + book.getName() + " | Author: " + book.getAuthor() + " | Status: " + status);
            }
        }
    }

    void addBook(Book book) {
        this.collection.add(book);
        System.out.println("SUCCESS: Book '" + book.getName() + "' added to collection with ID: " + book.getID());
    }

    void updateBook(int id, String name, String author) {
        for (Book book: collection) {
            if (book.getID() == id) {
                book.setName(name);
                book.setAuthor(author);
                System.out.println("Book is updated: " + book.getName());
                return;
            }
        }
        System.out.println("Book is not found");
    }

    void removeBook(int id) {
        for (Book book: collection) {
            if (book.getID() == id) {
                collection.remove(book);
                System.out.println("Book is removed: " + book.getName());
                return;
            }
        }
        System.out.println("Book is not found");
    }

    void borrowBook(int bookId, int userId) {
        for (Book book: collection) {
            if (book.getID() == bookId) {
                if (book.getAvailablity()) {
                    book.setAvailablity(false);
                    book.setUserID(userId);
                    System.out.println("SUCCESS: Book '" + book.getName() + "' borrowed by User ID: " + userId);
                    return;
                }
                System.out.println("ERROR: Book '" + book.getName() + "' is currently unavailable.");
                return;
            }
        }
        System.out.println("ERROR: Book with ID " + bookId + " not found.");
    }

    void returnBook(int bookId, int userId) {
        for (Book book: collection) {
            if (book.getID() == bookId) {
                if (book.getUserID() == userId) {
                    book.setAvailablity(true);
                    book.setUserID(-1);
                    System.out.println("SUCCESS: Book '" + book.getName() + "' returned by User ID: " + userId);
                    return;
                }
                System.out.println("ERROR: Book '" + book.getName() + "' was not borrowed by User ID: " + userId);
                return;
            }
        }
        System.out.println("ERROR: Book with ID " + bookId + " not found.");
    }
}

class User {
    private int id;
    private String name;
    ArrayList<Book> books;

    User() {
        id = 0;
        name = "Default";
        books = new ArrayList<Book>();
    }

    User(int id, String name) {
        this.id = id;
        this.name = name;
        books = new ArrayList<Book>();
    }

    int getID() {
        return id;
    }

    String getName() {
        return name;
    }

    void borrowBook(Book book) {
        this.books.add(book);
        System.out.println("Book is added into collection: " + book.getName());
    }

    void showBooks() {
        for (Book book: books) {
            System.out.println("Book ID: " + book.getID() + " Book Name: " + book.getName() + " Book Author: " + book.getAuthor());
        }
    }
}


class Book {
    private int id;
    private String name;
    private String author;
    private boolean isAvailable;
    private int userId;

    Book() {
        id = 0;
        name = "Default";
        author = "None";
        isAvailable = true;
        userId = -1;
    }

    Book(int id, String name, String author, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.isAvailable = isAvailable;
        userId = -1;
    }

    int getID() {
        return id;
    }

    String getName() {
        return name;
    }

    String getAuthor() {
        return author;
    }

    boolean getAvailablity() {
        return isAvailable;
    }

    int getUserID() {
        return this.userId;
    }

    void setName(String name) {
        this.name = name;
    }

    void setAuthor(String author) {
        this.author = author;
    }

    void setAvailablity(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    void setUserID(int userId) {
        this.userId = userId;
    }
}
