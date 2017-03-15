package ai_parta;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Board {
	
	private char[][] board;
	private int size;
	private int numLegalHMoves;
	private int numLegalVMoves;
	private HashMap<Character, Integer> legalPosMap;
	private Scanner reader;
	
	public Board() {
		legalPosMap = new HashMap<Character, Integer>();
		legalPosMap.put('H', 0);
		legalPosMap.put('V', 0);
		legalPosMap.put('B', 0);
		legalPosMap.put('+', 1);
		
		try {
			reader = new Scanner(new File("src/input.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		size = reader.nextInt();
		board = new char[size][size];
		
		reader.nextLine();
		int row = 0;
		while (reader.hasNextLine()) {
			String line = reader.nextLine();
			for (int col = 0; col < line.length(); col++) {
				board[row][col] = line.charAt(col);
			}
			row++;
		}
		
		calculateLegalMoves();
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
					numLegalHMoves = i - 1 >= 0 ? numLegalHMoves + legalPosMap.get(board[i-1][j]) : numLegalHMoves;
					numLegalHMoves = i + 1 < size ? numLegalHMoves + legalPosMap.get(board[i+1][j]) : numLegalHMoves;
					numLegalHMoves = j + 1 < size ? numLegalHMoves + legalPosMap.get(board[i][j+1]) : numLegalHMoves;
				}
				if (current == 'V') {
					numLegalVMoves = i - 1 >= 0 ? numLegalVMoves + legalPosMap.get(board[i-1][j]) : numLegalVMoves;
					numLegalVMoves = j - 1 >= 0 ? numLegalVMoves + legalPosMap.get(board[i][j-1]) : numLegalVMoves;
					numLegalVMoves = j + 1 < size ? numLegalVMoves + legalPosMap.get(board[i][j+1]) : numLegalVMoves;
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
