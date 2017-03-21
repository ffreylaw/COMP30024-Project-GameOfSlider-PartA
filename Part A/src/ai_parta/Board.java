package ai_parta;

public class Board {
	
	private char[][] board;
	private int size;
	private int numLegalHMoves;
	private int numLegalVMoves;
	
	public Board(int size) {
		board = new char[size][size];
		this.size = size;
		
		numLegalHMoves = 0;
		numLegalVMoves = 0;
	}
	
	public void setBoard(int row, int col, char ch) {
		board[row][col] = ch;
	}
	
	public void calculateLegalMoves() {
		numLegalHMoves = 0;
		numLegalVMoves = 0;
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				char current = board[i][j];
				if (current == 'B' || current == '+') {
					continue;
				}
				
				if (current == 'H') {
					numLegalHMoves = i - 1 >= 0 ? numLegalHMoves + (board[i-1][j] == '+' ? 1 : 0) : numLegalHMoves;
					numLegalHMoves = i + 1 < size ? numLegalHMoves + (board[i+1][j] == '+' ? 1 : 0) : numLegalHMoves;
					numLegalHMoves = j + 1 < size ? numLegalHMoves + (board[i][j+1] == '+' ? 1 : 0) : numLegalHMoves;
				}
				if (current == 'V') {
					numLegalVMoves = i - 1 >= 0 ? numLegalVMoves + (board[i-1][j] == '+' ? 1 : 0) : numLegalVMoves;
					numLegalVMoves = j - 1 >= 0 ? numLegalVMoves + (board[i][j-1] == '+' ? 1 : 0) : numLegalVMoves;
					numLegalVMoves = j + 1 < size ? numLegalVMoves + (board[i][j+1] == '+' ? 1 : 0) : numLegalVMoves;
				}
			}
		}
	}
	
	public int getNumLegalHMoves() {
		return numLegalHMoves;
	}
	
	public int getNumLegalVMoves() {
		return numLegalVMoves;
	}
	
	@Override
	public String toString() {
		String str = new String();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				str += board[i][j];
			}
			str += '\n';
		}
		return str;
	}

}
