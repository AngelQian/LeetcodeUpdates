public class Solution {
    int row, col;
    public boolean exist(char[][] board, String word) {
        row = board.length; col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(hasCharacter(0, word, r, c, board, visited)){
                    return true;
                }
            } 
        }   
        return false;   
    }
    
    private boolean hasCharacter(int index, String word, int r, int c, char[][] board, boolean[][] visited){
        if(index>=word.length())
            return true;
            
        if(r>=row || c>=col || r<0 || c<0)
            return false;
        if(visited[r][c] == true)
            return false;
        if(word.charAt(index)!=board[r][c])
            return false;
        
        visited[r][c] = true;
        boolean val = hasCharacter(index+1, word, r+1, c, board, visited) ||
            hasCharacter(index+1, word, r-1, c, board, visited)||
            hasCharacter(index+1, word, r, c+1, board, visited)||
            hasCharacter(index+1, word, r, c-1, board, visited);
        if(val==false)
            visited[r][c] = false;
        
        return val;    
    }
}
