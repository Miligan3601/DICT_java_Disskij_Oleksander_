package Hangman;

import java.util.Scanner;
public class hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String secretWord = "java";

        System.out.println("HANGMAN");
        System.out.print("Guess the word: > ");
        String userInput = scanner.nextLine();

        if (userInput.equalsIgnoreCase(secretWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }

        scanner.close();
    }
}