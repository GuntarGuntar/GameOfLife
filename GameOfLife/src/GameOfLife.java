
public class GameOfLife {
	boolean[][] board;
	boolean[][] newGen;
	int columns;
	int rows;
	int neighbours;
	
	public GameOfLife(int rows, int columns) {
		
		if (rows > 0 && columns > 0) 
		{
			this.columns = columns;
			this.rows = rows;
			board = new boolean[rows][columns];
			newGen = new boolean[rows][columns];
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

	public int getNeighbourCount(int y, int x) {
		int neighbourCount = 0;
		
		for (int i = y - 1; i < y + 2; i++) {
			for (int j = x - 1; j < x + 2; j++) {
				if (i == y && j == x) {}
				else {		
					try {
						if (board[i][j] == true) {
							neighbourCount += 1;
						}
					} catch (Exception exception) {
						int newI = i;
						int newJ = j;
						if (i >= board.length) {
							newI -= board.length;
						}
						else if (i < 0) {
							newI += board.length;
						}
						if (j >= board[newI].length) {
							newJ -= board[newI].length;
						}
						else if (j < 0) {
							newJ += board[newI].length;
						}
						if (board[newI][newJ] == true) {
							neighbourCount += 1;
						}
					}
				}
			}
		}
		
		return neighbourCount;
	}

	public boolean isAlive(int i, int j) {
		boolean isAlive = false;
		if (i > 0 && j > 0 && i < board.length && j < board.length) {
			isAlive = true;
		}
		else {
			isAlive = false;
		}
		return isAlive;
	}

	public void calculateNextGeneration() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (getNeighbourCount(i, j) >= 4) {
					newGen[i][j] = false;
				}
				else if(getNeighbourCount(i, j) < 4 && getNeighbourCount(i, j) > 1){
					newGen[i][j] = true;
				}
				else if (isAlive(i, j) == false && getNeighbourCount(i, j) == 3) {
					newGen[i][j] = true;
				}
				else {
					newGen[i][j] = false;
				}
				board[i][j] = newGen[i][j];
			}
		}
	}

	public void setAlive(int i, int j, boolean b) {
		try {
			board[i][j] = b;
		} catch (Exception e) {
		}
	}
	public String toString() {
		String output = "";
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (board[i][j] == true) {
					output += "*";
				}
				else {
					output += " ";
				}
				output += "\r\n";
			}
		}
		return output;
	}
}
