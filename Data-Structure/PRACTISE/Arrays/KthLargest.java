import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargest {
    public static int findKthLargest(int nums[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0;i<nums.length;i++) {
            pq.add(nums[i]);
        }

        int kthlargest = pq.peek();
        
        for(int j = 0;j<k;j++) {
            kthlargest = pq.remove();
        }
        return kthlargest;
    }
    public static void main(String[] args) {
        int nums[] = {3,2,1,5,6,4};
        int k = 2;    
        System.out.println(findKthLargest(nums, k));    
    }
}