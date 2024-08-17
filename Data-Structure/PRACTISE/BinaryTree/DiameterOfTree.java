class DiameterOfTree {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    
    // Function to return the diameter of a Binary Tree.
    public static class Info {
        int diam;
        int ht;
        
        public Info(int d, int h){
            this.diam = d;
            this.ht = h;
        }
    }
    
    public static Info helper(Node root) {
        if(root == null) {
            return new Info(0,0);
        }
        
        Info leftInfo = helper(root.left);
        Info rightInfo = helper(root.right);
        
        int diam = Math.max(Math.max(leftInfo.diam,rightInfo.diam),leftInfo.ht + rightInfo.ht + 1);
        int h = Math.max(leftInfo.ht,rightInfo.ht) + 1;
        
        return new Info(diam,h);
    }
    
    public static int diameter(Node root) {
        // Your code here
        if(root == null) {
            return 0;
        }
        
        return helper(root).diam;
    }
    
    public static void main(String[] args) {
        
    }
}
