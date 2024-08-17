public class ContinguousStr {
    public static int printSubString(String str, int i, int j, int n) {
        if(n == 1 || n <= 0) {
            return n;
        }

        int result = printSubString(str, i+1, j, n-1) + printSubString(str, i, j-1, n-1) - printSubString(str, i+1, j-1, n-2);
        if(str.charAt(i) == str.charAt(j)) {
            result++;
        }

        return result;
    }
    public static void main(String[] args) {
        String str = "aba";
        int ans = printSubString(str, 0, str.length()-1, str.length());   
        System.out.println(ans);
    }
}
