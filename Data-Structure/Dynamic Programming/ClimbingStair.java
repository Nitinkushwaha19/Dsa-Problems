import java.util.Arrays;

public class ClimbingStair {

    public static int ways(int n) {  // Approach :- Time complexity : O(2^n)

        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

       
        return ways(n - 1) + ways(n - 2);
    }

    public static int memoization(int n, int dp[]) {  // memoization Dp :-  Time complexity : O(n)

        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = memoization(n - 1, dp) + memoization(n - 2, dp);
    }

    public static int tabulation(int n, int dp[])  { // Tabulation Dp :- time comp :- O(n)
        dp[0] = 1;
        for(int i = 1;i<=n;i++) {
            if(i == 1) {
                dp[i] = dp[i-1];
            } else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(tabulation(n, dp));
    }
}
