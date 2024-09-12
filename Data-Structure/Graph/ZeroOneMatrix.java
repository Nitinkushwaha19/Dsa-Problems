import java.util.*;
import java.util.LinkedList;

public class ZeroOneMatrix {
    class Solution {
    static class Pair {
        int row;
        int col;

        public Pair (int r, int c){
            this.row = r;
            this.col = c;
        }
    }
    
    public int[][] updateMatrix(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        Queue<Pair> q = new LinkedList<>(); 
        boolean[][] vis = new boolean[m][n];   

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(i,j));
                    vis[i][j] = true;
                } else {
                    mat[i][j] = m + n;
                }
            }
        }


        int drow[] = {-1,0,0,1};
        int dcol[] = {0,-1,1,0};

        while(!q.isEmpty()){
            Pair curr = q.remove();
            int r = curr.row;
            int c = curr.col;

            for(int i = 0;i<4;i++){
                int row = r + drow[i];
                int col = c + dcol[i];

                if(row >= 0 && row < m && col >= 0 && col < n && !vis[row][col]) {
                    if( mat[row][col] > mat[r][c]){
                        mat[row][col] = mat[r][c] + 1;
                        q.add(new Pair(row,col));
                        vis[row][col] = true;
                    }
                }
            }
        }

        return mat;
    }
}
}
