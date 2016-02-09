Jump Game II
public class Solution {
    public int jump(int[] nums) {
        int step=0, cur=0, next=0, reach=0;
        while(next<nums.length-1){
            reach=0;
            for(int i=cur; i<=next; i++){//find out the farest reach in [cur,next];
                reach = Math.max(reach, i+nums[i]);
            }
            cur=next+1;
            next=reach;
            step++;
        }
        return step;
    }
    public int jump2(int[] nums) {
        int cur_max=0, last_max=0, step=0;
        for(int i=0; i<nums.length-1; i++){
            cur_max=Math.max(cur_max, i+nums[i]);
            if(i==last_max){
                step++;
                last_max=cur_max;
            }
        }
        return step;
    }
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
