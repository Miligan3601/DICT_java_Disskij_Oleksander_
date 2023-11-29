package TicTacToe;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] gameBoard = createEmptyBoard();
        boolean gameFinished = false;
        char currentPlayer = 'X';

        displayGameBoard(gameBoard);

        while (!gameFinished) {
            int row, col;
            boolean validInput = false;

            while (!validInput) {
                System.out.print("Enter the coordinates: ");
                if (scanner.hasNextInt()) {
                    row = scanner.nextInt();
                    col = scanner.nextInt();

                    if (row >= 1 && row <= 3 && col >= 1 && col <= 3) {
                        if (gameBoard[3 - col][row - 1] == '_') {
                            gameBoard[3 - col][row - 1] = currentPlayer;
                            validInput = true;
                        } else {
                            System.out.println("This cell is occupied! Choose another one!");
                        }
                    } else {
                        System.out.println("Coordinates should be from 1 to 3!");
                    }
                } else {
                    System.out.println("You should enter numbers!");
                    scanner.next(); // Clear the input buffer
                }
            }

            displayGameBoard(gameBoard);
            gameFinished = isGameFinished(gameBoard, currentPlayer);

            if (!gameFinished) {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        char winner = (currentPlayer == 'X') ? 'O' : 'X';
        char oppositeSymbol = (winner == 'X') ? 'O' : 'X';
        System.out.println(oppositeSymbol + " wins");
        scanner.close();
    }

    public static char[][] createEmptyBoard() {
        return new char[][]{{'_', '_', '_'}, {'_', '_', '_'}, {'_', '_', '_'}};
    }

    public static void displayGameBoard(char[][] gameBoard) {
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

    public static boolean isGameFinished(char[][] gameBoard, char currentPlayer) {
        if (checkWin(gameBoard, currentPlayer)) {
            return true;
        }
        return checkDraw(gameBoard);
    }

    public static boolean checkWin(char[][] gameBoard, char symbol) {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if ((gameBoard[i][0] == symbol && gameBoard[i][1] == symbol && gameBoard[i][2] == symbol) ||
                    (gameBoard[0][i] == symbol && gameBoard[1][i] == symbol && gameBoard[2][i] == symbol)) {
                return true;
            }
        }
        return (gameBoard[0][0] == symbol && gameBoard[1][1] == symbol && gameBoard[2][2] == symbol) ||
                (gameBoard[0][2] == symbol && gameBoard[1][1] == symbol && gameBoard[2][0] == symbol);
    }

    public static boolean checkDraw(char[][] gameBoard) {
        // Check for a draw
        for (char[] row : gameBoard) {
            for (char cell : row) {
                if (cell == '_') {
                    return false;
                }
            }
        }
        return true;
    }
    
}
