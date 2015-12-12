public class Solution {
    private Integer l=Integer.MAX_VALUE, r=Integer.MIN_VALUE;
	    
	    public int[] searchRange(int[] nums, int target) {
	        helper(nums, target, 0, nums.length-1);
	        return l==Integer.MAX_VALUE?new int[]{-1,-1}:new int[]{l, r};
	    }
	    
	    private void helper(int[] nums, int target, Integer left, Integer right){
	        if(left>right)
	            return;
	        int mid=(left+right)/2;
	        if(nums[mid]==target){
	            l=Math.min(l,mid);
	            r=Math.max(r,mid);
	            helper(nums, target, left, mid-1);
	            helper(nums, target, mid+1, right);
	        }else if(nums[mid]>target)
	            helper(nums, target, left, mid-1);
	        else
	            helper(nums, target, mid+1, right);
	    }
}

=======================================================

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
