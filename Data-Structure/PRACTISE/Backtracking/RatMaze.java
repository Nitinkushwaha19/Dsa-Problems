public class RatMaze {
    public static boolean isSafe(int maze[][], int row, int col) {
        return (row >= 0 && row < maze.length && col >= 0 && col < maze.length && maze[row][col] == 1);
    }

    public static boolean solveMaze (int maze[][], int row, int col, int sol[][]) {
        // base case 
        if( row == maze.length -1 && col == maze.length -1 && maze[row][col] == 1) {
            sol[row][col] = 1;
            return true;
        }

        if(isSafe(maze,row,col)) {
            if(sol[row][col] == 1) {
                return false;
            }
            sol[row][col] = 1;

            // up
            if(solveMaze(maze, row-1, col, sol)) {
                return true;
            }

            // Down
            if(solveMaze(maze, row+1, col, sol)) {
                return true;
            }

            // Right
            if(solveMaze(maze, row, col+1, sol)) {
                return true;
            }

            // left
            if(solveMaze(maze, row, col-1, sol)) {
                return true;
            }

            // backtracking
            sol[row][col] = 0;
            return false;
        }
        return false;
    }
    public static void main(String[] args) {
        int maze [][] = {
            {1,0,0,0},
            {1,1,0,1},
            {0,1,0,0},
            {1,1,1,1}
        };

        int sol[][] = new int[maze.length][maze.length];

        solveMaze(maze, 0, 0, sol);
        for(int i = 0;i<maze.length;i++) {
            for(int j = 0;j<maze.length;j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }
}
