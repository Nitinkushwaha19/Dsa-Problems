import java.util.Stack;

public class NextGreaterElement {
    public static void nextGreaterElement(int arr[], int nextGreater[]) {
        Stack<Integer> s = new Stack<>();
        // last element don't have next greater element
        nextGreater[arr.length-1] = -1;
        s.push(arr.length-1);

        // traverse from backside
        for(int i = arr.length-2;i>=0;i--) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }    

            if(s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()];
            }

            // push the element onto the stack
            s.push(i);
        }
    }
    public static void main(String[] args) {
        int arr[] = {6,8,0,1,3};
        int nextGreater[] = new int[arr.length];  
        nextGreaterElement(arr, nextGreater);

        for(int i = 0;i<nextGreater.length;i++) {
            System.out.print(nextGreater[i] + " ");
        }  
        System.out.println();
    }
}
