import java.util.Scanner;

public class MatrixProcessing {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        while (true) {
            System.out.println("1. Add matrices");
            System.out.println("2. Multiply matrix by a constant"); 
            System.out.println("3. Multiply matrices");
            System.out.println("0. Exit");
            
            System.out.print("Your choice: ");
            int choice = scan.nextInt();
            
            if(choice == 0) {
                break;
            }
            
            switch(choice) {
                case 1:
                    addMatrices(scan);
                    break;
                case 2: 
                    multiplyMatrixConstant(scan);
                    break;
                case 3:
                    multiplyMatrices(scan);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        
        scan.close();
        
    }
    
    public static void addMatrices(Scanner scan) {
        System.out.print("Enter size of first matrix: ");
        int r1 = scan.nextInt(); 
        int c1 = scan.nextInt();
        
        System.out.print("Enter size of second matrix: ");
        int r2 = scan.nextInt();
        int c2 = scan.nextInt();
        
        if(r1 != r2 || c1 != c2) {
            System.out.println("The operation cannot be performed.");
            return;
        }
        
        int[][] matrix1 = readMatrix(scan, r1, c1); 
        int[][] matrix2 = readMatrix(scan, r2, c2);
        
        
        int[][] result = addMatrices(matrix1, matrix2);
        printMatrix(result);
    }

    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int r = matrix1.length;
        int c = matrix1[0].length;
        
        int[][] result = new int[r][c];
        
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j]; 
            }
        }        
        return result;
    }
    
    
    public static void multiplyMatrixConstant(Scanner scan) {
    }
    
    public static void multiplyMatrices(Scanner scan) {
    }
    
    public static int[][] readMatrix(Scanner scan, int r, int c) {
        int[][] matrix = new int[r][c];  
        return matrix;
    }
    
    public static void printMatrix(int[][] matrix) {
        
    }
    
}