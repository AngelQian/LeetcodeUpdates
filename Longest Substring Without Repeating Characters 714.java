public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int maxLen=0;
        for(int i=0, j=0; i<=j&&j<s.length(); j++){
            char c = s.charAt(j);
            if(hm.containsKey(c))
                i = Math.max(i,hm.get(c)+1);
            hm.put(c,j);    
            maxLen = Math.max(maxLen, j-i+1);
        }
        return maxLen;
    }
}