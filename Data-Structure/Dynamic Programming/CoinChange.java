public class CoinChange {
    public static void print(int dp[][]) {
        for(int i = 0;i<dp.length;i++) {
            for(int j = 0;j<dp[0].length;j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int totalWays(int coin[], int sum) {
        int n = coin.length;
        int dp[][] = new int[n + 1][sum + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (coin[i - 1] <= j) { // valid case
                    dp[i][j] = dp[i][j - coin[i - 1]] + dp[i - 1][j]; // total ways = include coin and exclude coin
                } else { // invalid case
                    dp[i][j] = dp[i - 1][j]; // exclude coins
                }
            }
        }
        print(dp);
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int coin[] = { 2, 5, 3, 6 };
        int sum = 10;
        System.out.println(totalWays(coin, sum));
    }
}
