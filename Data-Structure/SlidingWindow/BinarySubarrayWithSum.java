public class BinarySubarrayWithSum {
    class Solution {

        public static int helper(int[] nums, int goal){
            
            if(goal < 0) return 0;
    
            int count = 0, sum = 0, r = 0, l = 0;
            while(r < nums.length){
                sum += nums[r];
    
                while(sum > goal){
                    sum -= nums[l];
                    l++;
                }
    
                count += r-l+1;
                r++;
            }
    
            return count;
        }
        public int numSubarraysWithSum(int[] nums, int goal) {
            return helper(nums,goal) - helper(nums,goal-1);
        }
    }
}
