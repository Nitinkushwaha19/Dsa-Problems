import java.util.*;

public class LinkedHasSets {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Goa");
        cities.add("Patna");
        System.out.println(cities);
        System.out.println("****************");
        
        
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Delhi");
        lhs.add("Mumbai");
        lhs.add("Goa");
        lhs.add("Patna");
        System.out.println(lhs);
        
    }
}
