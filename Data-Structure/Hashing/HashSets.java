import java.util.*;
public class HashSets {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(4);
        set.add(2);
        set.add(1);

        // System.out.println(set);
        // set.remove(2);
        // System.out.println(set);

        // System.out.println(set.size());
        // set.clear();
        // System.out.println(set.isEmpty());


        // Iterative approach to traverse the Hashset
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Goa");
        cities.add("Patna");

        Iterator<String> it = cities.iterator();
        while (it.hasNext()) {
            System.err.println(it.next());
        }

        for(String city : cities) {
            System.out.println(city);
        }
    }
}
