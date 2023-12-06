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
            System.out.println("6. Inverse matrix");
            System.out.println("0. Exit");
            System.out.print("Your choice: > ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add code for adding matrices
                    break;
                case 2:
                    // Add code for multiplying matrix by a constant
                    break;
                case 3:
                    // Add code for multiplying matrices
                    break;
                case 4:
                    // Add code for transposing a matrix
                    break;
                case 5:
                    // Add code for calculating determinant
                    break;
                case 6:
                    calculateInverse(scanner);
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

    // Skip previous methods printMatrix, readMatrix, calculateDeterminant, getSubMatrix here

    private static void calculateInverse(Scanner scanner) {
        System.out.print("Enter matrix size: > ");
        int size = scanner.nextInt();
        int[][] matrix = readMatrix(scanner, size, size);

        double determinant = calculateDeterminant(matrix);

        if (determinant == 0) {
            System.out.println("This matrix doesn't have an inverse.");
            return;
        }

        double[][] inverseMatrix = calculateInverseMatrix(matrix, determinant);

        System.out.println("The result is:");
        printMatrix(inverseMatrix);
    }

    private static double[][] calculateInverseMatrix(int[][] matrix, double determinant) {
        int n = matrix.length;
        double[][] cofactorMatrix = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int[][] subMatrix = getSubMatrix(matrix, i, j);
                double subDeterminant = calculateDeterminant(subMatrix);
                double cofactor = Math.pow(-1, i + j) * subDeterminant;
                cofactorMatrix[i][j] = cofactor / determinant;
            }
        }

        return transposeMatrix(cofactorMatrix);
    }

    private static double[][] transposeMatrix(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] transposed = new double[cols][rows];

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                transposed[i][j] = matrix[j][i];
            }
        }

        return transposed;
    }
}