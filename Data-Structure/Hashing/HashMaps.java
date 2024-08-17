import java.util.*;

public class HashMaps {
    public static void main(String args[]) {
        HashMap<String, Integer> hm = new HashMap<>();

        // Insert - O(1)
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("Us", 50);
        hm.put("Nepal", 5);
        hm.put("Indonesia", 1);

        // System.out.println(hm);

        // Get - O(1)
        // int pop = hm.get("India");
        // System.out.println(pop);

        // ContainsKey - O(1)
        // System.out.println(hm.containsKey("India"));

        // Remove - O(1)
        // hm.remove("China");
        // System.out.println(hm);

        // Size - O(1)
        // System.out.println(hm.size());

        // Clear - O(1)
        // hm.clear();

        // isEmpty - O(1)
        // System.out.println(hm.isEmpty());

        // Iteration
        Set<String> keys = hm.keySet();
        for (String k : keys) {
            System.out.println("Key = " + k + ", value = " + hm.get(k));
        }
        
    }
}