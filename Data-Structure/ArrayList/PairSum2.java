import java.util.ArrayList;

public class PairSum2 {
    public static boolean pairSum(ArrayList<Integer> list, int target) {
        int bp = -1, n = list.size();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > list.get(i + 1)) {
                bp = i;
                break;
            }
        }

        int rp = bp;
        int lp = bp + 1;

        while (lp != rp) {
            int sum = list.get(lp) + list.get(rp);

            // case 1
            if (sum == target) {
                return true;
            }

            // case 2
            // With mathematical formula
            
            if (sum < target) {
                lp = (lp + 1) % n;
            } else {
                // case 3
                rp = (n + rp - 1) % n;
            }

            // Without mathematical formula

            // if (sum < target) {
            // lp++;
            // } else {
            // rp--;
            // }

            // if (lp < 0) {
            // lp = list.size() - 1;
            // } else if (lp > list.size() - 1) {
            // lp = 0;
            // }

            // if (rp < 0) {
            // rp = list.size() - 1;
            // } else if (rp > list.size() - 1) {
            // rp = 0;
            // }

        }

        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // 11,15,6,8,9,10 -- sorted and rotated arraylist
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        int target = 16;
        System.out.println(pairSum(list, target));
    }
}
