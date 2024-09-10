public class LongestRepeatingCharacterReplacement {
    class Solution {
        public int characterReplacement(String s, int k) {
            int r = 0, l = 0, maxLen = 0, maxfreq = 0;
            int[] hash = new int[26];
    
            while (r < s.length()) {
                hash[s.charAt(r) - 'A']++;
                maxfreq = Math.max(maxfreq, hash[s.charAt(r) - 'A']);
    
                int len = r - l + 1;
    
                if ((len - maxfreq) > k) {
                    hash[s.charAt(l) - 'A']--;
                    maxfreq = 0;
                    for(int i = 0;i<26;i++) {
                        maxfreq = Math.max(maxfreq, hash[i]);
                    }
                    l++;
                }
    
                if((len - maxfreq) <= k) {
                    maxLen = Math.max(maxLen, len);
                }
                r++;
            }
    
            return maxLen;
        }
    }
}
