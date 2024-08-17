import java.util.ArrayList;

public class MergeBst {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node (int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void getInorder(Node root, ArrayList<Integer> arr) {
        if(root == null) {
            return;
        }

        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }
    

    public static Node createBst(ArrayList<Integer> arr, int si, int ei) {
        if(si > ei) {
            return null;
        }

        int mid = (si + ei)/2;
        Node root = new Node(arr.get(mid));
        root.left = createBst(arr, si, mid-1);
        root.right = createBst(arr, mid+1, ei);

        return root;
    }
    
    public static Node mergeBst(Node root1, Node root2) {  // Time complexity : O(n+m) ---> O(n)
        // step 1 :-
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);

        // step 2 :-
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        // merge step
        ArrayList<Integer> finalArr = new ArrayList<>();
        int i = 0, j=0;
        while (i<arr1.size() && j<arr2.size()) {
            if (arr1.get(i) < arr2.get(j)) {
                finalArr.add(arr1.get(i));
                i++;
            } else {
                finalArr.add(arr2.get(j));
                j++;
            }
        }

        while (i < arr1.size()) {
            finalArr.add(arr1.get(i));
            i++;
        }

        while (j < arr2.size()) {
            finalArr.add(arr2.get(j));
            j++;
        }

        // Create Bst
        return createBst(finalArr, 0, finalArr.size()-1); 
    }

    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    
    public static void main(String[] args) {

        // Bst 1
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        // Bst 2 
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = mergeBst(root1, root2);
        preOrder(root);
        
    }
}
