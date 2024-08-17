public class FriendsPair {
    public static int totalWays (int n) {
        if(n == 1 || n == 2) {
            return n;
        }

        int single = totalWays(n-1) ;
        int pair = (n-1) * totalWays(n-2);

        return single + pair;
    }
    public static void main(String[] args) {
        int n = 3;
        System.out.println(totalWays(n));
    }
}
