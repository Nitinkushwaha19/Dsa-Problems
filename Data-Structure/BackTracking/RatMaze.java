public class RatMaze {

    public static boolean isSafe(int maze[][], int x, int y) {
        return (x >= 0 && x < maze.length && y >= 0 && y < maze.length && maze[x][y] == 1);
    }

    public static boolean solveMaze(int maze[][], int x, int y, int sol[][]) {
        // base
        if (x == maze.length - 1 && y == maze.length - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }
        // recursion
        if (isSafe(maze, x, y)) {

            if (sol[x][y] == 1) {
                return false;
            }
            sol[x][y] = 1;

            if (solveMaze(maze, x + 1, y, sol)) {
                return true;
            }

            if (solveMaze(maze, x, y + 1, sol)) {
                return true;
            }

            if (solveMaze(maze, x - 1, y, sol)) {
                return true;
            }

            if (solveMaze(maze, x, y + 1, sol)) {
                return true;
            }

            sol[x][y] = 0; // backtracking
            return false;
        }

        return false;
    }

    public static void ratMaze(int maze[][], int x, int y, int n, boolean visited[][], String ans) {
        // base
        if (x < 0 || y < 0 || x >= n || y >= n) {
            return;
        }

        if (maze[x][y] == 0 || visited[x][y] == true) {
            return;
        }

        if (x == n-1 && y == n-1) {
            
            System.out.println("Reached destination with path " + ans);
            return;
        }

        visited[x][y] = true;
        // recursion
        ratMaze(maze, x - 1, y, n, visited, ans+"U");
        ratMaze(maze, x + 1, y, n, visited, ans+"D");
        ratMaze(maze, x, y - 1, n, visited, ans+"L");
        ratMaze(maze, x, y + 1, n, visited, ans+"R");

        visited[x][y] = false;
    }

    public static void printSolution(int sol[][]) {
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol.length; j++) {
                System.out.print(" " + sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int maze[][] = {
                { 1, 0, 0, 0,},
                { 1, 1, 0, 0,},
                { 0, 1, 0, 0,},
                { 0, 1, 1, 1,}
        };

        int n = maze.length;
        int sol[][] = new int[n][n];
        if (solveMaze(maze, 0, 0, sol)) {
            System.out.println("Solution exist");
            printSolution(sol);
        } else {
            System.out.println("Solution does not exist");
        }


        // 2nd method 
        boolean visited[][] = new boolean[n][n];
        ratMaze(maze, 0, 0, n, visited, "");
    }

}
