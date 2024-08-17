public class BalancedBst {

    static class Node {
        int data;
        Node left;
        Node right;

        Node (int data ) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node balancedBst(int arr[], int si, int ei) {
        if(si > ei) {
            return null;
        }
        
        int mid = (si + ei)/2;
        Node root = new Node(arr[mid]);
        
        root.left = balancedBst(arr, si, mid-1);
        root.right = balancedBst(arr, mid+1, ei);

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
        int arr[] = {3,5,6,8,10,11,12};
        Node root = balancedBst(arr, 0, arr.length-1);
        preOrder(root);
    }
}
