public class Solution {
    public int maxProduct(int[] nums) {
        int maxPre=nums[0],minPre=nums[0],max=nums[0], maxHere, minHere;
        
        for(int i=1; i<nums.length; i++)
        {
            maxHere = Math.max(nums[i], Math.max(maxPre*nums[i],minPre*nums[i]));
            minHere = Math.min(nums[i], Math.min(maxPre*nums[i],minPre*nums[i]));
            max = Math.max(maxHere,max);
            maxPre = maxHere;
            minPre = minHere;
        }
        
        return max;
    }
}