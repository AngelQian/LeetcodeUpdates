public class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int max_sofar = nums[0];
        int min_sofar = nums[0];
        
        int max_temp, min_temp;
        
        for(int i=1; i<nums.length; i++){
            max_temp = Math.max(nums[i],Math.max(min_sofar*nums[i],max_sofar*nums[i]));
            min_temp = Math.min(nums[i],Math.min(min_sofar*nums[i],max_sofar*nums[i]));
            result = Math.max(result, max_temp);
            max_sofar = max_temp;
            min_sofar = min_temp;
        }
        return result;
    }
}