public class Assignment {

    public static int balancePartition(String str) {
        if (str.length() == 0) {
            return 0;
        }

        int l = 0, r = 0, ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'R') {
                r++;
            } else if (str.charAt(i) == 'L') {
                l++;
            }

            if (l == r) {
                ans++;
            }
        }

        return ans;
    }

    public static int kthLargestOddNum(int l, int r, int k) {
        if (k > r) {
            return 0;
        }

        int max = 0, ans = 0;
        for (int i = r; i >= l; i--) {
            if (i % 2 != 0) {
                max++;
            }
            if (max == k) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static int kthOdd(int[] range, int K) {
        if (K <= 0)
            return 0;
        int L = range[0];
        int R = range[1];
        if ((R & 1) > 0) {
            int Count = (int) Math.ceil((R - L + 1) / 2);
            if (K > Count)
                return 0;
            else
                return (R - 2 * K + 2);
        } else {
            int Count = (R - L + 1) / 2;
            if (K > Count)
                return 0;
            else
                return (R - 2 * K + 1);
        }
    }

    public static String smallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();

        int total_chars = n;
        int csum = k;

        while (total_chars > 0) {
            // if its fill by character 'a'
            if ((total_chars - 1) * 26 >= csum - 1) {
                sb.append('a');
                csum--;
            } else {
                int pos = csum % 26;
                if (pos == 0) {
                    sb.append('z');
                    csum -= 26;
                } else {
                    sb.append((char) (pos - 1 + 'a'));
                    csum -= pos;
                }
            }
            total_chars--;
        }
        return sb.toString();
    }

    public static int buyAndSellStock(int arr[]) {
        int min = arr[0];
        int profit = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else {
                profit = Math.max(profit, arr[i] - min);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        // String str = "LRRRRLLRLLRL";
        // System.out.println(balancePartition(str));

        // System.out.println(kthLargestOddNum(-10, 10, 8));

        // int range[] = { -10, 10 };
        // int k = 8;
        // System.out.println(kthOdd(range, k));

        // smallest lexical string
        // System.out.println(smallestString(3, 25));

        // Buy and sell stock
        int arr[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println(buyAndSellStock(arr));
    }

}
