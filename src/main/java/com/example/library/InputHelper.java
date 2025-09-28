package src.main.java.com.example.library;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {
    public static int readInt(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Enter a number: ");
                scanner.nextLine(); // clear invalid input
            }
        }
    }
}
