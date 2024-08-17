import java.util.*;

public class ArraysCC {

    public static void update(int marks[]) {
        for (int i = 0; i < marks.length; i++) {
            marks[i] += 1;
        }
    }

    public static int linearSearch(int number[], int key) {
        for (int i = 0; i < number.length; i++) {
            if (number[i] == key) {
                return i;
            }
        }

        return -1;
    }

    public static int getLargest(int number[]) {
        int largest = Integer.MIN_VALUE; // - infinity
        int smallest = Integer.MAX_VALUE; // + infinity
        for (int i = 0; i < number.length; i++) {
            if (largest < number[i]) {
                largest = number[i];
            }
            if (smallest > number[i]) {
                smallest = number[i];
            }
        }
        System.out.println("Smallest number is : " + smallest);
        return largest;
    }

    public static int binarySearch(int number[], int key) {
        int start = 0, end = number.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            // Comparisons
            if (number[mid] == key) { // key found
                return mid;
            }
            if (number[mid] < key) { // right
                start = mid + 1;
            } else { // left
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void reverse(int number[]) {
        int start = 0, last = number.length - 1;
        while (start < last) {
            int temp = number[last];
            number[last] = number[start];
            number[start] = temp;

            start++;
            last--;
        }
    }

    public static void pairsArray(int number[]) {
        int tp = 0;
        for (int i = 0; i < number.length; i++) {
            int curr = number[i];
            for (int j = i + 1; j < number.length; j++) {
                System.out.print("(" + curr + "," + number[j] + ")");
            }
            System.out.println();
        }
        System.out.println("Total no. of pairs : " + tp);
    }

    // Brute Force Code ----> Basic operation // time complexity is O(n3)
    public static void subArrays(int number[]) {
        int ts = 0;
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < number.length; i++) {
            int start = i;
            for (int j = i; j < number.length; j++) {
                int end = j;
                int sum = 0;
                for (int k = start; k <= end; k++) {
                    sum += number[k];
                    System.out.print(number[k] + " ");
                }
                ts++;
                if (largest < sum) {
                    largest = sum;
                }
                if (smallest > sum) {
                    smallest = sum;
                }
                System.out.println("| Sum : " + sum);
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("Total subarrays is : " + ts);
        System.out.println("Largest sum in arrays : " + largest);
        System.out.println("Smallest sum in arrays : " + smallest);
    }

    // Optimized solution for subarrays max element -- // time complexity : O(n2)
    public static void MaxSubarraySum(int number[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[number.length];

        // To calculate prefix --->
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + number[i];
        }

        // To find Subarrays
        for (int i = 0; i < number.length; i++) {
            int start = i;
            for (int j = i; j < number.length; j++) {
                int end = j;

                currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];

                if (maxSum < currSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("Max of subarrays : " + maxSum);
    }


    // Kadanes algorithm to find Subarrays 
    public static void Kadanes(int number[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0;i<number.length;i++) {
            currSum = currSum + number[i];
            if(currSum < 0) {
                currSum = 0;
            }
            maxSum = Math.max(maxSum, currSum);
        }
        System.out.println("Maximum sum is : " + maxSum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // intializing the size and element of array
        // int number[] = {12,23,4,5};
        // String fruits [] = {"Mango","Apple","Gauva"};

        // declaring size of array
        // int marks[] = new int[4];

        // marks[0] = 22;
        // marks[1] = 23;
        // marks[2] = 24;
        // marks[3] = 25;

        // for(int i=0;i<marks.length;i++){
        // marks[i] = marks[i] + 1;
        // }

        // update(marks);

        // for (int i = 0; i < marks.length; i++) {
        // System.out.print(marks[i] + " ");
        // }

        // Linear Search --->
        // int number[] = { 11, 12, 14, 15, 16, 17, 18, 19, 20 };
        // int key = 15;

        // int index = linearSearch(number, key);

        // if (index != -1 ) {
        // System.out.println("Index is at a " + index);
        // } else {
        // System.out.println("Not Found");
        // }

        // Largest number in Array
        // int number[] = { 1, 2, 6, 3, 5 };
        // int largestNumber = getLargest(number);
        // System.out.println("Largest number is " + largestNumber);

        // Binary Search
        // int number[] = {2,4,6,8,10,12,14,16,18,20};
        // System.out.println("Number is at index : "+binarySearch(number, 25));

        // Reverse of Array
        // int number[] = { 2, 4, 6, 8, 10, 12 };
        // reverse(number);

        // for (int i = 0; i < number.length; i++) {
        // System.out.print(number[i] + " ");
        // }

        // Pair of Array
        // int number[] = { 1, -2, 6, -1, 3 };
        // pairsArray(number);

        // SubArrays
        // subArrays(number);
        // MaxSubarraySum(number);


        // Kadanes algorithm to find subarrays 
        int arr[] = {-2,-1,4,-1,-2,1,5,-3};
        Kadanes(arr);
        sc.close();
    }

}
