public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        
        int left=0, right=nums.length-1;
        int mid_pos = 0;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]>target){
                right = mid-1;
            }else{
                result[0]=mid;
                result[1]=mid;
                mid_pos = mid;
                break;
            }
        }
        
        // no target exists in the sorted array.
        if(nums[mid_pos] != target)
            return result;
            
        //figure out left boundary
        left = 0; right = mid_pos;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target)
                right = mid-1;
            else
                left = mid+1;
        }
        result[0] = left;
        
        //figure out right boundary
        left = mid_pos; right = nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target)
                left = mid+1;
            else
                right = mid-1;
        }
        result[1] = right;
        
        return result;
    }
}