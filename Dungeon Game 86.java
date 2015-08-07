public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int row=dungeon.length, col=dungeon[0].length;
        int[][] health = new int[row][col];
        
        health[row-1][col-1]=Math.max(1-dungeon[row-1][col-1], 1);
        for(int i=row-2; i>=0; i--)
            health[i][col-1] = Math.max(health[i+1][col-1]-dungeon[i][col-1],1);
        for(int j=col-2; j>=0; j--)
            health[row-1][j] = Math.max(health[row-1][j+1]-dungeon[row-1][j],1);
            
        for(int i=row-2; i>=0; i--)
            for(int j=col-2; j>=0; j--){//保证活着的最小代价
                int h = Math.max(health[i][j+1]-dungeon[i][j],1);
                int v = Math.max(health[i+1][j]-dungeon[i][j],1);
                health[i][j] = Math.min(h,v);
            }
        
        return health[0][0];    
    }
}