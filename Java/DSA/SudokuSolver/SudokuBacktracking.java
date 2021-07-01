class SudokuBacktracking {
    public void solveSudoku(char[][] board) {
        solve(0,0,board);
    }
	//We are going to traverse each column in the row before going for the next row
    public boolean solve(int row,int col,char[][] board){
		if(col == board.length){
			//All the columns of the current row has been traversed
			
			if(row == board.length-1){
				//End of the sudoku matrix
				return true;
			}
			//Otherwise
			row++;
			col = 0;
		}
		if(board[row][col] != '.'){
			//If the current entry is already filled
			return solve(row,col+1,board);
		}
		
		for(int i = 1;i<10;i++){
			//Check all the possible digits
			if(isValid(i,row,col,board)){
				//found a valid digit then move ahead to the next column
				board[row][col] = Character.forDigit(i,10);
				if(solve(row,col+1,board)){
					return true;
				}
			}
		}
		//If the current entry is inValid, replace with zero and return false
		board[row][col] = '.';
		return false;
	}
    public boolean isValid(int value, int row,int col, char[][] board){
		boolean rowIsValid = true;
		boolean colIsValid = true;
        char digit = Character.forDigit(value,10);
		for(int i = 0;i<9;i++){
			//Check if valid in row
			if(digit == board[row][i]){
				rowIsValid = false;
				break;
			}
			//Check if valid in column
			if(digit == board[i][col]){
				colIsValid = false;
				break;
			}
		}
		if(!rowIsValid || !colIsValid){
			return false;
		}
		int subgridrow = row / 3;
		int subgridcol = col /3;
		
		//Check if valid in 3x3 grid
		for(int i = 0;i<3;i++){
			for(int j = 0;j<3;j++){
				int currRow = subgridrow * 3 + i;
				int currCol = subgridcol * 3 + j;
                
				if(digit == board[currRow][currCol]){
					return false;
				}
			}
		}
		return true;
	}
}
	
