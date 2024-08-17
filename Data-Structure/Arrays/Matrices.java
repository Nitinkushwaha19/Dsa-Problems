import java.util.*;

public class Matrices {

    public static void search(int matrix[][], int key) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (key == matrix[i][j]) {
                    System.out.println("key found at index : (" + i + "," + j + ")");
                    return;
                }
            }
        }
        System.out.println("key not found");
    }

    public static int largestNum(int matrix[][]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (largest < matrix[i][j]) {
                    largest = matrix[i][j];
                }
            }
        }
        return largest;
    }

    public static void printSpiral(int matrix[][]) {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {

            // Top
            for (int j = startCol; j <= endCol; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }

            // Right
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }

            // Bottom
            for (int j = endCol - 1; j >= startCol; j--) {
                if (startRow == endRow) {
                    break;
                }
                System.out.print(matrix[endRow][j] + " ");
            }

            // Left
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                if (startCol == endCol) {
                    break;
                }
                System.out.print(matrix[i][startCol] + " ");
            }

            startCol++;
            startRow++;
            endCol--;
            endRow--;

        }
    }

    public static int diagonalSum(int matrix[][]) {
        int sum = 0;

        // Brut force code ----> O(n^2)
        // for(int i = 0;i<matrix.length;i++) {
        // for(int j=0;j<matrix[0].length;j++) {
        // if(i ==j) {
        // sum += matrix[i][j];
        // } else if(i+j == matrix.length-1) {
        // sum += matrix[i][j];
        // }
        // }
        // }

        // Optimized code
        for (int i = 0; i < matrix.length; i++) {
            // primary diagonal
            sum += matrix[i][i];
            // secondary diagonal
            if (i != matrix.length - 1 - i)
                sum += matrix[i][matrix.length - i - 1];
        }

        return sum;

    }

    public static boolean staircaseSearch(int matrix[][], int key) {
        int row = matrix.length-1, col = 0;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == key) {
                System.out.println("Key found at (" + row + "," + col + ")");
                return true;
            }
            else if(key < matrix[row][col]) {
                row--;
            } else {
                col++;
            }
        }
        System.out.println("Key not found!");
        return false;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // 2D Arrrays
        // int matrix[][] = new int[3][3];
        // int n = matrix.length, m = matrix[0].length;

        // // input
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < m; j++) {
        // matrix[i][j] = sc.nextInt();
        // }

        // }
        sc.close();

        // output
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < m; j++) {
        // System.out.print(matrix[i][j] + " ");
        // }
        // System.out.println();
        // }

        // search
        // search(matrix, 5);

        // largest number
        // System.out.println("Largest number is : " + largestNum(matrix));

        // Spiral Matrix
        int matrix[][] = { { 10, 20, 30, 40 },
                           { 15, 25, 35, 45 },
                           { 27, 29, 37, 48 },
                           { 32, 33, 39, 50 },
        };

        // Spiral arrays
        // printSpiral(matrix);

        // diagonal sum
        // System.out.println(diagonalSum(matrix));


        // Staircase Search
        staircaseSearch(matrix, 30);
    }
}