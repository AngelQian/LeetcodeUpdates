public class Solution {
    public int maxArea(int[] height) {
        int max=0,h=Integer.MAX_VALUE,w; 
        
        for(int start=0,end=height.length-1; start<end; ){
            w=end-start;
            h=Math.min(height[start],height[end]);
            max = Math.max(max,w*h);
            if(height[start]<height[end])
                start++;
            else
                end--;
        }
        
        return max;
    }
}