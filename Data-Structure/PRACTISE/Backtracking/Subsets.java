public class Subsets {
    public static void subset(String str, int idx, String ans) {
        if(idx == str.length()) {
            System.out.println(ans);
            return;
        }

        // Choice : yes
        subset(str, idx+1, ans + str.charAt(idx));
        // Choice : No
        subset(str, idx+1, ans);
    }
    public static void main(String args[]) {
        String str = "abc";
        subset(str, 0, "");
    }
}