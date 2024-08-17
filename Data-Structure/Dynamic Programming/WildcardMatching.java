public class WildcardMatching { // Tc = O(n*m)
    public static boolean wildcardMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean dp[][] = new boolean[n+1][m+1];

        // intialization
        dp[0][0] = true;
        for(int i = 1;i<n+1;i++) {
            for(int j = 1;j<m+1;j++) {
                if(i != 0 && j == 0) {
                    dp[i][j] = false;
                } else if(i == 0 && p.charAt(j-1) == '*') {
                    dp[i][j] = dp[0][j-1];
                }
            }
        }

        // Approach
        for(int i = 1;i<n+1;i++) {
            for(int j = 1;j<m+1;j++) {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if(p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }
    public static void main(String[] args) {
        String s = "baabab";
        String p = "a*ab";
        System.out.println(wildcardMatch(s, p));
    }
}
