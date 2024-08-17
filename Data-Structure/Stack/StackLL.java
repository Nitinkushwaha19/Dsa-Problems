public class StackLL {

    public static class Node {
        int data;
        Node next;

        public  Node (int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        static Node head;

        public boolean isEmpty() {
            return head == null;
        }

        public void push(int data) {
            Node newNode = new Node(data);

            if(isEmpty()) {
                head = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;
        }

        public int pop() {
            
            if (isEmpty()) {
                return -1;
            }

            int top = head.data;
            head = head.next;
            return top;
        }
        
        public int peek() {
            if(isEmpty()) {
                return -1;
            }
            return head.data;
        }

        public void printStack() {

            if(isEmpty()) {
                System.out.println("Stack is empty");
            }
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        s.printStack();
        s.pop();
        System.out.println("-------");
        s.printStack();
        System.out.println(s.peek());

    }
}
