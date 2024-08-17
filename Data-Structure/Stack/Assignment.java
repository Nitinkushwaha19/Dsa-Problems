import java.util.*;

public class Assignment {

    public static class Node {
        char data;
        Node next;

        public Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    public static boolean isPalindrome(Node head) {
        Stack<Character> s = new Stack<>();
        Node temp = head;
        boolean ispalin = false;

        while (temp != null) {
            char ch = temp.data;
            s.push(ch);
            temp = temp.next;
        }

        temp = head;

        while (temp != null) {
            if (temp.data == s.pop()) {
                ispalin = true;
            } else {
                ispalin = false;
            }
            temp = temp.next;
        }

        return ispalin;
    }

    public static void main(String[] argg) {
        head = new Node('A');
        head.next = new Node('B');
        head.next.next = new Node('C');
        head.next.next.next = new Node('B');
        head.next.next.next.next = new Node('A');

        System.out.println(isPalindrome(head));
    }
}
