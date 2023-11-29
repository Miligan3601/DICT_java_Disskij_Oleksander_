package TicTacToe;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cells: ");
        String input = scanner.nextLine();

        displayGameBoard(input);
    }

    public static void displayGameBoard(String input) {
        char[][] gameBoard = new char[3][3];
        int counter = 0;

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = input.charAt(counter++);
            }
        }

        System.out.println("---------");
        for (char[] row : gameBoard) {
            System.out.print("| ");
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
    
}
