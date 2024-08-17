public class CircularQueueArray {
    int arr[];
    int size , front, rear;

    public CircularQueueArray(int n) {
        arr = new int[n];
        size = n;
        front = rear = -1;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    public void add (int data) {
        if(isFull()) {
            System.out.println("Queue is full");
            return;
        }

        if(front == -1) {
            front = 0;
        }
        rear = (rear+1) % size;
        arr[rear] = data;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public int remove() {
        if(isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }    

        int data = arr[front];

        if(rear == front) { // last element
            rear = front = -1;
        } else {
            front = (front+1) % size;
        }

        return data;
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        return arr[front];
    }
    public static void main(String[] args) {
        CircularQueueArray q = new CircularQueueArray(5);

        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println( q.remove());
       
        q.add(4);
        System.out.println( q.remove());
        q.add(5);

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}
