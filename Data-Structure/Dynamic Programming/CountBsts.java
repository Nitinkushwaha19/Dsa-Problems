public class CountBsts {
    public static int countBst(int n) {
        int dp[] = new int[n + 1];
        // Initialization
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1]; // coutBst = left tree * right tree
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(countBst(n));
    }
}
    