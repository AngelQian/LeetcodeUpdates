public class Solution {
    public void nextPermutation(int[] nums) {
        /*1. find partition number; 从右向左，第一个降序的数字;
        2. find change number; 从右向左，第一个大于partition的数字;
        3. partition number <-> change number;
        4. reverse all numbers after the index of partition number;*/
        
        int partition_index = -1;
        for(int i=nums.length-1; i>0; i--){
            if(nums[i-1]<nums[i]){
                partition_index = i-1;
                break;
            }
        }
        
        if(partition_index<0)
        {
            reverseArray(nums,0,nums.length-1);
            return;
        }
        
        int change_index = -1;
        for(int i=nums.length-1; i>partition_index; i--){
            if(nums[i]>nums[partition_index]){
                change_index = i;
                break;
            }
        }
        
        int tmp = nums[partition_index];
        nums[partition_index] = nums[change_index];
        nums[change_index] = tmp; 
        
        reverseArray(nums,partition_index+1,nums.length-1);
    }
    
    private void reverseArray(int[] nums, int start, int end){
        for(int i=start, j=end; i<j; i++,j--){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp; 
        }
    }
}