public class Solution {
    public int jump(int[] nums) {
        int step=0;
        int last=0,cur=0;
        for(int i=0; i<nums.length; i++){
            if(i>last)
            {
                last=cur;
                step++;
            }
            cur = Math.max(cur, i+nums[i]);
        }
        return step;
    }
}