public class Bst {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data < val) {
            root.right = insert(root.right, val);
        } else {
            root.left = insert(root.left, val);
        }

        return root;
    }

    public static boolean search(Node root, int val) {
        if (root == null) {
            return false;
        }

        if (root.data == val) {
            return true;
        }

        if (root.data < val) {
            return search(root.right, val);
        } else {
            return search(root.left, val);
        }

    }

    public static Node delete(Node root, int val) {
        if (root.data < val) {
            root.right = delete(root.right, val);
        } else if (root.data > val) {
            root.left = delete(root.left, val);
        } else { // case found

            // case 1: leaf Node
            if (root.left == null && root.right == null) {
                return null;
            }

            // case 2 : single child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // case 3 : Both child
            Node IS = findInOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node findInOrderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }

        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data < k1) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }

    public static boolean isValidBst(Node root,Node min, Node max) {
        if(root == null) {
            return true;
        }

        if(min != null && root.data <= min.data) {
            return false;
        }

        if(max != null && root.data >= max.data ) {
            return false;
        }

        return isValidBst(root.left, min, root) && isValidBst(root.right, root, max);
    }

    public static Node mirrorBst(Node root) {
        if(root == null) {
            return null;
        }

        Node left = mirrorBst(root.left);
        Node right = mirrorBst(root.right);
        root.right = left;
        root.left = right;

        return root;
    }
    
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String args[]) {
        int arr[] = { 8, 5, 3, 6, 10, 11, 14 };
        Node root = null;
        for (int i = 0; i < arr.length; i++) {
            root = insert(root, arr[i]);
        }       
    }
}