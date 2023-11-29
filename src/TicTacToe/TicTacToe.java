package TicTacToe;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cells: ");
        String input = scanner.nextLine();

        displayGameBoard(input);
        playGame(input, scanner);
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

    public static void playGame(String input, Scanner scanner) {
        char[][] gameBoard = new char[3][3];
        int counter = 0;

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = input.charAt(counter++);
            }
        }

        int row, col;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Enter the coordinates: ");
            if (scanner.hasNextInt()) {
                row = scanner.nextInt();
                col = scanner.nextInt();

                if (row >= 1 && row <= 3 && col >= 1 && col <= 3) {
                    if (gameBoard[3 - col][row - 1] == '_') {
                        gameBoard[3 - col][row - 1] = 'X';
                        validInput = true;
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                }
            } else {
                System.out.println("You should enter numbers!");
                scanner.next(); 
            }
        }

        displayUpdatedGameBoard(gameBoard);
    }

    public static void displayUpdatedGameBoard(char[][] gameBoard) {
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
