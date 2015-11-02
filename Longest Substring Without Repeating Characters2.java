class Solution {
    public static int lengthOfLongestSubstring(String s) {
        //slow 挪到开始的位置，记住，slow只能越来越大；每次都是取max（上一次出现的元素+1, 当前slow）的最大值
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen=0;
        for(int slow=0, fast=0; fast<s.length(); fast ++){
            char c = s.charAt(fast);
            if(map.containsKey(c)){
                slow = Math.max(slow, map.get(c)+1);
            }
            map.put(c, fast);
            maxLen = Math.max(fast-slow+1, maxLen);
        }
        return maxLen;
    }
};
