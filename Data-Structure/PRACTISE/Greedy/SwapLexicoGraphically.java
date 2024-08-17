public class SwapLexicoGraphically {
    public static void swaps(int start, int k, int arr[]) {
        if (k <= 0) {
            return;
        }

        int minIdx = 0;
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= start + k && i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIdx = i;
            }
        }

        while (k > 0 && minIdx > start) {
            int temp = arr[minIdx];
            arr[minIdx] = arr[minIdx - 1];
            arr[minIdx - 1] = temp;
            k--;
            minIdx--;
        }

        if (k > 0) {
            swaps(start + 1, k--, arr);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 7, 6, 9, 2, 1 };
        int k = 6;
        swaps(0, k, arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
