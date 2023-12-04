import java.util.Scanner;

public class MatrixProcessing {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter matrix A:");
        int[][] matrixA = readMatrix(scanner);
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;

        System.out.println("Enter matrix B:");
        int[][] matrixB = readMatrix(scanner);
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;

        if (rowsA == rowsB && colsA == colsB) {
            int[][] resultMatrix = addMatrices(matrixA, matrixB);
            System.out.println("Output:");
            printMatrix(resultMatrix);
        } else {
            System.out.println("ERROR");
        }
    }

    public static int[][] readMatrix(Scanner scanner) {
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public static int[][] addMatrices(int[][] matrixA, int[][] matrixB) {
        int rows = matrixA.length;
        int cols = matrixA[0].length;
        int[][] resultMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return resultMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}