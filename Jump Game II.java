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
}