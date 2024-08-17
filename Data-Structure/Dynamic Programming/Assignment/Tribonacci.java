package Assignment;

public class Tribonacci {

    public static void tribonacci(int n) {
        int dp[] = new int[n];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        print(dp);
    }

    public static void print(int dp[]) {
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 10;
        tribonacci(n);
    }
}
