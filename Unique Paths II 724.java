public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row=obstacleGrid.length, col=obstacleGrid[0].length;
        
        obstacleGrid[0][0] = obstacleGrid[0][0]==1 ? 0 : 1;
            
        for(int j=1; j<col; j++){
            obstacleGrid[0][j] = obstacleGrid[0][j-1]==0||obstacleGrid[0][j]==1 ? 0 : 1;
        }
            
        for(int i=1; i<row; i++)
            obstacleGrid[i][0] = obstacleGrid[i-1][0]==0||obstacleGrid[i][0]==1 ? 0 : 1;  
        
        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                if(obstacleGrid[i][j]==1){
                    obstacleGrid[i][j]=0;
                }else{
                    obstacleGrid[i][j] = obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
                }
            }
        } 
        
        return obstacleGrid[row-1][col-1];
    }
}