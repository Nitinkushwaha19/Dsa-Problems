import java.util.*;
public class SubarraySum {
    public static void main(String[] args) {
        int arr[] = {10,2,-2,-20,10};
        int k = -10;
        HashMap<Integer,Integer> map = new HashMap<>();
        // (sum , count)
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for(int i = 0;i<arr.length;i++){ // O(N)
            sum += arr[i];
            if(map.containsKey(sum - k)) {
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println(count);

  
      
    }
}
