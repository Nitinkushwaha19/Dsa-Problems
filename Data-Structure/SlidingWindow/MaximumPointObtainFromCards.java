public class MaximumPointObtainFromCards {
    class Solution {
        public int maxScore(int[] arr, int k) {
            
            int totalSum = 0;
            for(int n : arr){
                totalSum += n;
            }
    
            int len = arr.length - k;
            int currSum = 0;
            int r = 0, l = 0;
            int res = 0;
    
            while(r < len){
                currSum += arr[r];
                r++;
            }
    
            res = totalSum - currSum;
    
            while(r < arr.length) {
    
                currSum -= arr[l];
                l++;
    
                currSum += arr[r];
                r++;
    
                res = Math.max(res, totalSum - currSum);
            }
    
            return res;
        }
    }
}
