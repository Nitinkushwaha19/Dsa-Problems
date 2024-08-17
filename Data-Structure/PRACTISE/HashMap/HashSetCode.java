import java.util.*;
public class HashSetCode {
    public static int countDistinct(int nums[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            set.add(nums[i]);
        }

       
        return set.size();
    }
    public static void main(String[] args) {
        int nums[] = {4,3,2,5,6,7,3,4,2,1};
        System.out.println( countDistinct(nums));
    }
}
