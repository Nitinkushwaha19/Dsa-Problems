public class Knapsack {

    public static int knapsack(int val[], int wt[], int W, int n) {
        if (W == 0 || n == 0) {
            return 0;
        }

        if (wt[n - 1] <= W) { // valid
            // include
            int ans1 = val[n - 1] + knapsack(val, wt, W - wt[n - 1], n - 1);
            // exclude
            int ans2 = knapsack(val, wt, W, n - 1);
            return Math.max(ans1, ans2);
        } else { // not valid
            return knapsack(val, wt, W, n - 1);
        }
    }

    public static int knapsackMemo(int val[], int wt[], int W, int n, int dp[][]) {
        if (W == 0 || n == 0) {
            return 0;
        }

        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (wt[n - 1] <= W) { // valid
            // include
            int ans1 = val[n - 1] + knapsackMemo(val, wt, W - wt[n - 1], n - 1, dp);
            // exclude
            int ans2 = knapsackMemo(val, wt, W, n - 1, dp);
            return dp[n][W] = Math.max(ans1, ans2);
        } else { // not valid
            return dp[n][W] = knapsackMemo(val, wt, W, n - 1, dp);
        }
    }

    public static void printTab(int dp[][]) {
        for(int i = 0;i<dp.length;i++) {
            for(int j = 0;j<dp[0].length;j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int knapsackTap(int val[], int wt[], int W) {
        // Create Table
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        
        // Initialize 
        for(int i = 0;i<dp.length;i++) { // for 0th col
            dp[i][0] = 0;
        }

        for(int i = 0;i<dp[0].length;i++) { // for 0th row
            dp[0][i] = 0;
        }

        for(int i = 1;i<n+1;i++) {
            for(int j = 1;j<W+1;j++) {
                int v = val[i-1]; // ith idx of val
                int w = wt[i-1]; // ith idx of wt

                if(w <= j) { // valid case 
                    // j = knapsack capacity at each level
                    int incProfit = v + dp[i-1][j-w];  // include
                    int excProfit = dp[i-1][j]; // exclude 
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else { // invalid case
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        printTab(dp);
        return dp[n][W];
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        int dp[][] = new int[val.length + 1][W + 1];
        for(int i = 0;i<dp.length;i++) {
            for(int j = 0;j<dp[i].length;j++) { 
                dp[i][j] = -1;
            }
        }
        // System.out.println(knapsackMemo(val, wt, W, val.length,dp));
        System.out.println(knapsackTap(val, wt, W));
    }
}
