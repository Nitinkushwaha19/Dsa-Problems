public class DeleteLl {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    public int removeNode(int m, int n) {
        int pos = (m + n) - 1;
        Node temp = head;
        for (int i = 1; i < pos; i++) {
            temp = temp.next;
        }
        int val = temp.next.data;
        temp.next = temp.next.next;
        return val;
    }

    public void swapNodes(int x, int y) {
        Node Node1, Node2, prevNode1 = head, prevNode2 = head, nextNode2;

        for (int i = 1; i < x - 1; i++) {
            prevNode1 = prevNode1.next;
        }
        for (int i = 1; i < y - 1; i++) {
            prevNode2 = prevNode2.next;
        }

        Node1 = prevNode1.next;
        Node2 = prevNode2.next;
        nextNode2 = Node2.next;

        // swapping
        prevNode1.next = Node2;
        Node2.next = Node1.next;
        Node1.next = nextNode2;
        prevNode2.next = Node1;
    }

    public void segEvenAndOdd() {
        Node end = head;
        while (end.next != null) {
            end = end.next;
        }
        Node newEnd = end;
        Node prev = null;
        Node curr = head;
        Node next = curr.next;

        while (curr != end) {
            if(prev == null) {
                newEnd.next = curr;
                curr.next = null;

                 // change the pointer
                 prev = curr;
                 curr = next;
                 next = curr.next;

            }
            if (curr.data % 2 != 0) {
                newEnd.next = curr;
                prev.next = next;
                curr.next = null;

                // change the pointer
                prev = curr;
                curr = next;
                next = curr.next;
            }
        }
    }

    public void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DeleteLl ll = new DeleteLl();

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        // head.next.next.next.next = new Node(5);

        ll.printLL();
        // System.out.println(ll.removeNode(2, 2));
        // ll.printLL();

        ll.swapNodes(2, 4);
        ll.printLL();
    }

}
