public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top=0, left=0, bottom=n-1, right=n-1;
        int value = 1;
        
        while(top<=bottom && left<=right){
            for(int j=top; j<=right; j++)
                matrix[top][j] = value++;
            top ++;
            
            for(int i=top; i<=bottom; i++)
                matrix[i][right] = value++;
            right --;
            
            if(top<=bottom){
                for(int j=right; j>=left; j--)
                    matrix[bottom][j] = value++;
                bottom --;    
            }
            
            if(left<=right){
                for(int i=bottom; i>=top; i--)
                    matrix[i][left] = value++;
                left ++;    
            }
        }
        
        return matrix;
    }
}