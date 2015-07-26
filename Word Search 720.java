public class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] f = new boolean[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(helperDFS(board, word, f, i, j, 0))
                    return true;
            }
        }
        
        return false;
    }
    
    private boolean helperDFS(char[][] board, String word, boolean[][] f, int x, int y, int index){
        if(index == word.length())
            return true;
            
        if(x<=0 || y<=0 || x>board.length || y>board[0].length)
            return false;
           
        if(f[x][y])
            return false;
            
        if(board[x][y] != word.charAt(index)) 
            return false;
        
        f[x][y]=true;
        boolean result = helperDFS(board, word, f, x, y+1, index+1)
                        ||helperDFS(board, word, f, x, y-1, index+1)
                        ||helperDFS(board, word, f, x+1, y, index+1)
                        ||helperDFS(board, word, f, x-1, y, index+1);
        f[x][y]=false;
        
        return result;    
    }
}