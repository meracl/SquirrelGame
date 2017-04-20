public class Main {
	public static void main(String[] args) {
		Board board=new Board();
		State state=new State(board);
		Game game =new Game(state);
		game.run();
	}

}