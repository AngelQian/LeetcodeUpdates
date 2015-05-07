public class Solution {
    public int findPeakElement(int[] nums) {
        //any peak is ok
        int[] f = new int[nums.length+2];
        for(int i=0; i<f.length; i++)
        {
            if(i==0 || i==f.length-1)
              f[i] = Integer.MIN_VALUE;
            else
              f[i] = nums[i-1];
        }
        
        int peak = 0;
        for(int i=1; i<f.length-1; i++){
            if(f[i]>f[i-1] && f[i]>f[i+1])
               return i-1;
        }
        return peak;
    }
}