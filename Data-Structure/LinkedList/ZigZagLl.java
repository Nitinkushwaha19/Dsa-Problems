public class ZigZagLl {
    public class  Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public static Node head;
    
    public void addFirst(int data) {
        // step 1 = create a new node
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        // step 2 : newNode next = head
        newNode.next = head;
        // step 3 : head = newNode
        head = newNode;
    }

        
    public void printLl() {

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");

    }

    public void zigZag() {
        // find mid
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        
        // reverse 2nd half 
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node leftHead = head;
        Node rightHead = prev;
        Node nextL, nextR;
        
        // alternate merging : zig-zag merge
        while (leftHead != null && rightHead != null) {
            nextL = leftHead.next;
            leftHead.next = rightHead;
            nextR = rightHead.next;
            rightHead.next = nextL;

            leftHead = nextL;
            rightHead = nextR;
        }

    }

    public static void main(String[] args) {
        ZigZagLl ll = new ZigZagLl();
        ll.addFirst(6);
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);



        ll.printLl();
        ll.zigZag();
        ll.printLl();
        
    }
}
