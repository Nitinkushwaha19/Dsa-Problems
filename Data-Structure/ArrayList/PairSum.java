import java.util.ArrayList;

public class PairSum {

    public static boolean brutePairSum(ArrayList<Integer> list, int target) {
        // Brute force -- time complexity : O(n^2)
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if ((list.get(i) + list.get(j)) == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean pairSum(ArrayList<Integer> list, int target) {
        // two pointer approach -- time complexity : O(n)

        int lp = 0;
        int rp = list.size() - 1;

        while (lp < rp) {
            int sum = list.get(lp) + list.get(rp);

            // case 1 : target found
            if (sum == target) {
                return true;
            }

            // case 2 : sum is less than target
            if (sum < target) {
                lp++;
            } else {
                // case 3 : sum is greater than target
                rp--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Find if any pair in a sorted arraylist has a target sum.
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(pairSum(list, 5));
    }
}
