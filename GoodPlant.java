
public class GoodPlant extends Entity {
	final static int energy = 100;
	final static int id = 2;

	public GoodPlant(int x, int y) {
		super(id, energy, x, y);
	}

	public String toString() {
		return "GoodPlant mit ID: " + getId() + " Energy: " + getEnergy() + " Koordinaten x: " + getX() + " y: "
				+ getY();
	}
}
