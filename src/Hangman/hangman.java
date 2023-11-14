package Hangman;

import java.util.Scanner;
import java.util.Random;

public class hangman {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String[] wordList = {"python", "java", "javascript", "kotlin"};
            Random random = new Random();
            String secretWord = wordList[random.nextInt(wordList.length)];

            StringBuilder displayWord = new StringBuilder();
            displayWord.append(secretWord.charAt(0)).append(secretWord.charAt(1));
            for (int i = 2; i < secretWord.length(); i++) {
                displayWord.append("-");
            }

            System.out.println("HANGMAN");
            System.out.print("Guess the word " + displayWord + ": > ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase(secretWord)) {
                System.out.println("You survived!");
            } else {
                System.out.println("You lost!");
            }

            scanner.close();
        }
    }