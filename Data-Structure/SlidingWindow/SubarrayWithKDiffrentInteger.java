import java.util.*;
public class SubarrayWithKDiffrentInteger {
    class Solution {

        public static int helper(int[] nums, int k) {
            
            if( k <= 0 ) return 0;
    
            HashMap<Integer, Integer> map = new HashMap<>();
            int l = 0, r = 0, count = 0;
    
            while (r < nums.length) {
                map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
    
                while(map.size() > k){
                    map.put(nums[l], map.get(nums[l])-1);
                    
                    if(map.get(nums[l]) == 0){
                        map.remove(nums[l]);
                    }
                    
                    l++;
                }
    
                count += r-l+1;
                r++;
            }
    
            return count;
        }
    
        public int subarraysWithKDistinct(int[] nums, int k) {
            return helper(nums,k) - helper(nums,k-1);
        }
    }
}
