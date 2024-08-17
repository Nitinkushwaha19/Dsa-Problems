import java.util.*;

public class Bst2BalancedBst {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node createBST(ArrayList<Integer> arr, int si, int ei) {
        if (si > ei) {
            return null;
        }
        int mid = (si + ei) / 2;
        Node root = new Node(arr.get(mid));
        root.left = createBST(arr, si, mid - 1);
        root.right = createBST(arr, mid + 1, ei);

        return root;
    }

    public static void getInOrder(Node root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }
        getInOrder(root.left, arr);
        arr.add(root.data);
        getInOrder(root.right, arr);
    }

    public static Node balancedBst(Node root) {  // O(n)
        // sort BST : Inorder sequence   // O(n)
        ArrayList<Integer> arr = new ArrayList<>();
        getInOrder(root, arr);

        // Sorted inorder --> Balanced Bst  O(n)
        root = createBST(arr, 0, arr.size() - 1);
        return root;
    }

    
    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data+ " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        preOrder(root);
        System.out.println();
        root = balancedBst(root);
        preOrder(root);

    }
}
