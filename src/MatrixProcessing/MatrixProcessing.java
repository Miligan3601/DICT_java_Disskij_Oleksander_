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
                    transposeMenu(scanner);
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

    // Метод для виведення матриці на екран
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    // Метод для транспонування матриці за головною діагоналлю
    private static void transposeMainDiagonal(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposedMatrix = new int[cols][rows];

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                transposedMatrix[i][j] = matrix[j][i];
            }
        }

        System.out.println("The result is:");
        printMatrix(transposedMatrix);
    }

    // Метод для транспонування матриці за побічною діагоналлю
    private static void transposeSideDiagonal(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposedMatrix = new int[cols][rows];

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                transposedMatrix[cols - 1 - i][rows - 1 - j] = matrix[j][i];
            }
        }

        System.out.println("The result is:");
        printMatrix(transposedMatrix);
    }

    // Метод для транспонування матриці за вертикаллю
    private static void transposeVertical(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposedMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[i][cols - 1 - j] = matrix[i][j];
            }
        }

        System.out.println("The result is:");
        printMatrix(transposedMatrix);
    }

    // Метод для транспонування матриці за горизонталлю
    private static void transposeHorizontal(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposedMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[rows - 1 - i][j] = matrix[i][j];
            }
        }

        System.out.println("The result is:");
        printMatrix(transposedMatrix);
    }

    // Метод для вибору типу транспонування
    private static void transposeMenu(Scanner scanner) {
        int choice;

        do {
            System.out.println("1. Main diagonal");
            System.out.println("2. Side diagonal");
            System.out.println("3. Vertical line");
            System.out.println("4. Horizontal line");
            System.out.print("Your choice: > ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    transposeMainDiagonal(readMatrix(scanner));
                    break;
                case 2:
                    transposeSideDiagonal(readMatrix(scanner));
                    break;
                case 3:
                    transposeVertical(readMatrix(scanner));
                    break;
                case 4:
                    transposeHorizontal(readMatrix(scanner));
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice < 1 || choice > 4);
    }

    // Метод для зчитування матриці з консолі
    private static int[][] readMatrix(Scanner scanner) {
        System.out.print("Enter matrix size: > ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];

        System.out.println("Enter matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }
}