import java.util.Scanner;

public class MatrixProcessing {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Add matrices");
            System.out.println("2. Multiply matrix by a constant");
            System.out.println("3. Multiply matrices");
            System.out.println("4. Transpose matrix");
            System.out.println("5. Calculate a determinant");
            System.out.println("0. Exit");
            System.out.print("Your choice: > ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Додайте код для додавання матриць
                    break;
                case 2:
                    // Додайте код для множення матриці на константу
                    break;
                case 3:
                    // Додайте код для множення матриць
                    break;
                case 4:
                    // Додайте код для транспонування матриці
                    break;
                case 5:
                    calculateDeterminant(scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    private static void calculateDeterminant(Scanner scanner) {
        System.out.print("Enter matrix size: > ");
        int size = scanner.nextInt();
        int[][] matrix = readMatrix(scanner, size, size);

        int determinant = calculateDeterminant(matrix);
        System.out.println("The result is: " + determinant);
    }

    private static int[][] readMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        System.out.println("Enter matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    private static int calculateDeterminant(int[][] matrix) {
        int n = matrix.length;
        if (n != matrix[0].length) {
            throw new IllegalArgumentException("The matrix is not square.");
        }

        int determinant = 0;

        if (n == 1) {
            determinant = matrix[0][0];
        } else if (n == 2) {
            determinant = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else {
            for (int i = 0; i < n; i++) {
                determinant += Math.pow(-1, i) * matrix[0][i] * calculateDeterminant(getSubMatrix(matrix, 0, i));
            }
        }

        return determinant;
    }

    private static int[][] getSubMatrix(int[][] matrix, int excludingRow, int excludingCol) {
        int n = matrix.length;
        int[][] subMatrix = new int[n - 1][n - 1];
        int r = -1;

        for (int i = 0; i < n; i++) {
            if (i == excludingRow) {
                continue;
            }
            r++;
            int c = -1;
            for (int j = 0; j < n; j++) {
                if (j == excludingCol) {
                    continue;
                }
                subMatrix[r][++c] = matrix[i][j];
            }
        }
        return subMatrix;
    }
}