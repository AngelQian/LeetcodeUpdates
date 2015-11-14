public class Solution {
    private int row,col;
    public boolean searchMatrix(int[][] matrix, int target) {
        row=matrix.length-1;
        col=matrix[0].length-1;
        return searchMatrixHelper(matrix, 0,row,0,col, target);
    }
    private boolean searchMatrixHelper(int[][] matrix, int top, int bottom, int left, int right, int target){
        if(top>bottom || left>right)
            return false;
            
        if(target == matrix[bottom][left])
            return true;
        if(target < matrix[bottom][left]) 
            return searchMatrixHelper(matrix, top, bottom-1, left, right, target);
        else
            return searchMatrixHelper(matrix, top, bottom, left+1, right, target);
    }
}