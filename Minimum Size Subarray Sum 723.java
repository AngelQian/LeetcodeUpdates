public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int minLen=Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            int sum = 0, j=i;
            while(sum<s && j<nums.length)
                sum += nums[j++];
            
            if(sum>=s)
                minLen = Math.min(minLen, j-i);
        }
        return minLen==Integer.MAX_VALUE ? 0 : minLen;
    }
}