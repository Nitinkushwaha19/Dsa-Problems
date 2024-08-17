// import java.util.*;
public class practiseQue2 {

    // count of 7
    public static void count(int matrix[][], int key) {
        int countKey = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == key) {
                    countKey++;
                }
            }
        }

        System.out.println("Count of " + key + " : " + countKey);
    }

    // sum of row
    public static int sumOfRow(int matrix[][], int row) {
        int sum = 0;

        for (int j = 0; j < matrix[0].length; j++) {
            sum += matrix[row][j];
        }

        return sum;
    }

    // print matrix
    public static void printMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Transpose of matrix
    public static void tranpose(int matrix[][]) {
        int row = 3, col = 2;
        int tranpose[][] = new int[row][col];

        System.out.println("Tranpose of Matrix : ");

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                tranpose[i][j] = matrix[j][i];
            }
        }

        printMatrix(tranpose);

    }

    public static void main(String args[]) {
        // int matrix[][] = { { 4, 7, 8 }, { 8, 8, 7 } };
        // count(matrix, 8);

        // int matrix[][] = { { 1, 4, 9 }, { 11, 4, 3 }, { 2, 2, 3 } };
        // System.out.println("Sum of row : " + sumOfRow(matrix, 1));

        // Tranpose of Matrix
        int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 } };
        printMatrix(matrix);
        tranpose(matrix);
    }
}
