public class findPairRotatedSorted {
    public static boolean search(int arr[], int si, int ei, int target) {
        if (si > ei) {
            return false;
        }

        int mid = si + (ei - si) / 2;
        if(arr[mid] == target) {
            return true;
        }

        if (arr[si] <= arr[mid]) {
            // case 1 :
            if (arr[si] <= target && target < arr[mid]) {
                return search(arr, si, mid - 1, target);
            } else {
                return search(arr, mid + 1, ei, target);
            }
        } else {
            // case 3 :
            if (arr[mid] < target && target <= arr[ei]) {
                return search(arr, mid + 1, ei, target);
            } else {
                return search(arr, si, mid - 1, target);
            }
        }
    }

    // time complexity : O( n * logn) ---> very bad
    public static boolean findPair(int arr[], int x) {
        for(int i = 0;i<arr.length;i++) {
            int target = x - arr[i];
            if(search(arr, i+1, arr.length-1, target)) {
                return true;
            } 
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 11, 15, 26, 38, 9, 10 };
        int x = 16;
        
        System.out.println(findPair(arr, x));
    }
}
