import java.util.*;

public class Practise {
    public static int lcs(int[] arr1, int[] arr2){
        int n = arr1.length;
        
        int dp[][] = new int[n+1][n+1];
        
        for(int i = 1;i<n+1;i++) {
            for(int j = 1;j<n+1;j++){
                
                if(arr1[i-1] == arr2[j-1]) {
                    dp[i][j] = arr1[i-1] + dp[i-1][j-1];
                } else {
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    
                    dp[i][j] = Math.max(ans1,ans2);
                }
            }
        }
        for(int i = 0;i<n+1;i++){
            for(int j = 0;j<n+1;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        return dp[n][n];
    }
	public static int maxSumIS(int arr[], int n)  
	{  
	    //code here.
	   HashSet<Integer> set = new HashSet<>();
	   int arr2[] = arr;
	   for(int i = 0;i<n;i++) {
	       set.add(arr[i]);
	   }
	   
	   int i = 0;
	   for(int element : set){
	       arr2[i++] = element;
	   }
	   
	   Arrays.sort(arr2);
	   
	   return lcs(arr,arr2);
	}  

    public static void main(String[] args) {
        int arr[] = {1, 101, 2,3,100};

        System.out.println(maxSumIS(arr,arr.length));
    }
}