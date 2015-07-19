public class Solution {
    public int maximalSquare(char[][] matrix) {
        /*
        确保每一个元素[i,j], 他的x = Min{[i,j-1], [i-1,j],[i-1,j-1]}
        take x's square root, add 1, and assign square of new value to current cell [i,j].
        => f(x,y) = Math.pow(Math.sqrt(x)+1, 2)
        */
        
        int row = matrix.length, max=0;
        if(row<1)
            return max;
            
        int col = matrix[0].length;
        int[][] f = new int[row][col];
        
        for(int j=0; j<col; j++){
            f[0][j] = matrix[0][j]-'0';
            max = Math.max(max, f[0][j]);
        }
        
        for(int i=0; i<row; i++){
            f[i][0] = matrix[i][0]-'0';
            max = Math.max(max, f[i][0]);
        }
        
        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                if(matrix[i][j]!='0'){
                    int min = Math.min(Math.min(f[i][j-1],f[i-1][j-1]),f[i-1][j]);
                    f[i][j] = (int) Math.pow(Math.sqrt(min)+1, 2);
                    max = Math.max(max, f[i][j]);
                }
            }
        }
        
        return max;
    }
}