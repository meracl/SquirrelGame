
public class BadPlant extends Entity {
	final static int energy = -100;
	final static int id = 3;

	public BadPlant(int x, int y) {
		super(id, energy, x, y);
	}

	public String toString() {
		return "BadPlant mit ID: " + getId() + " Energy: " + getEnergy() + " Koordinaten x: " + getX() + " y: "
				+ getY();
	}
}
