public class Solution {
    public int trap(int[] height) {
        int max=0;
        int len = height.length;
        for(int i=1; i<len; i++){
            if(height[i]>height[max])
                max=i;
        }
        
        int result = 0;
        for(int i=0, cur=0; i<max; i++){
            if(height[i]>cur)
                cur=height[i];
            else
                result+=(cur-height[i]);
        }
        for(int j=len-1, cur=0; j>max; j--){
            if(height[j]>cur)
                cur=height[j];
            else
                result+=(cur-height[j]);
        }
        
        return result;
    }
}