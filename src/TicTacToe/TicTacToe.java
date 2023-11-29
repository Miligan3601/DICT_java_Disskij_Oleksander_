package TicTacToe;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cells: ");
        String input = scanner.nextLine();

        displayGameBoard(input);
        analyzeGameState(input);
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

    public static void analyzeGameState(String input) {
        char[][] gameBoard = new char[3][3];
        int counter = 0;

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = input.charAt(counter++);
            }
        }

        boolean xWins = checkWin(gameBoard, 'X');
        boolean oWins = checkWin(gameBoard, 'O');
        boolean impossible = checkImpossible(gameBoard);
        boolean draw = checkDraw(gameBoard);

        if (impossible) {
            System.out.println("Impossible");
        } else if (xWins) {
            System.out.println("X wins");
        } else if (oWins) {
            System.out.println("O wins");
        } else if (draw) {
            System.out.println("Draw");
        } else {
            System.out.println("Game not finished");
        }
    }

    public static boolean checkWin(char[][] gameBoard, char symbol) {
        for (int i = 0; i < 3; i++) {
            if ((gameBoard[i][0] == symbol && gameBoard[i][1] == symbol && gameBoard[i][2] == symbol) ||
                    (gameBoard[0][i] == symbol && gameBoard[1][i] == symbol && gameBoard[2][i] == symbol)) {
                return true;
            }
        }
        return (gameBoard[0][0] == symbol && gameBoard[1][1] == symbol && gameBoard[2][2] == symbol) ||
                (gameBoard[0][2] == symbol && gameBoard[1][1] == symbol && gameBoard[2][0] == symbol);
    }

    public static boolean checkImpossible(char[][] gameBoard) {
        int countX = 0;
        int countO = 0;

        for (char[] row : gameBoard) {
            for (char cell : row) {
                if (cell == 'X') {
                    countX++;
                } else if (cell == 'O') {
                    countO++;
                }
            }
        }

        int diff = Math.abs(countX - countO);
        return diff >= 2 || (checkWin(gameBoard, 'X') && checkWin(gameBoard, 'O'));
    }

    public static boolean checkDraw(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char cell : row) {
                if (cell == '_') {
                    return false;
                }
            }
        }
        return !checkWin(gameBoard, 'X') && !checkWin(gameBoard, 'O');
    }
    
}
