public class FindSubset {

    public static void findSubset(String str, String ans, int i) {
        // base case
        if (i == str.length()) {
            if (ans.length() == 0 ) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }

            return;
        }

        // choices : yes 
        findSubset(str,ans + str.charAt(i),i+1);
        // choice : NO
        findSubset(str,ans,i+1);

    }

    public static void main(String args[]) {
        findSubset("abc","",0);
    }
}
