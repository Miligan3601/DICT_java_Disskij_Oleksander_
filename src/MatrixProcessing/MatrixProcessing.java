import java.util.Scanner;

public class MatrixProcessing {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Зчитуємо розміри матриці
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        // Зчитуємо матрицю
        int[][] matrix = readMatrix(scanner, rows, cols);

        // Зчитуємо константу
        int constant = scanner.nextInt();

        // Множимо матрицю на константу
        int[][] resultMatrix = multiplyByConstant(matrix, constant);

        // Виводимо результат множення
        printMatrix(resultMatrix);
    }

    // Метод для зчитування матриці з введення
    private static int[][] readMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    // Метод для множення матриці на константу
    private static int[][] multiplyByConstant(int[][] matrix, int constant) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] resultMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[i][j] = matrix[i][j] * constant;
            }
        }
        return resultMatrix;
    }

    // Метод для виведення матриці
    private static void printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}