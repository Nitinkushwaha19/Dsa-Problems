public class CircularQueue {
    public static class Queue {
        static int[] arr;
        static int size;
        static int rear;
        static int front;

        public Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public  boolean isEmpty() {
            if (rear == -1 && front == -1) {
                return true;
            }
            return false;
        }

        public  boolean isFull() {
            return (rear + 1) % size == front;
        }

        public void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full!");
                return;
            }
            // adding 1st element
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public  int remove() {
            if (isEmpty()) {
                System.out.println("Queue is Empty!");
                return -1;
            }
            
            int result = arr[front];

            // removing last element
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }

            return result;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty!");
                return -1;
            }
            return arr[front];
        }

    }

    public static void main(String[] args) {
        Queue c = new Queue(3);
        c.add(1);
        c.add(2);
        c.add(3);

        System.out.println(c.remove());
        c.add(4);
        System.out.println(c.remove());
        c.add(5);

        while (!c.isEmpty()) {
            System.out.println(c.peek());
            c.remove();
        }
    }
}
