public class Solution {
    private int result=0;
    
    public int totalNQueens(int n) {
        int[] queens = new int[n];
        helper(0, queens);
        return result;
    }
    private void helper(int cur, int[]queens){
        if(cur==queens.length){
            result++;
            return;
        }
        for(int j=0; j<queens.length; j++){
            if(alreadExist(queens, cur, j))
                continue;
            queens[cur]=j;
            helper(cur+1, queens);
            // queens[cur]=0;
        }
    }
    private boolean alreadExist(int[] queens, int m, int n){
        for(int i=0; i<m; i++){
            if(queens[i]==n || (Math.abs(i-m)==Math.abs(queens[i]-n)))
                return true;
        }
        return false;
    }
}