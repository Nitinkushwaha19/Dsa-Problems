import java.util.*;

public class IsAnagram {
    public static boolean isAnagram(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<str1.length();i++){
            char ch = str1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0;i<str2.length();i++){
            char ch =  str2.charAt(i);
            if(map.get(ch) != null){
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else {
                    map.put(ch, map.get(ch) - 1);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }
    public static void main(String args[]){
        String str = "race";
        String str2 = "nitin";
        System.out.println(isAnagram(str, str2));
        
    }
}
