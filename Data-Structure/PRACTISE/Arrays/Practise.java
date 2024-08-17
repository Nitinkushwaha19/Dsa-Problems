import java.util.*;

public class Practise {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int arr[] = new int[n];
      int even[] = new int[n];
      int odd[] = new int[n];

      //input
      for(int i=0; i<n; i++) {
        arr[i] = sc.nextInt();
      }

      sc.close();
      
      
      for(int i=0, j = 0, k=0; i<n-1; i++) {
        if(arr[i] % 2 != 0) {
          odd[j++] = arr[i];
        }else {
          even[k++] = arr[i];
        }
      }
      
      
      
      
      //output of odd Number
      System.out.print(odd[0]);
      for(int i=1; i<odd.length; i++) {
        if(odd[i] != 0) {
          System.out.print("," + odd[i]);
        }
      }
      System.out.println();
      

      //output of even Number
      System.out.print(even[0]);
      for(int i=1; i<odd.length; i++) {
        if(even[i] != 0) {
          System.out.print("," + even[i]);
        }
      }
      System.out.println();
    }
}