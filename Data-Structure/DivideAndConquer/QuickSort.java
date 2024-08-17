public class QuickSort {

    public static void swap(int nums[], int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static int partition(int nums[], int si, int ei) {
        int random = (int) Math.random() * (ei - si) + si;
        swap(nums, ei, random);

        int pivot = nums[ei];
        int j = si;

        for (int i = si; i <= ei; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, j);
                j++;
            }
        }
        return j - 1;
    }

    public static void quickSort(int nums[], int si, int ei) {
        // base
        if (si >= ei) {
            return;
        }

        // Kaam
        int pivot = partition(nums, si, ei);
        quickSort(nums, si, pivot - 1);
        quickSort(nums, pivot + 1, ei);
    }

    public static void main(String args[]) {
        int arr[] = { 4, 7, 5, 2, 1, 3 };
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
