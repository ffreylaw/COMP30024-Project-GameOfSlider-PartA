package ai_parta;

public class Board {
	
	private Square[][] board;
	private int size;
	private int numLegalHMoves;
	private int numLegalVMoves;
	
	public Board(int size) {
		board = new Square[size][size];
		this.size = size;
		
		numLegalHMoves = 0;
		numLegalVMoves = 0;
	}
	
	public void setBoard(int row, int col, char ch) {
		Square square = null;
		switch (ch) {
		case 'H':
			square = new HPiece(row, col);
			break;
		case 'V':
			square = new VPiece(row, col);
			break;
		case 'B':
			square = new Block(row, col);
			break;
		case '+':
			square = new Square(row, col, true);
			break;
		default:
			break;
		}
		board[row][col] = square;
	}
	
	public void calculateLegalMoves() {
		numLegalHMoves = 0;
		numLegalVMoves = 0;
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				Square current = board[i][j];
				if (current instanceof Block || current.isEmpty()) {
					continue;
				}
				
				if (current instanceof HPiece) {
					numLegalHMoves = i - 1 >= 0 ? numLegalHMoves + (board[i-1][j].isEmpty() ? 1 : 0) : numLegalHMoves;
					numLegalHMoves = i + 1 < size ? numLegalHMoves + (board[i+1][j].isEmpty() ? 1 : 0) : numLegalHMoves;
					numLegalHMoves = j + 1 < size ? numLegalHMoves + (board[i][j+1].isEmpty() ? 1 : 0) : numLegalHMoves;
				}
				if (current instanceof VPiece) {
					numLegalVMoves = i - 1 >= 0 ? numLegalVMoves + (board[i-1][j].isEmpty() ? 1 : 0) : numLegalVMoves;
					numLegalVMoves = j - 1 >= 0 ? numLegalVMoves + (board[i][j-1].isEmpty() ? 1 : 0) : numLegalVMoves;
					numLegalVMoves = j + 1 < size ? numLegalVMoves + (board[i][j+1].isEmpty() ? 1 : 0) : numLegalVMoves;
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
				str += board[i][j].toString();
			}
			str += '\n';
		}
		return str;
	}

}
