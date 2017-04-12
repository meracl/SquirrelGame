public class Main {
	public static EntitySet game = new EntitySet();

	public static void main(String[] args) {
		game.createEntitys();
		while (true) {
			game.run();
		}
	}

}