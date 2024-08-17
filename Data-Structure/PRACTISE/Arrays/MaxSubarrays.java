public class MaxSubarrays {
    public static void maxSubArray(int arr[]) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                max = Math.max(max, sum);
                min = Math.min(min, sum);
            }
        }
        System.out.println("Maximum sum is : " + max);
        System.out.println("Minimum sum is : " + min);
    }

    // Prefix - sum
    public static void prefix_maxSubarray(int arr[]) {
        int currSum = 0;
        int max = Integer.MIN_VALUE;
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                currSum = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];
                max = Math.max(max, currSum);
            }
        }
        System.out.println("Maximum Sum is : " + max);
    }

    // Kadane's Algorithm
    public static int kadanes(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        int min = Integer.MIN_VALUE;
        int sum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                break;
            } else {
                min = Math.max(min, arr[i]);
            }
            count++;
        }

        if (count == arr.length) {
            return min;
        }

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (sum < 0) {
                sum = 0;
            }
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int arr[] = { 1,-2,6,-1,3 };
        // prefix_maxSubarray(arr);
        System.out.println(kadanes(arr));
        
    }
}