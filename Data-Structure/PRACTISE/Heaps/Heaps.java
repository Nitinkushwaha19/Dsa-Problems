import java.util.*;

public class Heaps {
    ArrayList<Integer> arr = new ArrayList<>();

    public void add(int data) {
        // add element at last position
        arr.add(data);

        // fix the heap
        int x = arr.size() - 1; // child node index
        int par = (x - 1) / 2; // par index

        while (arr.get(x) < arr.get(par)) {
            int temp = arr.get(x);
            arr.set(x, arr.get(par));
            arr.set(par, temp);
        }
    }

    public int peek() {
        return arr.get(0);
    }

    public void heapify(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int minIdx = i;

        if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
            minIdx = left;
        }

        if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
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

        // swap values of 1st and last idx
        int temp = arr.get(0);
        arr.set(0, arr.get(arr.size() - 1));
        arr.set(arr.size()-1, temp);

        // remove the last element
        arr.remove(arr.size() - 1);

        // heapify
        heapify(0);

        return data;
    }

    public boolean isEmpty() {
        return arr.size() == 0;
    }

    public void print() {
       while (!isEmpty()) {
            System.out.println(peek());
            remove();
        }
    }


    
    public static void main(String[] args) {
        Heaps h = new Heaps();
        h.add(1);
        h.add(2);
        h.add(3);
        h.add(4);

        h.print();
    }
}