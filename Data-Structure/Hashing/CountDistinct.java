import java.util.*;
public class CountDistinct {
    public static void main(String[] args) {
        int arr[] = {4,3,2,5,6,7,4,2,1};
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<arr.length;i++) {
            set.add(arr[i]);
        }

        System.out.println(set.size());


        Arrays.sort(arr);
        int count = 1;
        for(int i = 1;i<arr.length;i++) {
            while(arr[i] == arr[i-1]) {
                i++;
            }
            count++;
        }
        System.out.println(count);
    }
}
