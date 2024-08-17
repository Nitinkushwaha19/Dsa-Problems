public class QueueLL {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next  = null;
        }
    }

    public static class Queue {
        static Node head = null;
        static Node tail = null;
        
        public static boolean isEmpty () {
            return head == null && tail == null;
        }

        public static void add(int data) {
            Node newNode = new Node(data);
            
            if(isEmpty()) {
                head = tail = newNode;
                return;
            }

            tail.next = newNode;
            tail = newNode;
        }

        public static int remove () {
            if (isEmpty()) {
                System.out.println("Queue is empty!");
                return -1;
            }
            if(head == tail) {
                int val = head.data;
                head = tail = null;
                return val;
            }
            int val = head.data;
            head = head.next;
            return val;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty!");
                return -1;
            }

            return head.data;
        }
        
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);


        q.remove();
        
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
