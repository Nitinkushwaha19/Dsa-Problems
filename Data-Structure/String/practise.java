import java.util.Arrays;

public class practise {

    public static void countVowels(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        System.out.println("Count of vowels " + count);
    }

    public static void isAnagrama(String str1, String str2) {
        // Convert Strings to lowercase so that we don't have to check seprately for
        // lower and uppercase.
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // First check length of both strings
        if (str1.length() == str2.length()) {

            // convert string into char Arrays
            char[] str1charArray = str1.toCharArray();
            char[] str2charArray = str2.toCharArray();

            // sort the char Array
            Arrays.sort(str1charArray);
            Arrays.sort(str2charArray);

            // check sorted arrays are equal or not
            boolean result = Arrays.equals(str1charArray, str2charArray);
            if (result) {
                System.out.println(str1 + " and " + str2 + " are anagrams of each others. ");
            } else {
                System.out.println(str1 + " and " + str2 + " are not anagrams of each others. ");
            }
        } else {
            System.out.println(str1 + " and " + str2 + " are not anagrams of each others. ");
        }

    }

    public static void main(String args[]) {
        // String str = "nitin kushwaha";
        // countVowels(str);

        String str1 = "earth";
        String str2 = "heart";
        isAnagrama(str1, str2);

    }
}
