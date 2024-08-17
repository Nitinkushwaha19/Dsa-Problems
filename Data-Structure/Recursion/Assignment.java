public class Assignment {

    public static void printAllOccur(int arr[], int key, int idx) {
        // base
        if (idx == arr.length) {
            return;
        }
        // work
        if (arr[idx] == key) {
            System.out.print(idx + " ");
        }
        printAllOccur(arr, key, idx + 1);
    }

    static String digit[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    public static void printDigit(int number) {
        if (number == 0) {
            return;
        }
        int lastDigit = number % 10;
        printDigit(number / 10);
        System.out.print(digit[lastDigit] + " ");
    }

    public static int lengthOfStr(String str) {
        if( str.length() == 0){
            return 0;
        }
        return lengthOfStr(str.substring(1)) + 1;
    }

    public static void main(String args[]) {
        // Print All Occurences
        // int arr[] = { 3, 2, 4, 5, 6, 2, 7, 2, 2 };
        // printAllOccur(arr, 2, 0);

        // Convert number into strings
        // printDigit(17);

        // Print Length of String 
        System.out.println(lengthOfStr("abcab"));


    }
}
