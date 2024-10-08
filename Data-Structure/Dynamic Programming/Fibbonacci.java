public class Fibbonacci {
    public static int fib(int n, int dp[]) {
        if( n == 1 || n == 0) {
            return n;
        }
        if(dp[n] != 0) {
            return dp[n];
        }

        return dp[n] = fib(n-1, dp) + fib(n-2, dp);
    }
    public static void main(String[] args) {
        int n = 5;
        int dp[] = new int[n+1];
        System.out.println(fib(n, dp));
    }  
}  