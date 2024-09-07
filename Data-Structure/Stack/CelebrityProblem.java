public class CelebrityProblem {

    // mat[][] = [[0 1 0],
    //             [0 0 0], 
    //             [0 1 0]]
    

    public int celebrity(int mat[][]) {
        // code here
        int bottom = mat.length-1;
        int top = 0;
        
        while( top != bottom){
            
            if(mat[top][bottom] == 1){
                top++;
                
            } else if( mat[bottom][top] == 1){
                bottom--;
            } else {
                top++;
                bottom--;
            }
        }
        
        if(top > bottom){
            return -1;
        }
        
        for(int i = 0;i<mat.length;i++){
            if(i == top){
                continue;
            }
            
            if(mat[top][i] != 0 || mat[i][top] != 1) {
                return -1;
            }
        }
        
        return top;
    }
}
