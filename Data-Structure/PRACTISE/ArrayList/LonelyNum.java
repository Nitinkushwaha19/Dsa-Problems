import java.util.*;

public class LonelyNum {
    public static ArrayList<Integer> lonelyNum(ArrayList<Integer> list) {
        Collections.sort(list);
        ArrayList<Integer> ans = new ArrayList<>();

        if (list.size() == 1) {
            ans.add(list.get(0));
        }

        if (list.size() > 1) {
            if (list.get(0) + 1 < list.get(1)) {
                ans.add(list.get(0));
            }
            if (list.get(list.size() - 2) + 1 < list.get(list.size() - 1)) {
                ans.add(list.get(list.size() - 1));
            }
        }

        for(int i = 1;i<list.size()-1;i++) {
            if (list.get(i - 1) + 1 < list.get(i) && list.get(i) + 1 < list.get(i + 1)) {
                ans.add(list.get(i));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {1,3,5,3};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        System.out.println(lonelyNum(list));
    }
}
