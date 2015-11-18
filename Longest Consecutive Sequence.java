public class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int num: nums){
            map.put(num, false);
        }
        
        int longest=0, len;
        for(int num: nums){
            if(map.get(num)==false){
                map.put(num,true);
                len=1;
                for(int n1=num+1; map.containsKey(n1); n1++){
                    map.put(n1, true);
                    len++;
                }
                for(int n2=num-1; map.containsKey(n2); n2--){
                    map.put(n2, true);
                    len++;
                }
                longest = Math.max(longest, len);
            }
        }
        
        return longest;
    }
}