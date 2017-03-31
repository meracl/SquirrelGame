
public class MinniSquirrel extends Entity {
	final static int id = 6;

	public MinniSquirrel(int energy, int x, int y) {
		super(id, energy, x, y);
	}

	public String toString() {
		return "MinniSquirrel mit ID: " + getId() + " Energy: " + getEnergy() + " Koordinaten x: " + getX() + " y: "
				+ getY();
	}
}
