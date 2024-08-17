import java.util.*;

public class MajorityElement {
    public static void majorityElement(int nums[]){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
           map.put(nums[i], map.getOrDefault(nums[i], 0) + 1); 
        }

        for (Integer key : map.keySet()) {
            if(map.get(key) > nums.length / 3) {
                System.out.println(key);
            }
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(map.get(nums[i]), 0) + 1);
        }

        int i = 0;
        int arr[] = new int[k];
        for (Integer key : map.keySet()) {
            if (k <= map.get(key) && i <= k) {
                arr[i++] = key;
            }
        }
        return arr;
    }
    
    public static void main(String[] args) {
        int nums[] = {1,1,1,2,2,3};
        // majorityElement(nums);   

        int arr[] = topKFrequent(nums, 2);

        for(int i  = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

        
    }
}
