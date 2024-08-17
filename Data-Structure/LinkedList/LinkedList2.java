public class LinkedList2 {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    public boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public void removeCycle() {
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        Node prev = null;
        
        
        
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            
            if(fast == slow) {
                cycle = true;
                break;
            }
        }
        
        if(cycle == false) {
            return;
        } 
        
        if(slow == head && fast == head) {
            prev.next = null;
            return;
        } 
        
        slow = head;
        
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
    }

    public static void main(String[] args) {
        LinkedList2 ll = new LinkedList2();
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;

        System.out.println(ll.isCycle());
        ll.removeCycle();
        System.out.println(ll.isCycle());
    }
}
