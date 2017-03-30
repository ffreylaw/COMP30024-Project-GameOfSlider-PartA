package ai_parta;

import java.util.Scanner;

public class Main {
	
	private static Scanner reader;

	public static void main(String[] argv) {
		reader = new Scanner(System.in);
		
		int size = reader.nextInt();
		Board board = new Board(size);
		
		reader.nextLine();
		int row = 0;
		while (row < size && reader.hasNextLine()) {
			String line = reader.nextLine();
			for (int col = 0; col < line.length(); col++) {
				board.setBoard(row, col, line.charAt(col));
			}
			row++;
		}
		
		board.calculateLegalMoves();
		
		System.out.println(board.getNumLegalHMoves());
		System.out.println(board.getNumLegalVMoves());
	}
	
}
