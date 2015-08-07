public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> sc = new Stack<>();
        
        int[] height = new int[heights.length+1];
        for(int i=0; i<heights.length; i++)
            height[i]=heights[i];
        height[heights.length]=0;
        
        int area = 0;
        for(int i=0; i<height.length;){
            if(sc.isEmpty()==true || height[i]>height[sc.peek()])
                sc.push(i++);
            else{
                int tmp = sc.pop();
                area = Math.max(area, height[tmp]*(sc.isEmpty()==true ? i:i-sc.peek()-1));
            }  
        }
        
        return area;
    }
}



// time limited error
public class Solution {
    public int largestRectangleArea(int[] height) {
        if(height.length<1)
            return 0;
            
        int[] h = new int[height.length];
        int area=0;
        for(int i=0; i<height.length; i++){
            if(height[i]!=0 && height[i]<=area/(height.length-i))
                continue;
            
            for(int j=i; j<height.length; j++){
                h[j]=(i==j) ? height[j] : Math.min(height[j],h[j-1]); 
				area = Math.max(area, h[j]*(j-i+1));    
            }    
        }
        
        return area;
    }
}