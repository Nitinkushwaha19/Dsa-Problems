import java.util.*;

public class ClassRoom {
    static class Heap {  // Min Heap
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) { // O(1)
            // add element at the last idx of arraylist
            arr.add(data);

            int x = arr.size() - 1; // child idx
            int par = (x - 1) / 2; // par idx

            while (arr.get(x) < arr.get(par)) { // O(logn)   // for max heap change to less than to greater than
                // swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x-1)/2;
            }
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }

        public int peek() {
            return arr.get(0);
        }

        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;

            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {  // for max heap change to less than to greater than in second comparison
                minIdx = left;
            }

            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {  // for max heap change to less than to greater than in second comparison
                minIdx = right;
            }

            if (minIdx != i) {
                // swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        public int remove() {
            int data = arr.get(0);

            // step 1 : swap first and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // step 2 : delete last
            arr.remove(arr.size() - 1);

            // step 3 : Heapify
            heapify(0);
            return data;
        }

    }

    public static void main(String[] args) {
        Heap pq = new Heap();
        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(5);

        while (!pq.isEmpty()) {
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}
