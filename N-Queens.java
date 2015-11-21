public class Solution {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] queens = new int[n];
        //int[][] visited = new int[n][n];
        helper(result, 0, queens);
        return result;
    }
    
    private static void helper(List<List<String>> result, int cur, int[]queens){
        if(cur == queens.length){
          List<String> solution = new ArrayList<>();
          for(int i=0; i<queens.length; i++){
              StringBuilder builder = new StringBuilder();
              for(int j=0; j<queens.length; j++){
                  builder.append(queens[i]==j? "Q" : ".");
              }
            solution.add(builder.toString());
          }
          /*for(int i=0; i<visited.length; i++){
            StringBuilder builder = new StringBuilder();
            for(int j=0; j<visited.length; j++){
              builder.append(visited[i][j]==1? "Q" : ".");
            }
            solution.add(builder.toString());
          }*/
          result.add(solution);
          return;
        }
        
        for(int j=0; j<queens.length; j++){
              //no duplicate in row, col, diagonal, anti-diagonal              
              if(alreadyExist(queens, cur, j))
                continue;
                
              queens[cur]=j;
              helper(result, cur+1, queens);
              queens[cur]=0;
        }
    }
    
    private static boolean alreadyExist(int[] matrix, int m, int n){
    for(int i=0; i<m; i++)
      if(matrix[i]==n || Math.abs(matrix[i]-n)==Math.abs(i-m))
        return true;
    return false;
  }
  
  /*
  private static boolean containsInRowCol(int[][] matrix, int m, int n){
    for(int o=0; o<matrix.length; o++)
      if(matrix[o][n]==1){
        return true;
      }
    return false;
  }
  
  private static boolean containsInDiagonal(int[][] matrix, int m, int n){
    for(int i=0; i<matrix.length; i++){
      for(int j=0; j<matrix.length; j++){
        if(matrix[i][j]==1 && Math.abs(m-i)==Math.abs(n-j)){
          return true;
        }
      }
    }
    return false;
  }*/
}