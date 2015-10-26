public class Solution {
    int row , col;
        
    public void solve(char[][] board) {
        row = board.length;
        if(row<1)
            return;
            
        col = board[0].length;
        
        //fill surroundings, O ->#
        for(int i=0; i<row; i++){
            if(board[i][0]=='O'){
                merge(board, i, 0);
            }
            if(board[i][col-1]=='O'){
                merge(board, i, col-1);
            }
        }
        for(int j=0; j<col; j++){
            if(board[0][j]=='O'){
                merge(board, 0, j);
            }
            if(board[row-1][j]=='O'){
                merge(board, row-1, j);
            }
        }
        
        //pass the whole board, O->X
        //restore #->O
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(board[i][j]=='O')
                    board[i][j] = 'X';
                else if(board[i][j]=='#')
                    board[i][j] = 'O';
            }
        }
    }
    
    //BFS
    Queue<Integer> queue = new LinkedList<>();
    private void merge(char[][] board, int i, int j){
        fillCell(board, i, j);
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            int r=cur/col, c=cur%col;
            fillCell(board, r-1, c);
            fillCell(board, r+1, c);
            fillCell(board, r, c-1);
            fillCell(board, r, c+1);
        }
    }
    private void fillCell(char[][] board, int i, int j){
        if(i>=row || i<0 || j<0 || j>=col)
            return;
        if(board[i][j] != 'O')
            return;
        
        queue.offer(i * col + j);
		board[i][j] = '#';
    }
}