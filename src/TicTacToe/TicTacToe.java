package TicTacToe;

public class TicTacToe {
    public static void main(String[] args) {
        // Оголошення двовимірного масиву для представлення поля гри
        char[][] gameBoard = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'X', 'O'}
        };

        // Виведення гри на екран
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println(); // Перехід на новий рядок після кожного рядка матриці
        }
    }
    
}
