public class GridWays {

    public static int gridWays(int i, int j, int n, int m) {

        // base
        if (i == n - 1 || j == m - 1) {
            return 1;
        } else if (i == n || j == m) {
            return 0;
        }

        // recursion
        int w1 = gridWays(i + 1, j, n, m);
        int w2 = gridWays(i, j + 1, n, m);

        return w1 + w2;

    }

    // Mathematical formula -- to calculate permutation 
    public static int calGridWays(int m, int n) {
        int mpnf = fact((n - 1) + (m - 1)); // ((n-1) + (m-1))!
        int nmf = fact((n - 1)); // (n-1)!
        int mmf = fact((m - 1)); // (m-1)!

        return mpnf / (nmf * mmf);  // ((n-1) + (m-1))! / (n-1)! * (m-1)!;

    }

    public static int fact(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * fact(n - 1);
    }

    public static void main(String args[]) {
        int n = 3, m = 3;
        System.out.println(calGridWays(n, m));
    }
}
