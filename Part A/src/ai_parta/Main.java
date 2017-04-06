package ai_parta;

import java.util.Scanner;

public class Main {
	
	private static Scanner reader;

	public static void main(String[] argv) {
		reader = new Scanner(System.in);
		
		int size = reader.nextInt();
		Board board = new Board(size);
		
		reader.nextLine();
		
		int i = size - 1;
		while (i >= 0 && reader.hasNextLine()) {
			String line = reader.nextLine();
			for (int j = 0; j < line.length(); j++) {
				board.setBoard(i, j, line.charAt(j));
			}
			i--;
		}
		
		board.calculateLegalMoves();
		
		System.out.println(board.getNumLegalHMoves());
		System.out.println(board.getNumLegalVMoves());
	}
	
}
