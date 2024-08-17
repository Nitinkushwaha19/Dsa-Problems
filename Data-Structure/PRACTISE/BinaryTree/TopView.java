import java.util.*;

public class TopView {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int d) {
            this.data = d;
            this.left = this.right = null;
        }
    }

    static class Info {
        int hd;
        Node node;

        public Info(int d, Node node) {
            this.hd = d;
            this.node = node;
        }
    }

    public static void topView(Node root) {
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        q.add(new Info(0, root));
        q.add(null);
        int min = 0;
        int max = 0;
        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }

                if (curr.node.left != null) {
                    q.add(new Info(curr.hd - 1, curr.node.left));
                    min = Math.min(min, curr.hd - 1);
                }

                if (curr.node.right != null) {
                    q.add(new Info(curr.hd + 1, curr.node.right));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    public static void botomView(Node root) {
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();
        
        q.add(new Info(0, root));
        q.add(null);
        int min = 0;
        int max = 0;

        while(!q.isEmpty()) {
            Info curr = q.remove();
            if(curr == null) {
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                map.put(curr.hd, curr.node);

                if(curr.node.left != null) {
                    q.add(new Info(curr.hd -1, curr.node.left));
                    min = Math.min(min, curr.hd -1);
                }

                if(curr.node.right != null) {
                    q.add(new Info(curr.hd + 1, curr.node.right));
                    max = Math.max(max,curr.hd + 1);
                }
            }
        }

        for(int i = min;i<=max;i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
        
    }

    public static ArrayList<Integer> leftView(Node root) {
        // Your code here
        ArrayList<Integer> arr = new ArrayList<>();
        if (root == null) {
            return arr;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        arr.add(root.data);

        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {

                if (q.isEmpty()) {
                    break;
                } else {
                    Node node = q.peek();
                    arr.add(node.data);
                    q.add(null);
                }
            } else {
                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        return arr;
    }

    public static ArrayList<Integer> zigZagTraversal(Node root) {
        // Add your code here.
        ArrayList<Integer> arr = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        if (root == null) {
            return arr;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int count = 1;

        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                while(!s. isEmpty()) {
                    arr.add(s.pop());
                }
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                    count++;
                }
            } else {
                if (count % 2 == 0) {
                    s.push(curr.data);
                } else {
                    arr.add(curr.data);
                }

                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        // root.right.left = new Node(6);
        // root.right.right = new Node(7);

        // topView(root);
        // System.out.println(leftView(root));
        // System.out.println(zigZagTraversal(root));

        botomView(root);
    }
}
