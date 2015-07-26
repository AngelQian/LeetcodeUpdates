public class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        // reverse by line
        for(int i1=0,i2=row-1; i1<i2; i1++,i2--){
            for(int j=0; j<col; j++){
                int tmp = matrix[i1][j];
                matrix[i1][j] = matrix[i2][j];
                matrix[i2][j] = tmp;
            }
        }
        
        //reverse by diagonal
        for(int i=0; i<row; i++){
            for(int j=0; j<i; j++){
                if(i!=j)
                {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
        }
        
    }
}