public class FindIntersection {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    public Node findIntersection(Node head1, Node head2) {
        while (head2 != null) {
            Node temp = head1;
            while (temp != null) {
                if (temp == head2) {
                    return temp;
                }
                temp = temp.next;
            }
            head2 = head2.next;
            temp = head1;
        }
        return null;
    }

    public void printLl(Node head) {

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");

    }

    public static void main(String[] args) {
       FindIntersection ll = new FindIntersection();

       Node head1 = new Node(4);
       Node head2 = new Node(1);

       head2.next = new Node(2);
       head2.next.next = new Node(3);
       head2.next.next.next = new Node(6);
       head2.next.next.next.next = new Node(7);

       head1.next = new Node(5);
       head1.next.next = head2.next.next.next;

        ll.printLl(head2);
        ll.printLl(head1);

        if(ll.findIntersection(head1,head2) == null) {
            System.out.println("No Intersection exists");
        } else {
            System.out.println("Intersection exists at node " + ll.findIntersection(head1, head2).data);
        }

    }
}
