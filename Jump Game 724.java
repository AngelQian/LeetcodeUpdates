//DP1: how much energy left at f[i]
public class Solution {
    public boolean canJump(int[] nums) {
        int[] f = new int[nums.length];
        f[0]=nums[0];
        
        for(int i=1; i<nums.length; i++){
            f[i] = Math.max(f[i-1]-1,nums[i-1]-1);
            if(f[i]<0)
                return false;
        }
        return true;
    }
}

//DP2: f[i]: how far I can reach at f[i]
public class Solution {
    public boolean canJump(int[] nums) {
        int[] f=new int[nums.length+1];
        f[0]=0;
        
        for(int i=0; i<nums.length; i++){
            f[i+1]=Math.max(i+nums[i], f[i]);
            if(f[i]<i)
                return false;
        }
        return true;
    }
}

//Greedy: left->right
public class Solution {
    public boolean canJump(int[] nums) {
        int reach=0;
        for(int i=0; i<=reach&&reach<nums.length; i++){
            reach = Math.max(reach, nums[i]+i);
        }
        return reach>=nums.length-1;
    }
}
