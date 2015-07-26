public class Solution {
    public int minPathSum(int[][] grid) {
        //向下走||向右走
        //逆推，从上面下来||从左边走来
        int row = grid.length, col=grid[0].length;
        for(int i=row-1; i>0; i--)
            grid[i-1][col-1] += grid[i][col-1];
            
        for(int j=col-1; j>0; j--)
            grid[row-1][j-1] += grid[row-1][j];
            
        for(int i=row-2; i>=0; i--){
            for(int j=col-2; j>=0; j--){
                grid[i][j] += Math.min(grid[i+1][j],grid[i][j+1]);
            }
        }
        return grid[0][0];
    }
}