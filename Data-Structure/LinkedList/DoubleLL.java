public class DoubleLL {

    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static Node prev;
    public static int size;


    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }


    public int removeFirst() {
        if(head == null) {
            System.out.println("Linked list is empty!");
            return Integer.MIN_VALUE;
        }

        if(size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    public void addLast(int val) {
        Node newNode = new Node(val);
        Node temp = head;
        size++;

        if(head == null) {
            head = tail = newNode;
            return;
        }
        
       while (temp.next != null) {
            temp = temp.next;
       }
       temp.next = newNode;
       newNode.prev = temp;

    }

     public int removeLast() {
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        int val = temp.next.data;
        temp.next.prev = null;
        tail = temp;
        temp.next = null;
        size--;
        return val;
     }

     public void reverse() {
        Node curr = head;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
     }

    public void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }


    
    public static void main(String[] args){
        DoubleLL dll = new DoubleLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);

        dll.printLL();

        // dll.removeFirst();
        // dll.addLast(4);
        // dll.printLL();
        // System.out.println(dll.removeLast());
        // dll.printLL();
        // System.out.println(size);

        // reverse doubly linked list
        dll.reverse();
        dll.printLL();
    }
}
