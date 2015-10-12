class Solution {
public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen=0;
        for(int i=0, j=0; j<s.length(); j++){
            char c = s.charAt(j);
            if(map.containsKey(c)){
                i = Math.max(i, map.get(c)+1);
            }
            map.put(c, j);
            maxLen = Math.max(maxLen, j-i+1);
        }
        
        return maxLen;
    }
};