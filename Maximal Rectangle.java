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
        //all number equal or less than val
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