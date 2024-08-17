import java.util.Stack;
public class NextGreaterElement {

    public static void findNextGreater(int[] arr, int[] nxtGreater) {  // O(n)
        Stack<Integer> s = new Stack<>();
        nxtGreater[arr.length-1] = -1;
        s.push(arr.length-1);

        for(int i = arr.length-2;i>=0;i--) {
            int curr = arr[i];
            while (!s.isEmpty() && curr > arr[s.peek()]) {
                s.pop();
            }

            if(s.isEmpty()) {
                nxtGreater[i] = -1;
            } else {
                nxtGreater[i] = arr[s.peek()];
            }

            s.push(i);
        }
    }
    public static void main(String[] args) {
        int[] arr = {6,8,0,1,3};
        int[] nxtGreater = new int[arr.length];

        findNextGreater(arr,nxtGreater);

        for(int i=0;i<nxtGreater.length;i++) {
            System.out.print(nxtGreater[i] + " ");
        }
    }
}
