import java.util.*;

public class HashMapCode {
    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V val) {
                this.key = key;
                this.value = val;
            }
        }

        private int N;
        private int n;
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.n = 0;
            this.buckets = new LinkedList[4];
            this.N = buckets.length;
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = searchLL(key, bi);

            if (di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double) n / N;
            if (lambda > 2.0) {
                rehash();
            }
        }

        private int hashFunction(K key) {
            int hash = hashCode();
            return Math.abs(hash) % N;
        }

        private int searchLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0;

            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key == key) {
                    return di;
                }
                di++;
            }

            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node> oldBuc[] = buckets;
            buckets = new LinkedList[N * 2];
            N = 2 * N;
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            // Node -> add in bucket
            for (int i = 0; i < oldBuc.length; i++) {
                LinkedList<Node> ll = oldBuc[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public boolean containsKey(K key){
            int bi = hashFunction(key);
            int di = searchLL(key, bi);

            if(di != -1){
                return true;
            } else {
                return false;
            }
        }

        public V get(K key){
            int bi = hashFunction(key);
            int di = searchLL(key, bi);

            if (di != -1) {
                Node node = buckets[bi].get(di);
                return node.value;
            }
            return null;
        }

        public V remove(K key){
            int bi = hashFunction(key);
            int di = searchLL(key, bi);

            if (di != -1) {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
            return null;
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for(int i = 0;i<buckets.length;i++){
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty(){
            return n == 0;
        }

    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("Nepal", 5);
        hm.put("Bhutan", 1);

        ArrayList<String> arr = hm.keySet();
        System.out.println(arr);

        System.out.println(hm.get("India"));
        hm.remove("Nepal");
        System.out.println(hm.get("Nepal"));
    }
}