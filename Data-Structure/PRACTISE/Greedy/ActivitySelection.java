import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    public static int activitySelection(int start[], int end[], int n)
    {
        // add your code here
        int activites [][] = new int [n][3];
        for(int i = 0;i<n;i++) {
            activites[i][0] = i;
            activites[i][1] = start[i];
            activites[i][2] = end[i];
        }
        
        // Lambada function 
        Arrays.sort(activites, Comparator.comparingDouble(O -> O[2]));
        
        int count = 1;
        int lastend = activites[0][2];
        for(int i = 1;i<n;i++) {
            if(activites[i][1] >= lastend) {
                count++;
                lastend = activites[i][2];
            }
        }
        
        return count;
    }
    public static void main(String[] args) {
        int start [] = {1,3,2,5};
        int end [] = {2,4,3,6};
        int activities = activitySelection(start, end, end.length);
        System.out.println(activities);
    }
}