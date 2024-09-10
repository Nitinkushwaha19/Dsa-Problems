public class CountNumberOfNiceSubarrays {
    class Solution {

        public static int helper(int[] nums, int k){
            if(k < 0) return 0;
    
            int r = 0, l = 0, count = 0, total = 0;
            while(r < nums.length){
                
                if(nums[r] % 2 != 0){
                    count++;
                }
    
                while(count > k){
                    if(nums[l] % 2 != 0){
                        count--;
                    }
                    l++;
                }
    
                total += r-l+1;
                r++;
            }
            return total;
        }
    
        public int numberOfSubarrays(int[] nums, int k) {
    
            return helper(nums,k) - helper(nums,k-1);
        }
    }
}
