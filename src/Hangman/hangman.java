package Hangman;

import java.util.Scanner;
import java.util.Random;

public class hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] wordList = {"python", "java", "javascript", "kotlin"};
        Random random = new Random();
        String secretWord = wordList[random.nextInt(wordList.length)];

        int attemptsLeft = 8;
        boolean[] guessedLetters = new boolean[secretWord.length()];
        boolean wordGuessed = false;

        System.out.println("HANGMAN");
        while (attemptsLeft > 0 && !wordGuessed) {
            boolean letterGuessed = false;
            System.out.print(displayWord(secretWord, guessedLetters) + "\nInput a letter: > ");
            String userInput = scanner.nextLine().toLowerCase();

            char userChar = userInput.charAt(0);
            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == userChar && !guessedLetters[i]) {
                    guessedLetters[i] = true;
                    letterGuessed = true;
                }
            }

            if (!letterGuessed) {
                attemptsLeft--;
                System.out.println("That letter doesn't appear in the word");
            }

            if (displayWord(secretWord, guessedLetters).equals(secretWord)) {
                wordGuessed = true;
            }
        }
        if (wordGuessed) {
            System.out.println("Thanks for playing!");
            System.out.println("We'll see how well you did in the next stage");
        } else {
            System.out.println("You ran out of attempts!");
            System.out.println("The word was: " + secretWord);
        }

        scanner.close();
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