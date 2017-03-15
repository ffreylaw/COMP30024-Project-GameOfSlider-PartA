package ai_parta;


public class Main {
	
	public static void main(String[] argv) {
		Board board = new Board();
		System.out.println(board.getNumLegalHMoves());
		System.out.println(board.getNumLegalVMoves());
	}
	
}
