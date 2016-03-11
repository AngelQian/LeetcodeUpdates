public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length<1)
            return 0;
        int row=matrix.length, col=matrix[0].length; 
        int max=0;
        int[] height = new int[col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(i==0){
                    height[j]=matrix[i][j]=='1'?1:0;
                }else{
                    if(matrix[i][j]=='1'){
                        height[j]+=1;
                    }else
                        height[j]=0;
                }
            }
            int rowMax = getMaxInRow(height);
            max = Math.max(max, rowMax);
        }
        return max;
    }
    
    private int getMaxInRow(int[] height){
        int area=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<height.length; i++){
            int tmp=height[i];
            if(!map.containsKey(tmp)){
                map.put(tmp, getArea(height, tmp));
            }
            area = Math.max(area, map.get(tmp));
        }
        return area;
    }
    
    private int getArea(int[] height, int val){
        //all number equal or greater than val
        int width=0, tmp=0;
        for(int i=0; i<height.length; i++){
            if(height[i]>=val)
                tmp++;
            else
                tmp=0;
            width = Math.max(width, tmp);
        }
        return val*width;
    }
}
//https://leetcode.com/discuss/52670/solution-based-maximum-rectangle-histogram-with-explanation
------
//比较好的解法
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if(row<1)
            return 0;
        int col=matrix[0].length;
        int[] heights = new int[col];
        int area = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j]=='1')
                    heights[j] += 1;
                else
                    heights[j] = 0;
            }
            area = Math.max(area, largestRectangleArea(heights));
        }
        return area;
    }
    
    public int largestRectangleArea(int[] heights) {
        //append 0 at the end;
        int[] copyH = new int[heights.length+1];
        for(int i=0; i<heights.length; i++)
            copyH[i]=heights[i];
        copyH[heights.length]=0;
        
        //accumulate increasing number and calculate max area once decreasing
        int cur=0, area=0;
        Stack<Integer> stW = new Stack<>();
        while(cur<copyH.length){
            if(stW.isEmpty() || copyH[cur]>=copyH[stW.peek()])
                stW.push(cur++);
            else{
                int h = copyH[stW.pop()];
                int w = stW.isEmpty() ? cur : cur-stW.peek()-1;
                area = Math.max(area, w*h);
            }    
        }
        return area;    
    }
}
