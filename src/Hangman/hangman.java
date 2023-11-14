package Hangman;

import java.util.Scanner;
import java.util.Random;

public class hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] wordList = {"python", "java", "javascript", "kotlin"};
        Random random = new Random();

        System.out.println("HANGMAN");
        String userInput;
        do {
            System.out.println("Type \"play\" to play the game, \"exit\" to quit: > ");
            userInput = scanner.nextLine().toLowerCase();

            if (userInput.equals("play")) {
                playGame(wordList, random);
            } else if (!userInput.equals("exit")) {
                System.out.println("Invalid input. Please try again.");
            }
        } while (!userInput.equals("exit"));

        scanner.close();
    }

    private static void playGame(String[] wordList, Random random) {
        String secretWord = wordList[random.nextInt(wordList.length)];
        int attemptsLeft = 8;
        boolean[] guessedLetters = new boolean[secretWord.length()];
        boolean wordGuessed = false;
        boolean[] alreadyGuessed = new boolean[26];

        while (attemptsLeft > 0 && !wordGuessed) {
            boolean letterGuessed = false;
            System.out.print(displayWord(secretWord, guessedLetters) + "\nInput a letter: > ");
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine().toLowerCase();

            if (userInput.length() != 1) {
                System.out.println("You should input a single letter");
                continue;
            }

            char userChar = userInput.charAt(0);
            if (!Character.isLetter(userChar) || userChar < 'a' || userChar > 'z') {
                System.out.println("Please enter a lowercase English letter");
                continue;
            }

            if (alreadyGuessed[userChar - 'a']) {
                System.out.println("You've already guessed this letter");
                continue;
            }

            boolean improvement = false;
            alreadyGuessed[userChar - 'a'] = true;

            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == userChar && !guessedLetters[i]) {
                    guessedLetters[i] = true;
                    letterGuessed = true;
                    improvement = true;
                }
            }

            if (!letterGuessed) {
                if (!improvement) {
                    attemptsLeft--;
                    System.out.println("That letter doesn't appear in the word");
                } else {
                    System.out.println("No improvements");
                }
            }

            if (displayWord(secretWord, guessedLetters).equals(secretWord)) {
                wordGuessed = true;
            }
        }

        if (wordGuessed) {
            System.out.println("You guessed the word " + secretWord + "!");
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }

    private static String displayWord(String secretWord, boolean[] guessedLetters) {
        StringBuilder display = new StringBuilder();
        for (int i = 0; i < secretWord.length(); i++) {
            if (guessedLetters[i]) {
                display.append(secretWord.charAt(i));
            } else {
                display.append("-");
            }
        }
        return display.toString();
    }
}