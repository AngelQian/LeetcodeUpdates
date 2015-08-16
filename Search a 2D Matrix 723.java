public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        //@ column 0
        int low=0, high=row-1;
        while(low<=high){
            int mid1=(low+high)/2;
            if(matrix[mid1][0]==target)
                return true;
            if(matrix[mid1][0]>target) 
                high = mid1-1;
            else 
                low = mid1+1;
        }
        row=Math.max(0,low-1);
        
        //@ row
        low=0; high=col-1;
        while(low<=high){
            int mid2=(low+high)/2;
            if(matrix[row][mid2]==target)
                return true;
            if(matrix[row][mid2]>target) 
                high = mid2-1;
            else 
                low = mid2+1;
        }
        col=Math.max(0,low-1);
        
        return false;
        
    }
}
------------------------------
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
