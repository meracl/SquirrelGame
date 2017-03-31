
public class GoodBeast extends Entity {
	final static int energy = 200;
	final static int id = 0;

	public GoodBeast(int x, int y) {
		super(id, energy, x, y);
	}

	public String toString() {
		return "GoodBeast mit ID: " + getId() + " Energy: " + getEnergy() + " Koordinaten x: " + getX() + " y: "
				+ getY();
	}
}
