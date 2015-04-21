public class Solution {
    public void solve(char[][] board) {
         int row = board.length;
        if(row<1) return;
        
        int col = board[0].length;
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++){
                if(i==0 || i==row-1 || j==0 || j==col-1){
                    if(board[i][j] == 'O'){
                        Queue<Integer> q = new LinkedList<>();
                        board[i][j] = 'B';
                        q.add(i*col+j);
                        while(!q.isEmpty()){
                        	int cur = q.poll();
                        	int x = cur/col;
                        	int y = cur%col;
                        	if(y<col-1 && board[x][y+1] == 'O'){
                        		q.add(cur+1);
                        		board[x][y+1] = 'B';
                        	}
                        	if(x<row-1 && board[x+1][y] == 'O'){
                        		q.add(cur+col);
                        		board[x+1][y] = 'B';
                        	}
                        	if(y>=1 && board[x][y-1] == 'O'){
                        		q.add(cur-1);
                        		board[x][y-1] = 'B';
                        	}
                        	if(x>=1 && board[x-1][y] == 'O'){
                        		q.add(cur-col);
                        		board[x-1][y] = 'B';
                        	}
                        }
                    }
                }
            }
        }
        
        for(int i=0; i<row; i++)
        	for(int j=0; j<col; j++){
        		if(board[i][j] == 'O')
        			board[i][j] = 'X';
        		else if(board[i][j] == 'B')
        			board[i][j] = 'O';
        	}
    }
}