public class Assignment {
    public static void mergeSort(String arr[], int si, int ei) {
        // base
        if (si >= ei) {
            return;
        }

        // Kaam
        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(String arr[], int si, int mid, int ei) {
        String temp[] = new String[ei - si + 1];
        int i = si; // idx for left part
        int j = mid + 1; // idx for right part
        int k = 0; // idx for temp

        // comparing and merging sorted array
        while (i <= mid && j <= ei) {
            if (arr[i].compareTo(arr[j]) < 0) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // leftover elements of 1st array
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // leftover elements of 2nd array
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // copying element to original array
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void printArray(String arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // Majority element in array ---> time complexity O(n^2)
    public static int majorityElement(int arr[]) {
        int majorityCount = arr.length / 2;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count > majorityCount) {
                return arr[i];
            }
        }
        return -1;
    }

    // Optimized solution of Majority element in array ----> time complexity :
    // O(nlogn)
    public static int majorityElementRec(int nums[], int si, int ei) {
        // base condition
        if (si == ei) {
            return nums[si];
        }

        // Kaam
        int mid = si + (ei - si) / 2;
        int left = majorityElementRec(nums, si, mid); // traversing in left part
        int right = majorityElementRec(nums, mid + 1, ei); // traversing in right part

        // check left and right is same element
        if (left == right) {
            return left;
        }

        // if left and right are not same then count the majority element
        int leftCount = countArray(nums, left, si, ei);
        int rightCount = countArray(nums, right, si, ei);

        // return to majority element in array
        return leftCount > rightCount ? left : right;

    }

    public static int countArray(int nums[], int num, int si, int ei) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (num == nums[i]) {
                count++;
            }
        }
        return count;
    }

    // Brute force code for inversion count
    public static int getInversionCount(int arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // Optimized code for inversion count by using merge sort technique
    public static void getInvCount(int arr[]) {
        int invCount = mergeSort(arr, 0, arr.length-1);
        System.out.println("Inversion count is : " + invCount);
    }
    // Merge sort
    public static int mergeSort(int arr[], int si, int ei) {
        int invCount = 0;

        // base condition
        if (si < ei) {
            int mid = si + (ei - si) / 2;

            // for left part
            invCount = mergeSort(arr, si, mid);
            // for right part
            invCount += mergeSort(arr, mid + 1, ei);
            // for merging both side
            invCount += merge(arr, si, mid, ei);
        }
        return invCount;
    }

    public static int merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si, j = mid + 1, k = 0;
        int invCount = 0;

        while(i <= mid && j <= ei) {
            if(arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
                invCount += (mid+1) - i;
            }
            k++;
        }

        // leftover part for element in left side
        while(i <= mid) {
            temp[k++] = arr[i++];
        }

        // leftover part for element in right side
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // copy element to original array
        for(k=0,i=si;k<temp.length;k++,i++) {
            arr[i] = temp[k];
        }
        
        return invCount;
    }

    public static void main(String[] args) {
        // String arr[] = { "sun", "earth", "mars", "mercury" };
        // mergeSort(arr, 0, arr.length - 1);
        // printArray(arr);

        // Majority of element in array
        // int arr[] = { 2, 2, 1, 1, 1, 1, 2, 2 };
        // System.out.println(majorityElementRec(arr, 0, arr.length - 1));

        // Inversion Count
        // Brute force ---> Time complexity O(n^2)
        int nums[] = {2,4,1,3,5};
        // System.out.println(getInversionCount(nums));

        // Optimized soln for Inversion Count using merge sort
        // Time complexity is : O(n*logn)
        getInvCount(nums);
    }
}
