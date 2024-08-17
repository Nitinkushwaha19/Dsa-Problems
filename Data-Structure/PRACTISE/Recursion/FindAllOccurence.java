public class FindAllOccurence {
    public static void findOccurence(int arr[], int key,int idx) {
        if(idx < 0) {
            return;
        }
        
        findOccurence(arr, key, idx-1);

        if(arr[idx] == key) {
            System.out.print(idx + " ");
        }

       
    }
    public static void main(String[] args) {
        int arr [] = {3,2,4,5,6,2,7,2,2};
        int key = 2;
        findOccurence(arr, key, arr.length-1);
    }
}
