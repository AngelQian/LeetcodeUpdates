public class Solution {
    public int jump(int[] nums) {
        int step=0;
        int left=0,right=0;
        if(nums.length<2)
            return step;
        
        while(left<=right){
            step ++;
            int pre_right = right;
            int start=left;
            while(start<=pre_right){
                int next_right = start+nums[start];
                if(next_right>=nums.length-1)
                    return step;
                    
                right = Math.max(next_right, right);    
                start++;
            }
            left = pre_right+1;
        }    
        
        return 0;
    }
}