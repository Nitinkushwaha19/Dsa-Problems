public class RodCutting {
    public static void print(int dp[][]) {
        for(int i = 0;i<dp.length;i++) {
            for(int j = 0;j<dp[0].length;j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int rodCutting(int length[], int prices[], int rodLength) {
        int n = length.length;
        int dp[][] = new int[n+1][rodLength+1];

        for(int i = 0;i<dp.length;i++) {
            dp[i][0] = 0;
        }
        for(int i = 0;i<dp[0].length;i++) {
            dp[0][i] = 0;
        }

        for(int i = 1;i<n+1;i++) {
            for(int j = 1;j<rodLength+1;j++) {
                if(length[i-1] <= j) { // valid case 
                    // include 
                    dp[i][j] = Math.max(prices[i-1] + dp[i][j-length[i-1]], dp[i-1][j]);
                } else { // invalid case
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        print(dp);
        return dp[n][rodLength];
    }
    public static void main(String[] args) {
        
        int length[] = {1,2,3,4,5,6,7,8};
        int prices [] = {1,5,8,9,10,17,17,20};
        int rodLength = 8;
        System.out.println(rodCutting(length, prices, rodLength));
    }
}
