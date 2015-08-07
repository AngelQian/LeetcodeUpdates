public class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] max_left = new int[len];
        int[] max_right = new int[len];
        
        for(int i=1; i<len; i++){
            max_left[i] = Math.max(max_left[i-1],height[i-1]);
            max_right[len-i-1] = Math.max(max_right[len-i],height[len-i]);
        }
        
        int result = 0;
        for(int i=0; i<len; i++){
            int h = Math.min(max_left[i], max_right[i]);
            if(h>height[i])
                result += (h-height[i]);
        }
        
        return result;
    }
}