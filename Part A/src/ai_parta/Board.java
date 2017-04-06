package ai_parta;

import java.util.ArrayList;

public class Board {
	
	private Square[][] board;
	private int size;
	
	private ArrayList<HPiece> allHPieces;
	private ArrayList<VPiece> allVPieces;
	
	private int numLegalHMoves;
	private int numLegalVMoves;
	
	public Board(int size) {
		board = new Square[size][size];
		this.size = size;
		
		allHPieces = new ArrayList<HPiece>();
		allVPieces = new ArrayList<VPiece>();
		
		numLegalHMoves = 0;
		numLegalVMoves = 0;
	}
	
	public void setBoard(int x, int y, char ch) {
		Square square = null;
		switch (ch) {
		case 'H':
			square = new HPiece(x, y);
			allHPieces.add((HPiece) square);
			break;
		case 'V':
			square = new VPiece(x, y);
			allVPieces.add((VPiece) square);
			break;
		case 'B':
			square = new Block(x, y);
			break;
		case '+':
			square = new Square(x, y, true);
			break;
		default:
			break;
		}
		board[x][y] = square;
	}
	
	public void calculateLegalMoves() {
		numLegalHMoves = 0;
		numLegalVMoves = 0;
		
		for (HPiece h: allHPieces) {
			int i = h.getX();
			int j = h.getY();
			// up
			numLegalHMoves = i + 1 < size ? numLegalHMoves + (board[i+1][j].isEmpty() ? 1 : 0) : numLegalHMoves;
			// down
			numLegalHMoves = i - 1 >= 0 ? numLegalHMoves + (board[i-1][j].isEmpty() ? 1 : 0) : numLegalHMoves;
			// right
			numLegalHMoves = j + 1 < size ? numLegalHMoves + (board[i][j+1].isEmpty() ? 1 : 0) : numLegalHMoves;
			if (j + 1 == size) {
				numLegalHMoves += 1;
			}
		}
		
		for (VPiece v: allVPieces) {
			int i = v.getX();
			int j = v.getY();
			// up
			numLegalVMoves = i + 1 < size ? numLegalVMoves + (board[i+1][j].isEmpty() ? 1 : 0) : numLegalVMoves;
			// left
			numLegalVMoves = j - 1 >= 0 ? numLegalVMoves + (board[i][j-1].isEmpty() ? 1 : 0) : numLegalVMoves;
			// right
			numLegalVMoves = j + 1 < size ? numLegalVMoves + (board[i][j+1].isEmpty() ? 1 : 0) : numLegalVMoves;
			if (i + 1 == size) {
				numLegalVMoves += 1;
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
		for (int i = size - 1; i >= 0; i--) {
			for (int j = 0; j < size; j++) {
				str += board[i][j].toString();
			}
			str += '\n';
		}
		return str;
	}

}
