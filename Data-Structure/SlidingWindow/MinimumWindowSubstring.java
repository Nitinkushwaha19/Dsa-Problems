import java.util.*;
public class MinimumWindowSubstring {
    class Solution {
        public String minWindow(String s, String t) {
            if (s == null || t == null || s.length() < t.length()) return "";
    
            HashMap<Character,Integer> map = new HashMap<>();
            for(char ch : t.toCharArray()) {
                map.put(ch, map.getOrDefault(ch,0)+1);
            }
    
            int r = 0, l = 0, startIdx = -1;
            int minLen = Integer.MAX_VALUE;
            int count = 0;
    
            while(r < s.length()){
                
                if(map.containsKey(s.charAt(r)) ) {
    
                    if(map.get(s.charAt(r)) > 0){
                        count++;
                    }
                    map.put(s.charAt(r),map.get(s.charAt(r))-1);
                }
    
    
                while(count == t.length()){
                    int len = r - l + 1;
                    if(len < minLen){
                        minLen = len;
                        startIdx = l;
                    }
    
                    if(map.containsKey(s.charAt(l))) {
                        map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                        if(map.get(s.charAt(l)) > 0) {
                            count--;
                        }
                    }
                    l++;
                }
    
                r++;
            }
    
            return startIdx == -1 ? "" : s.substring(startIdx,startIdx + minLen);
        }
    }
}
