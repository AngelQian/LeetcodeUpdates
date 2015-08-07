public class Solution {
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
        
    }
    
    private boolean solveSudokuHelper(char[][] board){
        // if(row)
        for(int i=0; i<9; i++)
        {
            for(int j=0; j<9; j++){
                if(board[i][j]=='.'){
                    for(char n='1'; n<='9'; n++){
                        if(isValidSudoku(board, i, j, n))
                        {    
                            board[i][j]=n;
                            if(solveSudokuHelper(board))
                                return true;
                            else
                                board[i][j]='.';    
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValidSudoku(char[][] board, int i, int j, int num){
        //row
        for(int c=0; c<9; c++)
        {
            if(j!=c && board[i][c]==num)
                return false;
        }
        //col
        for(int r=0; r<9; r++)
        {
            if(r!=i && board[r][j]==num)
                return false;
        }
        //3x3
        for(int r=3*(i/3); r<3*(i/3)+3; r++){
            for(int c=3*(j/3); c<3*(j/3)+3; c++){
                if((r!=i||c!=j)&&board[r][c]==num)
                    return false;
            }
        }
        return true;
    }
}