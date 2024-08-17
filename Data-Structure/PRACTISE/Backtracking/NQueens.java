import java.util.*;

public class NQueens {
    public static boolean isSafe(char board[][], int row, int col) {
        // vertical-up condition
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // left-up diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // right-up diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void nQueens(char board[][], int row, List<List<String>> ans) {
        if (row == board.length) {
            list(board, ans);
            return;
        }

        // Column loop
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row + 1, ans);
                board[row][j] = '.';
            }
        }
    }

    public static void printBoard(char board[][]) {
        System.out.println("--------------- Chess Board ------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void list(char board[][], List<List<String>> ans) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String str = "";
            for (int j = 0; j < board.length; j++) {
                str += board[i][j];
            }
            res.add(str);
        }
        ans.add(res);

    }

    public static void main(String[] args) {
        int n = 4;
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        nQueens(board, 0, ans);
        System.out.println(ans);
    }
}
