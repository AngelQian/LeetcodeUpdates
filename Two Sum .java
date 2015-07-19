public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=1; i<=nums.length; i++){
            int cur = nums[i-1];
            int gap = target-cur;
            if(hm.containsKey(gap) && hm.get(gap)<i){
               return new int[]{hm.get(gap), i};
            }
            hm.put(cur,i);
        }
        return null;
    }
}