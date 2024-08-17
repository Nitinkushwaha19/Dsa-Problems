import java.util.*;

public class Strings {

    public static boolean isPalindrome(String str) {
        int n = str.length();
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static float getShortPath(String path) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < path.length(); i++) {
            char dir = path.charAt(i);

            // south
            if (dir == 'S') {
                y--;
            }
            // North
            else if (dir == 'N') {
                y++;
            }
            // West
            else if (dir == 'W') {
                x--;
            }
            // East
            else {
                x++;
            }

        }
        int x2 = x * x;
        int y2 = y * y;
        return (float) Math.sqrt(x2 + y2);
    }

    public static String toUpperCase(String str) {
        StringBuilder sb = new StringBuilder("");

        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String compress(String str) {
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }

            sb.append(str.charAt(i));
            if (count > 1) {
                sb.append(count.toString());
            }
        }

        return sb.toString();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // String name = sc.nextLine();
        // System.out.println(name.charAt(0));

        // String str = "nitin";
        // System.out.println(isPalindrome(str));

        // Shortest Path
        // String path = "NS";
        // System.out.println(getShortPath(path));

        // Largest string
        // String fruits [] = {"apple","mango","banana"};
        // String largest = fruits[0];
        // for(int i =1;i<fruits.length;i++) {
        // if(largest.compareTo(fruits[i]) < 0 ) {
        // largest = fruits[i];
        // }
        // }
        // System.out.println(largest);

        // StringBuilder
        // StringBuilder sb = new StringBuilder("");

        // for (char ch = 'a'; ch <= 'z'; ch++) {
        // sb.append(ch);
        // }
        // System.out.println(sb.length());

        // Convert letters to uppercase
        // String str = "Hi, i am nitin kushwaha.";
        // System.out.println(toUpperCase(str));
        
        
        // compression of string 
        String str = "abcd";
        System.out.println(compress(str));
        
        sc.close();
    }
}