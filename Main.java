public class Main {

	public static void main(String[] args) {
		EntitySet.createEntitys();
		while (true) {
			run();
		}
	}

	public static void run() {
		EntitySet.runAll();
	}
}