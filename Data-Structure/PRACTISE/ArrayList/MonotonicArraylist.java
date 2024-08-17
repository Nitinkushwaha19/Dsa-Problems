import java.util.ArrayList;

public class MonotonicArraylist {
    public static boolean isMonotonic (ArrayList<Integer>list) {
        boolean inc = true;
        boolean dec = true;

        for(int i=0;i<list.size()-1;i++) {
            if(list.get(i) > list.get(i+1)) {
                inc = false;
            } 

            if(list.get(i) < list.get(i+1)) {
                dec = false;
            }
        }
        return inc || dec;
    }
    public static void main(String[] args) {
        int nums [] = {1,3,2};
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i<nums.length;i++) {
            list.add(nums[i]);
        }
        System.out.println(isMonotonic(list));

    }
}