import java.util.*;
import java.util.LinkedList;

public class RottenOranges {
    class Solution {
        static class Pair {
            int row;
            int col;
            int time;

            public Pair(int r, int c, int t) {
                this.row = r;
                this.col = c;
                this.time = t;
            }
        }

        public int orangesRotting(int[][] grid) {

            int m = grid.length;
            int n = grid[0].length;
            int[][] vis = new int[m][n];
            Queue<Pair> q = new LinkedList<>();
            int cntFresh = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) {
                        q.add(new Pair(i, j, 0));
                        vis[i][j] = 2;
                    }

                    if (grid[i][j] == 1)
                        cntFresh++;
                }
            }

            int maxTime = 0;
            int[] drow = { -1, 0, 0, 1 };
            int[] dcol = { 0, -1, 1, 0 };

            while (!q.isEmpty()) {
                Pair curr = q.remove();

                int r = curr.row;
                int c = curr.col;
                int t = curr.time;

                maxTime = Math.max(maxTime, t);

                for (int i = 0; i < 4; i++) {

                    int row = r + drow[i];
                    int col = c + dcol[i];

                    if (row >= 0 && row < m && col >= 0 && col < n && vis[row][col] == 0 && grid[row][col] == 1) {
                        q.add(new Pair(row, col, t + 1));
                        vis[row][col] = 2;
                        cntFresh--;
                    }
                }
            }

            return cntFresh == 0 ? maxTime : -1;
        }
    }
}