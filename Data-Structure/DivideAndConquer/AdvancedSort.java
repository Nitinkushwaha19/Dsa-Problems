public class AdvancedSort {

    public static void mergeSort(int arr[], int si, int ei) {
        // base
        if (si >= ei) {
            return;
        }
        // Kaam
        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid); // for left part
        mergeSort(arr, mid + 1, ei); // for right part
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1]; // temporary array
        int i = si; // idx for 1st sorted part
        int j = mid + 1; // idx for 2nd sorted part
        int k = 0; // idx for temp array

        while (i <= mid && j <= ei) {
            // comparing and merge sorted array
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // for leftover element of 1st sorted array
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // for leftover element of 2nd sorted array
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // copy element to original array
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void quickSort(int arr[], int si, int ei) {
        // base case
        if (si >= ei) {
            return;
        }
        // kaam
        int pIdx = partition(arr, si, ei);
        quickSort(arr, si, pIdx - 1); // left part
        quickSort(arr, pIdx + 1, ei); // right part
    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1; // to make place for elements smaller than pivot

        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        // to set the place of pivot
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;

        return i;

    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int search(int arr[], int tar, int si, int ei) {
        // base case 
        if(si > ei) {
            return -1;
        }
        
        // kaam
        int mid = si + (ei - si)/2;

        // case Found 
        if(arr[mid] == tar) {
            return mid;
        }

        // Mid on L1
        if(arr[si] <= arr[mid]) {
            // case 1 : left on line l1 
            if(arr[si] <= tar && tar <= arr[mid]) {
                return search(arr, tar, si, mid-1);
            } else {
                // case 2 : right on line l1
                return search(arr, tar, mid+1, ei);
            }
        }
        // Mid on L2
        else {
            // case 3 : right on line l2
            if(arr[mid] <= tar && tar <= arr[ei]) {
                return search(arr, tar, mid+1, ei);
            } else {
                // case 4 : left on line l2
                return search(arr, tar, si, mid-1);
            }
        }
    }

    public static void main(String args[]) {
        // int arr[] = { 4, 6, 3, 1, 5, 8, 9 };
        // mergeSort(arr, 0, arr.length-1);
        // quickSort(arr, 0, arr.length - 1);
        // printArray(arr);

        int arr2 [] = {4,5,6,7,0,1,2};
        System.out.println(search(arr2, 2, 0, arr2.length-1));
    }
}