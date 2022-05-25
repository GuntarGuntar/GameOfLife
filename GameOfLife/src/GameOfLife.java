
public class GameOfLife {
	boolean[][] board;
	int columns;
	int rows;
	int neighbours;
	
	public GameOfLife(int rows, int columns) {
		
		if (rows > 0 && columns > 0) 
		{
			this.columns = columns;
			this.rows = rows;
		}
	}

	public Object getColumns() {
		return columns;
	}

	public Object getRows() {
		return rows;
	}

	public Object getNeighbourCount(int r, int c) {
		int count = 0;
//		int i, j;
//		for(i = r - 1; i <= r + 1; i++){
//	        for(j = c - 1; j <= c + 1; j++){
//	            if((i == r && j == c) || (i < 0 || j < 0) || (i >= rows || j >= columns)){
//	                continue;
//	            }
//	            if(board [i][j] == true){
//	                count++;
//	                neighbours += count;
//	            }
//	        }
//	    }
		for (int i = 0; i <= r; i++) {
			for (int j = 0; j <= c; j++) {
				if (board[i][j] == true) 
				{
					count += 1;
					neighbours += count;
				}
				else 
				{
					neighbours += count;
				}


			}
		}
		return count;
	} 
	
	public boolean isAlive(int i, int j) {
		boolean isAlive = false;
		if (neighbours > 3 || neighbours < 2) {
			isAlive = false;
		}
		else 
		{
		isAlive = true;
		}
		return isAlive;
	}

	public void calculateNextGeneration() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (isAlive(i, j) == true) {
					board[i][j] = true;
				}
				else
				{
					board[i][j] = false;
				}
			}
		}
		
	}

	public void setAlive(int i, int j, boolean b) {
		// TODO Auto-generated method stub
		
	}

}
