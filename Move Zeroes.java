public class Solution {
    public void moveZeroes(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                int k=i;
                while(k-1>=0 && nums[k-1]==0)
                    k--;
                swap(nums, k, i);
            }    
        }
    }
    
    private void swap(int[] nums, int i1, int i2){
        int tmp = nums[i1];
        nums[i1]=nums[i2];
        nums[i2]=tmp;
    }
}