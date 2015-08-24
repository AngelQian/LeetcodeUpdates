public class Solution {
    public int maximalSquare(char[][] matrix) {
        int row=matrix.length; int col=0;
        if(row>0)
            col=matrix[0].length;
        
        int result=0;
        int[][] f = new int[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j]=='1'){
                    int width=1;
                    if(i!=0 && j!=0)
                        width=Math.min(f[i-1][j-1], Math.min(f[i-1][j],f[i][j-1]))+1;
                        
                    f[i][j]=width;  
                    result=Math.max(result,width*width);
                }
            }
        }
        return result;
    }
}