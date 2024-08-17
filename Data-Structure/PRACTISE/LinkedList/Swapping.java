public class Swapping {
    public static class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void swapNode(Node head,int key1, int key2) {
        
        // search for 1st key
        Node curr1 = head;
        Node prev1 = null;
        Node next1 = null;

        while(curr1.data != key1){
            prev1 = curr1;
            next1 = curr1.next;
            curr1 = next1;
        }

        Node curr2 = head;
        Node prev2 = null;
        Node next2 = null;

        while(curr2.data != key1){
            prev2 = curr2;
            next2 = curr2.next;
            curr2 = next2;
        }
        
        // swapping of two linked list
        prev1.next = curr2;
        curr2.next = next1;
        prev2.next = curr1;
        curr1.next = next2;
    }

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        print(head);
        swapNode(head, 2, 4);
        print(head);
    }

}
