public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int gap = target - nums[i];
            if(hm.containsKey(gap)){
                result[0]=hm.get(gap)+1;
                result[1]=i+1;
                break;
            }
            hm.put(nums[i],i);
        }
        return result;
    }
}