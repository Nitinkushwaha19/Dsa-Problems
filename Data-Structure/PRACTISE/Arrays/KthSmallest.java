import java.util.PriorityQueue;

public class KthSmallest {
     public static int kthSmallest(int[] arr,int k) 
    { 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0;i<arr.length;i++) {
            pq.add(arr[i]);
        }
        
        int kthSmallest = pq.peek();
        
        for(int i = 0;i<k;i++) {
            kthSmallest = pq.remove();
        }
        return  kthSmallest;
    } 

    public static void main(String[] args) {
        int arr[] = {7,10,4,3,20,15};
        int k = 3;
        System.out.println(kthSmallest(arr,k));
    }
}
