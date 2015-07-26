public class Solution {
    public void sortColors(int[] nums) {
        for(int i=0, j=nums.length-1, k=0; i<j && k<=j; ){
            if(nums[k]==0){
                swap(nums, i, k);
                i++;
                k++;
            }
            else if(nums[k]==2){
                swap(nums, j, k);
                j--;
            }
            else if(nums[k]==1){
                k++;
            }
        }
    }
    
    private void swap(int[] nums, int first, int second){
        if(first==second)
            return;
        int tmp = nums[first];
        nums[first] = nums[second];
        nums[second] = tmp;
    }
}