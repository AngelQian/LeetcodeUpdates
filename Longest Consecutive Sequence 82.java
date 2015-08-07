public class Solution {
    public int longestConsecutive(int[] nums) {
        int len = 0;
        HashMap<Integer, Boolean> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            hm.put(nums[i], false);
        }
        
        for(int i=0; i<nums.length; i++){
            int l=1, num=nums[i];
            if(hm.get(num)==false){
                hm.put(num, true);
                for(int n=num+1; hm.containsKey(n); n++){
                    hm.put(n,true);
                    l++;
                }
                for(int n=num-1; hm.containsKey(n); n--){
                    hm.put(n,true);
                    l++;
                }
                len = Math.max(len, l);
            }
        }
        
        return len;
    }
}