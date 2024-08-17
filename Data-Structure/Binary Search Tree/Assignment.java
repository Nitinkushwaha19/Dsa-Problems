import java.util.*;

public class Assignment {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static int sum = 0;

    public static int rangeSumBst(Node root, int low, int high) {
        if (root == null) {
            return 0;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (q.isEmpty() == false) {
            Node curr = q.peek();
            q.remove();

            if (curr.data >= low && curr.data <= high) {
                sum += curr.data;
            }

            if (curr.left != null && curr.data >= low) {
                q.add(curr.left);
            }

            if (curr.right != null && curr.data <= high) {
                q.add(curr.right);
            }
        }

        return sum;
    }

    public static int findClosest(Node root, int val) {
        Stack<Node> s = new Stack<>();
        int pred = Integer.MIN_VALUE;

        while (!s.isEmpty() || root != null) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }

            root = s.pop();

            if (pred <= val && root.data >= val) {
                return Math.abs(pred - val) <= Math.abs(root.data - val) ? pred : root.data;
            }

            pred = root.data;
            root = root.right;
        }
        return pred;
    }

    // Brute force
    public static void getInorder(Node root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }

        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }

    public static int findClosestII(Node root, int target) {
        ArrayList<Integer> arr = new ArrayList<>();
        // Inorder seq
        getInorder(root, arr);

        // Linear search
        int min = Integer.MAX_VALUE;
        int diff = 0;
        int closest = arr.get(0);
        for (int i = 0; i < arr.size(); i++) {
          diff  = Math.abs(arr.get(i) - target);
          if(diff < min) {
            closest = arr.get(i);
          }
          min = Math.min(min, diff);
        }
        return closest;
    }

    public static void main(String args[]) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right = new Node(11);
        root.right.right = new Node(20);

        // int l = 4, r = 7;
        // System.out.println(rangeSumBst(root, l, r));

        // System.out.println(findClosest(root, 1));
        System.out.println(findClosestII(root, 18));

    }
}
