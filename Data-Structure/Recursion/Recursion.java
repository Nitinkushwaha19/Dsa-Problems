public class Recursion {

    // Recursion function
    public static int fact(int n) {
        if (n < 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

    // Print number in decreasing order
    public static void print(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        System.out.print(n + " ");
        print(n - 1);
    }

    // Print number in increasing order
    public static void printInc(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        printInc(n - 1);
        System.out.print(n + " ");
    }

    // Sum of N natural number
    public static int sumOfN(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumOfN(n - 1);
    }

    // Fibonacci series
    public static int fib(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        int fnm1 = fib(n - 1);
        int fnm2 = fib(n - 2);
        int fn = fnm1 + fnm2;
        return fn;
    }

    // IsSorted
    public static boolean isSorted(int arr[], int i) {
        if (i == arr.length - 1) {
            return true;
        }

        if (arr[i] > arr[i + 1]) {
            return false;
        }

        return isSorted(arr, i + 1);
    }

    // First Occurence
    public static int firstOccurence(int arr[], int key, int i) {
        if (i == arr.length - 1) {
            return -1;
        }

        if (arr[i] == key) {
            return i;
        }

        return firstOccurence(arr, key, i + 1);
    }

    // Last Occurence
    public static int lastOccurence(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }

        int isFound = lastOccurence(arr, key, i + 1);
        if (isFound == -1 && arr[i] == key) {
            return i;
        }

        return isFound;
    }

    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }

        return x * power(x, n - 1);
    }

    public static int optimizedPower (int x , int n) {
        if( n == 0) {
            return 1;
        }

        int halfPower = optimizedPower(x, n/2);
        int halfPowerSq = halfPower * halfPower;

        // n is odd
        if(n % 2 != 0) {
            halfPowerSq = x * halfPowerSq; 
        }

        return halfPowerSq;
    }

    public static void main(String args[]) {
        // Recursion functions
        // System.out.print(fact(4));

        // printInc(10);

        // Sum of n natural numbers
        // System.out.println(sumOfN(10));

        // Fibonacci of n
        // System.out.println(fib(20));

        // Array is sorted or not
        // int arr[] = { 1, 3, 4, 5 , 6 , 7 , 5 , 8};
        // System.out.println(isSorted(arr, 0));

        // First occurence
        // System.out.println(firstOccurence(arr, 5, 0));

        // Last Occurence
        // System.out.println(lastOccurence(arr, 5, 0));

        // power
        System.out.println(power(2, 10));
        // optimized Power 
        System.out.println(optimizedPower(2, 5));
    }
}