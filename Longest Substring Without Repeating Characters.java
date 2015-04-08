public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hs = new HashMap<>();
		int max_len = 0;
		int len = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(hs.containsKey(c))
			   len = Math.max(hs.get(c)+1,len);
			hs.put(c,i);
			max_len = Math.max(max_len, i-len+1);
		}
		return max_len;
    }
}