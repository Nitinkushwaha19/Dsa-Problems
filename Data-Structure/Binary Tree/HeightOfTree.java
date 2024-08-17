public class HeightOfTree {
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

    public static int heightOfTree(Node root) {
        if(root == null) {
            return 0;
        }

        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        int height = Math.max(leftHeight, rightHeight) + 1;
        
        return height;
    }

    public static int count(Node root) {
        if(root == null) {
            return 0;
        }

        int leftCount = count(root.left);
        int rightCount = count(root.right);

        int treeCount = leftCount + rightCount + 1;
        
        return treeCount;
    }

  
    public static int sumOfNode(Node root) {
        if(root == null) {
            return 0;
        }

        int leftSum = sumOfNode(root.left);
        int rightSum = sumOfNode(root.right);

        return leftSum + rightSum + root.data;

    }
    public static void main(String [] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(6);


        // Calculate height of tree ------ O(n)
        System.out.println(heightOfTree(root));

        // Count  the nodes of tree
        System.out.println(count(root));

        // Sum of nodes of tree
        System.out.println(sumOfNode(root));
    }
}
