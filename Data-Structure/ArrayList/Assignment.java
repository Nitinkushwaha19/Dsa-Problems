import java.util.*;

public class Assignment {

    // Monotonic increasing and decreasing function
    public static boolean monotonic(ArrayList<Integer> list) {
        int incr = 0, decr = 0;
        // monotonic increasing
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) <= list.get(i + 1)) {
                incr++;
            }
            if (list.get(i) >= list.get(i + 1)) {
                decr++;
            }
        }

        if (incr == list.size() - 1 || decr == list.size() - 1) {
            return true;

        }
        return false;
    }

    // Find lonely number in Arraylist
    public static ArrayList<Integer> lonelyNumber(ArrayList<Integer> nums) {

        Collections.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i < nums.size() - 1; i++) {
            if (nums.get(i - 1) + 1 < nums.get(i) && nums.get(i) + 1 < nums.get(i + 1)) {
                list.add(nums.get(i));
            }
        }

        // corner cases :
        if (nums.size() == 1) {
            list.add(nums.get(0));
        }

        if (nums.size() > 1) {
            if (nums.get(0) + 1 < nums.get(1)) {
                list.add(nums.get(0));
            }
            if (nums.get(nums.size() - 2) + 1 < nums.get(nums.size() - 1)) {
                list.add(nums.get(nums.size() - 1));
            }
        }
        return list;
    }

    // Most Frequency Number following key
    public static int MostFrequentNumber(ArrayList<Integer> list, int key) {
        int[] result = new int[1000];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == key) {
                result[list.get(i + 1) - 1]++;
            }
        }

        int max = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] > max) {
                max = result[i];
                ans = i + 1;
            }
        }
        return ans;
    }

    // Beautiful Arraylist
    public static ArrayList<Integer> beautifuArrayList(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);

        while (ans.size() < n) {
            ArrayList<Integer> temp = new ArrayList<>();
            int ans_size = ans.size();

           
            // For odd array
            for (int i = 0; i < ans_size; i++) {
                if ((ans.get(i) * 2 - 1) <= n) {
                    temp.add(ans.get(i) * 2 - 1);
                }
            }

             // For even array
             for (int i = 0; i < ans_size; i++) {
                if (ans.get(i) * 2 <= n) {
                    temp.add(ans.get(i) * 2);
                }
            }

            ans = temp;
        }

        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(100);
        list.add(200);
        list.add(1);
        list.add(100);

        // System.out.println(monotonic(list));

        // lonely number is arraylist ---- :
        // System.out.println(lonelyNumber(list));

        // Most frequency following key ---- :
        // System.out.println(MostFrequentNumber(list,1));

        // Beautiful ArrayList 
        beautifuArrayList(5);
        
    }
}
