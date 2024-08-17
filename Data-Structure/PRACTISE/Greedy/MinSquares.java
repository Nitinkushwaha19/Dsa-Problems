public class MinSquares {
    public static int minSquares(int A, int B) {
        int ans = 0;
        while (A > 0 && B > 0) {
            if (A < B) {
                ans += B/A;
                B = B % A;
            } else {
                ans += A/B;
                A = A % B;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int A = 29, B = 13;
        System.out.println(minSquares(A, B));
    }
}
