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
    public int size;

    // insertion
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node newNode = new Node(data);
        size++;
        temp.next = newNode;
        newNode = tail;
    }

    public void add(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
        }
        Node temp = head;
        for (int i = 0; i < idx - 1; i++) {
            temp = temp.next;
        }

        Node newNode = new Node(data);
        size++;
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // remove operation
    public int removeFirst() {
        if (head == null) {
            System.out.println("LinkedList is empty");
        }
        int data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public int removeLast() {
        Node temp = head;
        if (size == 1) {
            return removeFirst();
        }
        while (temp.next.next != null) {
            temp = temp.next;
        }
        int data = temp.data;
        temp.next = null;
        size--;
        return data;
    }

    // print linked list
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public void reverse() {
        Node curr = tail = head;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public int removeNthNode(int n) {
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            sz++;
            temp = temp.next;
            
        }
        
        Node prev = head;
        int i = 1;
        int iToFind = sz - n;
        while (i <iToFind) {
            prev = prev.next;
            i++;
        }
        int data = prev.next.data;
        prev.next = prev.next.next;
        return data;
    }

    public static boolean isPalindrome() {
        if(head == null || head.next == null) {
            return true;
        }
        
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            sz++;
            temp = temp.next;
        }

        int mid = sz/2;
        Node midNode = head;
        for(int i = 0;i<=mid;i++) {
            midNode = midNode.next;
        }
        
        Node curr = midNode;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;

        // check for palindrome
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
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(2);
        // ll.addLast(1);
        

        ll.print();
        System.out.println(isPalindrome());

    }
}