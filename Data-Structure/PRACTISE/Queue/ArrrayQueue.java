public class ArrrayQueue {
    int arr[];
    int size, rear;

    public ArrrayQueue(int n) {
        arr = new int[n];
        size = n;
        rear = -1;
    }

    public boolean isFull() { // O(1)
        return rear == size -1;
    }

    public void add(int data) { // O(1)
        if( isFull()) {
            System.out.println("Queue is full");
            return;
        }

        rear = rear + 1;
        arr[rear] = data;
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public int remove() {
        if(isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }    

        int data = arr[0];
        for(int i = 0;i<arr.length-1;i++) {
            arr[i] = arr[i+1];
        }
        rear = rear -1;
        return data;
    }
    public static void main(String[] args) {
        ArrrayQueue q = new ArrrayQueue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while(!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}