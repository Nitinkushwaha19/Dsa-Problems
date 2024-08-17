import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int arr[]) {
        List<List<Integer>> ans = new ArrayList<>();
        if (arr.length == 0 ) {
            return ans;
        }
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            // Skipped duplicate value for i
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int j = i + 1, k = arr.length - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if( sum == 0) {
                    ans.add(Arrays.asList(arr[i],arr[j],arr[k]));

                    // skip the duplicate for j
                    if(j<k && arr[j] == arr[j+1]) {
                        j++;
                    }

                    // skip the duplicate for k
                    if(j<k && arr[k] == arr[k-1]) {
                        k--;
                    }

                    j++;
                    k--;
                } 
                else if( sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr [] = {-1,0,1,2,0,-1,-4};
        System.out.println(threeSum(arr));
    }
}
