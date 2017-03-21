package ai_parta;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] argv) {
		Scanner reader = null;
		try {
			reader = new Scanner(new File("src/input.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int size = reader.nextInt();
		Board board = new Board(size);
		
		reader.nextLine();
		int row = 0;
		while (reader.hasNextLine()) {
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
