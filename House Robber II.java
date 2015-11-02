House Robber II

public class Solution {
    public int rob(int[] nums) {
        if(nums.length<1)
            return 0;
        if(nums.length<2)
            return nums[0];
         
        int[] fl = new int[nums.length+1];
        fl[0]=0;fl[1]=nums[0];
        for(int i=2; i<fl.length; i++){
            fl[i]=Math.max(fl[i-2]+nums[i-1], fl[i-1]);
        }
        
        int[] fr = new int[nums.length+1];
        fr[fr.length-1]=0; fr[fr.length-2]=nums[nums.length-1];
        for(int i=fr.length-3; i>=0; i--){
            fr[i]=Math.max(fr[i+2]+nums[i], fr[i+1]);
        }
        
        return Math.max(fl[nums.length-1], fr[1]);
    }
}