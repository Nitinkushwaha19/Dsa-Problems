public class TrieCode {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;
        
        public Node() {
            for(int i = 0;i<children.length;i++){
                children[i] = null;
            }
        }
    }

    static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for(int i = 0;i<word.length();i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static boolean search(String key){
        Node curr = root;
        for(int i = 0;i<key.length();i++){
            int idx = key.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }

        return curr.eow == true;
    }
    public static void main(String[] args) {
        String word[] = {"the","there","their","a","any","anybody"};
        for(int i = 0;i<word.length;i++){
            insert(word[i]);
        }

        System.out.println(search("the"));
        System.out.println(search("th"));
    }
}