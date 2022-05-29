
public class GameOfLife {
	private boolean[][] board;
	int columns;
	int rows;
	int neighbours;
	
	public GameOfLife(int rows, int columns) {
		
		if (rows > 0 && columns > 0) 
		{
			this.columns = columns;
			this.rows = rows;
		}
		else 
		{
			throw new IllegalArgumentException();
		}
	}

	public int getColumns() {
		return columns;
	}

	public int getRows() {
		return rows;
	}

	public int getNeighbourCount(int r, int c) {
		int count = 0;
		for (int i = rows - 1; i <= rows + 1; i++) {
			for (int j = columns - 1; j <= columns; j++) {
				if (!(i == rows && j == columns)) {
					if (board[i][j] = true) 
					{
						count++;
					}
					else 
					{
					}
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

