Kth Largest Element in an Array

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Quick sort theory, find partition
        int left=0, right=nums.length-1, val;
        while(left<=right){
            val=nums[left];
            int pos = getIndex(val, nums, left+1, right);
                
            swap(nums, pos-1, left); 
            
            if(pos==k)
                return nums[pos-1];
            
            if(pos>k)
                right=pos-2;
            else
                left=pos;   
        }
        return -1;
    }
    
    private int getIndex(int val, int[] nums, int left, int right){
        while(left<=right){
            if(nums[left]<val)
                swap(nums, left, right--);
            else if(nums[right]>val)
                swap(nums, left++, right);
            else{
                left++;
                right--;
            }    
        }
        return left;
    }
    
    private void swap(int[]nums, int left, int right){
        if(left<0 || right>=nums.length)
            return;
        int x=nums[left];
        nums[left]=nums[right];
        nums[right]=x;
    }
}
