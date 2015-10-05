public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0]=1;
        for(int i=1; i<nums.length; i++)
            result[i] = nums[i-1]*result[i-1];
            
        int[] helper = new int[nums.length];
        helper[nums.length-1]=1;
        for(int i=nums.length-2; i>=0; i--)
            helper[i] = nums[i+1]*helper[i+1];
        
        for(int i=0; i<nums.length; i++){
            result[i] *= helper[i];
        }    
            
        return result;
    }
}