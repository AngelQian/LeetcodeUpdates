public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length<1)
            return 1;
            
        for(int i=0; i<nums.length; i++){
            int num=nums[i];
            while(num>0 && num<=nums.length && num!=nums[num-1]){
                //num should be at index of (num-1)
                swap(nums, num-1, i);
                num=nums[i];
            }
        }
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=i+1)
                return i+1;
        }
        
        return nums.length+1;
    }
    
    private void swap(int[] nums, int pos1, int pos2){
        int tmp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = tmp;
    }
}