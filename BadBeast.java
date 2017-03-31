
public class BadBeast extends Entity {
	final static int energy = -150;
	final static int id = 1;

	public BadBeast(int x, int y) {
		super(id, energy, x, y);
	}

	public String toString() {
		return "BadBeast mit ID: " + getId() + " Energy: " + getEnergy() + " Koordinaten x: " + getX() + " y: "
				+ getY();
	}
}
