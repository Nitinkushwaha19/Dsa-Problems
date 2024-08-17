import java.util.*;
public class TreeMaps {
    public static void main(String[] args) { // O(logn) due to sorting 
        TreeMap<String,Integer> hm = new TreeMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("Us", 50);

        System.out.println(hm);
    }
}
