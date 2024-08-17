public class Nqueens {

    public static void printBoard(char board[][]) {
        System.out.println("----------- chess board ----------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(char board[][], int row, int col) {
        // vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // diagonal left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // diagonal right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void nQueens(char board[][], int row) {
        // base
        if (row == board.length) {
            // printBoard(board);
            count++;
            return;
        }
        // column loop
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row + 1); // function call
                board[row][j] = '*'; // backtracking step
            }
        }
    }

    public static int count = 0;

    // check if problem can be solved & print only 1 solution n queens problem.
    public static boolean checkNqueens(char board[][], int row) {
        // base
        if (row == board.length) {
            count++;
            return true;
        }
        // column loop
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                if (checkNqueens(board, row + 1)) {
                    return true;
                }
                board[row][j] = '*';
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int n = 4;
        char board[][] = new char[n][n];
        // intializing board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '*';
            }
        }

        // nQueens(board, 0);
        // System.out.println("Total ways to place n queens = " + count);

        if(checkNqueens(board, 0)) {
            System.out.println("Solution is possible");
            printBoard(board);
        } else {
            System.out.println("Solution is not possible");
        }
    }
}
