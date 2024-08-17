import java.util.ArrayList;

public class ClassRoom {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void kthLevel(Node root, int level, int k) {
        if (root == null) {
            return;
        }

        if (level == k) {
            System.out.print(root.data + " ");
        }

        kthLevel(root.left, level + 1, k);
        kthLevel(root.right, level + 1, k);
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }

        path.add(root);

        if (root.data == n) {
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if (foundLeft || foundRight) {
            return true;
        }

        path.remove(path.size() - 1);

        return false;
    }

    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        // last common ancestor
        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        // last equal node --> i-1;
        Node lca = path1.get(i - 1);
        return lca;
    }

    // lowest common ancestor approach 2 --> time comp : O(n) , space comp : O(1);
    public static Node lcaNode(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLca = lcaNode(root.left, n1, n2);
        Node rightLca = lcaNode(root.right, n1, n2);

        // leftLca = val , rightLca == null
        if (rightLca == null) {
            return leftLca;
        }
        // rightLca = val , leftLca = null
        if (leftLca == null) {
            return rightLca;
        }

        return root;
    }

    public static int lcaDist(Node root, int n) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        } else if (leftDist == -1) {
            return rightDist + 1;
        } else {
            return leftDist + 1;
        }
    }

    public static int minDist(Node root, int n1, int n2) {
        if (root == null) {
            return -1;
        }

        Node lca = lcaNode(root, n1, n2);
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);

        return dist1 + dist2;
    }

    public static int kAncestor(Node root, int n, int k) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }

        int leftDist = kAncestor(root.left, n, k);
        int rightDist = kAncestor(root.right, n, k);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }

        int max = Math.max(leftDist, rightDist);

        if (max + 1 == k) {
            System.out.println(root.data);
        }

        return max + 1;
    }

    public static int sumTree(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSum = sumTree(root.left);
        int rightSum = sumTree(root.right);
        int data = root.data;

        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;

        root.data = newLeft + leftSum + newRight + rightSum;

        return data;

    }

    public static void print(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        print(root.left);
        print(root.right);
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // kth level
        // kthLevel(root, 0, 2);

        // Lowest common ancestor
        int n1 = 4, n2 = 5;
        // System.out.println(lca(root, n1, n2).data);
        // System.out.println(lcaNode(root, n1, n2).data);

        // Min Distance betn 2 Nodes
        // System.out.println(minDist(root, n1, n2));

        // K-Ancestor of given node
        // int n = 5, k = 2;
        // kAncestor(root, n, k);

        // Sum Tree
        print(root);
        System.out.println();
        sumTree(root);
        print(root);
    }
}
