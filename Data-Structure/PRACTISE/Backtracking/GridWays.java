public class GridWays {
    public static int gridWays(int i, int j, int n, int m) {
        if (i == n - 1 && j == m - 1) {
            return 1;
        } else if (i >= n || j >= m) {
            return 0;
        }

        // down
        int w1 = gridWays(i + 1, j, n, m);
        // right
        int w2 = gridWays(i, j + 1, n, m);

        return w1 + w2;
    }

    public static int ways(int i, int j, int n, int m) {
        return (fact((n - 1) + (m - 1))) / (fact(n - 1) * fact(m - 1));
    }

    public static int fact(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * fact(n - 1);
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(gridWays(0, 0, n, n));
        System.out.println(ways(0, 0, n, n));
    }
}
