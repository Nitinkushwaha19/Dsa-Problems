public class MergeSortLl {
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

    public Node getMid(Node head) {
        Node slow = head;
        Node  fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public Node merge(Node leftHead, Node rightHead) {
        Node mergedLl = new Node(-1);
        Node temp = mergedLl;

        while (leftHead != null && rightHead != null) {
            if(leftHead.data <= rightHead.data) {
                temp.next = leftHead;
                leftHead = leftHead.next;
                temp = temp.next;
            } else {
                temp.next = rightHead;
                rightHead = rightHead.next;
                temp = temp.next;
            }
        }
        
        // leftover part of left half
        while (leftHead != null) {
            temp.next = leftHead;
            leftHead = leftHead.next;
            temp = temp.next;
        }
        // leftOver part of right half
        while (rightHead != null) {
            temp.next = rightHead;
            rightHead = rightHead.next;
            temp = temp.next;
        }

        return mergedLl.next;
    }

    public  Node mergeSort(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        // find the mid node
        Node mid = getMid(head);
        // left and right Ms
        Node rightNode = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightNode);

        // merge
        return merge(newLeft,newRight);
    }
    public static void main(String[] args) {
        MergeSortLl ll = new MergeSortLl();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);

        ll.printLl();
        head = ll.mergeSort(head);
        ll.printLl();
    }
    
}
