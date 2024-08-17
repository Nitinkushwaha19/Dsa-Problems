public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // methods
    public void addFirst(int data) {
        // step 1 = create a new node
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        // step 2 : newNode next = head
        newNode.next = head;
        // step 3 : head = newNode
        head = newNode;
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void printLl() {

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");

    }

    public void add(int idx, int data) {

        if (idx == 0) {
            addFirst(data);
            return;
        }

        Node temp = head;
        int i = 0;

        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public int removeFirst() {
        if (head == null) {
            System.out.println("ll is empty!");
            return Integer.MIN_VALUE;
        } else if (head.next == null) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 1) {
            removeFirst();
        }

        Node temp = head;
        for (int i = 0; i < size - 2; i++) {
            temp = temp.next;
        }
        int val = temp.next.data;
        tail = temp;
        temp.next = null;
        size--;
        return val;
    }

    public int iteSearch(int key) {
        int i = 0;
        Node temp = head;
        while (temp != null) {
            if (key == temp.data) { // found case
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int helper(Node head, int key) { // time complexity : O(n) , space complexity : O(n)
        // base
        if (head == null) {
            return -1;
        }
        // recursive work
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public int recSearch(int key) {
        return helper(head, key);
    }

    // reverse linked list
    public void reverseLl() { // O(n)

        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // recursive function to revese linkid list
    public Node recReverse(Node head) {

        // base condition
        if(head == null || head.next == null) {
            return head;
        }
        
        // by recursion accessing new position for head
        Node newHead = recReverse(head.next);

        // change pointers for current node 
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public void deleteNthNodeFromEnd(int n) {
        Node temp = head;
        int sz = 0;

        // calculate size
        while(temp != null) {
            temp = temp.next;
            sz++;
        }
        // if ll is empty
        if(sz == 0) {
            System.out.println("ll is empty");
            return;
        }

        // if nth node is head
        if(n == sz) {
            head = head.next;
            return;
        }

        // for other cases :
        Node prev = head;
        for (int i = 1; i < size - n; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
    }

    // isPalindrome 
    public Node findMid(Node head){
        Node slow = head;
        Node fast  = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }
        return slow;
    }

    public boolean isPalindrome() {
        // special case 
        if(head == null || head.next == null) {
            return true;
        }

        // find middle node
        Node mid = findMid(head);

        // Reverse 2nd half of linked list
        Node prev = null;
        Node curr = mid;
        Node next;
        while (curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;

        // check if palindrome 
        while (right != null) {
            if(left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }



    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(1);

        // ll.add(2, 3);
        ll.printLl();

        // System.out.println(ll.removeFirst());
        // ll.printLl();

        // System.out.println(ll.removeLast());
        // ll.printLl();

        // System.out.println(ll.recSearch(14));
        // ll.reverseLl();

        // ll.deleteNthNodeFromEnd(5);
        // ll.printLl();

        System.out.println(ll.isPalindrome());

    }
}