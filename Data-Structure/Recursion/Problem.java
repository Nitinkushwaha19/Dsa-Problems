public class Problem {

    // Tilling problem
    public static int tillingProblem(int n) {
        // base case
        if (n == 0 || n == 1) {
            return 1;
        }
        // work
        // vertical choice
        // int fnm1 = tillingProblem(n - 1);

        // // horizontal choice
        // int fnm2 = tillingProblem(n - 2);

        // int totWays = fnm1 + fnm2;
        // return totWays;

        return tillingProblem(n-1) + tillingProblem(n-2);
        
    }

    // Remove Duplicates
    public static void removeDuplicate(String str, int idx, StringBuilder newStr, boolean map[]) {
        // base
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }
        // kaam
        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == true) {
            // duplicate
            removeDuplicate(str, idx + 1, newStr, map);
        } else {
            // non duplicate
            map[currChar - 'a'] = true;
            removeDuplicate(str, idx + 1, newStr.append(currChar), map);
        }
    }

    // Friends Pairing Problem
    public static int friendsPairing(int n) {
        // base
        if (n == 1 || n == 2) {
            return n;
        }

        return friendsPairing(n-1) + (n-1) * friendsPairing(n-2);
    }

    // Print Binary String
    public static void printBinStrings(int n, int lastPlace,String str) {
        // base class 
        if(n == 0) {
            System.out.println(str);
            return;
        }

        // kaam
        // last place 0  
        printBinStrings(n-1, 0, str+"0");

        if(lastPlace == 0) {
            printBinStrings(n-1, 1, str+"1");
        }
    }
    public static void main(String args[]) {

        // Tilling problem
        // System.out.println(tillingProblem(4));

        // Remove duplicates
        // String str = "nitin";
        // removeDuplicate(str, 0, new StringBuilder(""), new boolean[25]);

        // Friends Pairing problem
        // System.out.println(friendsPairing(4));

        // Print Binary String problem
        printBinStrings(3, 0, "");
    }
}
