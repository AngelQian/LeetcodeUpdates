public class Solution {
    //皇后横，竖，斜都可以走，但是不可以越子
    public List<List<String>> solveNQueens(int n) {
        int[] row = new int[n];
        int[] col = new int[n];
        int[] main_diag = new int[n*2];
        int[] anti_diag = new int[n*2];
        
        List<List<String>> result = new ArrayList<>();
        solveNQueensHelper(row, col, main_diag, anti_diag, result, 0);
        return result;
    }
    
    private void solveNQueensHelper(int[] row, int[] col, int[] main_diag, int[] anti_diag, List<List<String>> result, int cur){
        if(cur == row.length){
            List<String> solution = new ArrayList<>();
            for(int i=0; i<row.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<row.length; j++)
                    sb.append(j==row[i] ? 'Q' : '.');
                solution.add(sb.toString());    
            }
            result.add(solution);
            return;
        }
        
        for(int j=0; j<row.length; j++){
            if(col[j]==0 && main_diag[cur+j]==0 && anti_diag[cur+row.length-j]==0){
                row[cur]=j;
                col[j] = main_diag[cur+j] = anti_diag[cur+row.length-j] = 1;
                solveNQueensHelper(row, col, main_diag, anti_diag, result, cur+1);
                col[j] = main_diag[cur+j] = anti_diag[cur+row.length-j] = 0;
            }
        }
    }
    
}