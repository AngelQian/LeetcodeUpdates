public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int minLen=Integer.MAX_VALUE, sum=0, j=0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            while(sum>=s){
                minLen = Math.min(minLen, i-j+1);
                sum -= nums[j++];
            }
        }
        return minLen==Integer.MAX_VALUE ? 0 : minLen;
    }
}