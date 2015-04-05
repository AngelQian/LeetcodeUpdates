public class Solution {
    public boolean isValidSudoku(char[][] board) {
		// detect row/column
		for (int i = 0; i < board.length; i++) {
			HashSet<Character> line1 = new HashSet<Character>();
			for (int j = 0; j < board.length; j++) {
				if (!validate(line1, board[i][j]))
					return false;
			}

			HashSet<Character> line2 = new HashSet<Character>();
			for (int j = 0; j < board.length; j++) {
				if (!validate(line2, board[j][i]))
					return false;
			}
		}
		// detect square
		for (int r = 0; r < 3; r++)// 0,1,2
		{
			for (int c = 0; c < 3; c++) {
				HashSet<Character> line = new HashSet<Character>();
				for (int i = r * 3; i < r * 3 + 3; i++)
					for (int j = c * 3; j < c * 3 + 3; j++)
						if (!validate(line, board[i][j]))
							return false;
			}
		}

		return true;
	}

	private boolean validate(HashSet<Character> line, Character c) {
		if(line.contains(c) && Character.isDigit(c))
			return false;
		
		line.add(c);
		return true;
	}
}