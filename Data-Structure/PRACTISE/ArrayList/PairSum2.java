import java.util.*;
public class PairSum2 {
    public static boolean searchPair(ArrayList<Integer> list, int target) {
        int bp = -1;
        int n = list.size();
        for(int i = 0;i<list.size();i++) {
            if(list.get(i) > list.get(i+1)){
                bp = i;
                break;
            }
        }

        int si = bp + 1;
        int ei = bp;

        while(si != ei) {
            // case 1 : found
            if(list.get(si) + list.get(ei) == target) {
               return true; 
            }

            // case 2 : small
            if(list.get(si) + list.get(ei) < target) {
                si = (si + 1) % n;
            } 
            // case 3 : higher
            else {
                ei = ((n + ei) - 1)% n;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int arr [] = {11,15,6,8,9,10};
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i<arr.length;i++) {
            list.add(arr[i]);
        }
        System.out.println(searchPair(list, 16));
    }
}
