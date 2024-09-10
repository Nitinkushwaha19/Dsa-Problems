public class NumberOfSubstringContainingCharacter {
    class Solution {
        public int numberOfSubstrings(String s) {
            int[] lastseen = {-1,-1,-1};
            int res = 0;
    
            for(int i = 0;i<s.length();i++){
                lastseen[s.charAt(i) - 'a'] = i;
                res += (1 + Math.min(lastseen[0],Math.min(lastseen[1],lastseen[2])));
            }
    
            return res;
        }
    }
}
