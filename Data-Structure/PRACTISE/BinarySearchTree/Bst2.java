import java.util.ArrayList;

public class Bst2 {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node balanceBst(int arr[], int si, int ei) {
        if (si > ei) {
            return null;
        }

        int mid = si + (ei - si) / 2;
        Node root = new Node(arr[mid]);
        root.left = balanceBst(arr, si, mid - 1);
        root.right = balanceBst(arr, mid + 1, ei);

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

    public static Node balanceTree(ArrayList<Integer> arr, int si, int ei) {
        if (si > ei) {
            return null;
        }

        int mid = si + (ei - si) / 2;
        Node root = new Node(arr.get(mid));
        root.left = balanceTree(arr, si, mid - 1);
        root.right = balanceTree(arr, mid + 1, ei);

        return root;
    }

    public static Node bstToBalanceBst(Node root) {
        // get inorder of tree
        ArrayList<Integer> arr = new ArrayList<>();
        getInOrder(root, arr);

        // sorted array to balance tree
        return balanceTree(arr, 0, arr.size()-1);
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        // int arr[] = { 1, 2, 3, 4, 5, 6 };
        // Node root = balanceBst(arr, 0, arr.length-1);

        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        preOrder(root);
        System.out.println();
        root = bstToBalanceBst(root);
        preOrder(root);
    }
}
