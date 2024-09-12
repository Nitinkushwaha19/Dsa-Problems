public class SurroundedReigion {
    class Solution {

        public static void dfs(char[][] board, int row, int col, int n, int m,
                                     boolean[][] vis){
    
            if( row < 0 || row >= n || col < 0 || col >= m || vis[row][col] ||
                board[row][col] == 'X') {
                return;
            }   
    
            vis[row][col] = true;
    
            dfs(board,row-1,col,n,m,vis);
            dfs(board,row+1,col,n,m,vis);
            dfs(board,row,col-1,n,m,vis);
            dfs(board,row,col+1,n,m,vis);
    
    
        }
        public void solve(char[][] board) {
            int n = board.length;
            int m = board[0].length;
            boolean[][] vis = new boolean[n][m];
    
            // left and right boundary
            for(int i = 0;i<n;i++){
                if(board[i][0] == 'O'){
                    dfs(board,i,0,n,m,vis);
                }
    
                if(board[i][m-1] == 'O'){
                    dfs(board,i,m-1,n,m,vis);
                }
            }
    
            // upper and down boundary
            for(int i = 0;i<m;i++){
                if(board[0][i] == 'O'){
                    dfs(board,0,i,n,m,vis);
                }
    
                if(board[n-1][i] == 'O'){
                    dfs(board,n-1,i,n,m,vis);
                }
            }
    
    
            for(int i = 0;i<n;i++){
                for(int j = 0;j<m;j++){
                    if(board[i][j] == 'O' && !vis[i][j]){
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }
}
