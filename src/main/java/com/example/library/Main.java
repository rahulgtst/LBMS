package src.main.java.com.example.library;

import java.util.Scanner;

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
