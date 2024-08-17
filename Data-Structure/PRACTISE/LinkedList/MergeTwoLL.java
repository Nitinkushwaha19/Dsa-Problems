public class MergeTwoLL {
    public static class Node {
        int val;
        Node next;
        
        public Node () {};
        public Node(int val) { this.val = val; }
        
    }
    public static Node mergeTwoLists(Node list1, Node list2) {
        Node head = new Node();
        Node curr = head;
 
        while (list1 != null && list2 != null) {
             if(list1.val < list2.val){
                 curr.next = list1;
                 list1 = list1.next;
             } else {
                 curr.next = list2;
                 list2 = list2.next;
             }
             curr = curr.next;
        }
        curr.next = (list1 != null) ? list1 : list2;
        return head.next;
    }

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }
    public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.next = new Node(2);
        list1.next.next = new Node(4);

        Node list2 = new Node(1);
        list2.next = new Node(3);
        list2.next.next = new Node(4);
        
        Node head = mergeTwoLists(list1, list2);
        print(head);
    }
}
